package com.lsm.collections.map.myhm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lsm
 * @description:
 * @create: 2020-02-21 0:43
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    // 定义默认数组大小
    private static int defaultLength = 1 << 4;
    // 扩容标准所使用的useSize / 数组长度 > 0.75
    // defaultAddSizeFactor过大，造成扩容率变低，存储徐爱 但是就是存和取效率低
    //有限的 数组长度空间位置会形成链表，在存或者取都需要进行大量的遍历和判断，还有会转化成红黑树

    private static float defaultAddSizeFactor = 0.75F;
    // 使用数组位置的总和
    private int useSize;
    //定义Map骨架只要数组之已 数组
    private Entry<K, V>[] table = null;


    // Spring 门面模式
    public MyHashMap() {
        this(defaultLength, defaultAddSizeFactor);
    }

    public MyHashMap(int length, float defaultAddSizeFactor1) {
        if (length < 0) {
            throw new IllegalArgumentException("参数不能为负数" + length);
        }
        if (defaultAddSizeFactor <= 0 || Float.isNaN(defaultAddSizeFactor)) {
            throw new IllegalArgumentException("扩容标准不能为负数" + defaultAddSizeFactor);
        }
        defaultLength = length;
        defaultAddSizeFactor = defaultAddSizeFactor1;
        table = new Entry[defaultLength];

    }

    class Entry<K, V> implements MyMap.Entry<K, V> {
        K k;
        V v;
        Entry<K, V> next;

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    @Override
    public V put(K k, V v) {
        if (useSize > defaultAddSizeFactor * defaultLength) {
            // 2倍的扩容
            up2Size();
        }
        int index = getIndex(k, table.length);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = new Entry<>(k, v, null);
            useSize++;
        } else {
            table[index] = new Entry<>(k, v, entry);
           // Entry<K,V> e = entry;
           /* while (e != null) {
                if (k == e.getKey() || k.equals(e.getKey())) {

                }

           */// }
        }

        return table[index].getValue();
    }

    //通过k table.length来获取下标
    private int getIndex(K k, int length) {
        // length 2^n    -1后会获取到很多0000 1111形式2进制
        int m = length - 1;
        //传入length是为了保证index在[0,length) 左闭右开
        int index = hash(k.hashCode()) & m;
        return index;
    }

    private void up2Size() {
        Entry<K, V>[] newTable = new Entry[2 * defaultLength];
        // 将老数组存的内容拿过来
        againHash(newTable);

    }

    private void againHash(MyHashMap<K, V>.Entry<K, V>[] newTable) {
        List<Entry<K, V>> entryList = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                continue;
            }
            //找到对象存入entryList
            foundEntryByNext(table[i], entryList);
        }
        if (entryList.size() > 0) {
            useSize = 0;
            defaultLength = 2 * defaultLength;
            table = newTable;
            for (Entry<K, V> kvEntry : entryList) {
                if (kvEntry.next != null) {
                    kvEntry.next = null;
                }
                //调用put方法
                put(kvEntry.getKey(), kvEntry.getValue());
            }
        }
    }

    private void foundEntryByNext(Entry<K, V> entry, List<Entry<K, V>> entryList) {

        if (entry != null && entry.next != null) {
            entryList.add(entry);
            foundEntryByNext(entry.next, entryList);
        } else {
            entryList.add(entry);
        }
    }

    /*
        static final int hash(Object key) {
            int h;
            // 为什么hashmap的键可以为空的原因，当key==null,则默认hash值=0
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }*/
    private int hash(int hashCode) {
        hashCode = hashCode ^ ((hashCode >>> 20) ^ (hashCode >>> 12));
        return hashCode ^ ((hashCode >>> 7) ^ (hashCode >>> 4));
    }

    @Override
    public V get(K k) {
        int index = getIndex(k, table.length);
        if (table[index] == null) {
            throw new NullPointerException();
        }
        //当key存在时
        return findValueByEqualKey(k, table[index]);
    }

    private V findValueByEqualKey(K k, Entry<K, V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            return findValueByEqualKey(k, entry.next);
        }
    }

    public int getUseSize() {
        return useSize;
    }
}
