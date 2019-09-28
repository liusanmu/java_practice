package com.java.pattern.strategy.order;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 17:26
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.java.pattern.strategy.order";

    /**
     *
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
      /*(
      初始化一个大小合适的map集合，避免在向集合添加元素的时候，因为大小不合适而resize，
      每次resize都得执行以下步骤：再次去分配空间，再次去计算所以元素的hashcode，再次根据hashcode计算数组的分配位置，然后数组拷贝。
      这样就可以大大提升 在使用hashmap时候的性能。和不必要的空间浪费。
       */
        HashMap<String, Class> map = Maps.newHashMapWithExpectedSize(3);
        ClassScanner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            // 获取注解中的类型值
            String type = clazz.getAnnotation(HandlerType.class).value();
            // 将注解中的类型值作为key，对应的类作为value，保存在Map中
            map.put(type, clazz);
        });


    }
}
