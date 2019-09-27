package com.java.pattern.observer.mouse;

import com.java.pattern.observer.core.Event;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 13:58
 */
public class MouseEventCallback {


    public void onClick(Event e) {
        System.out.println("这是鼠标单击以后要执行的逻辑");
        System.out.println("=======触发鼠标单击事件========\n" + e);
    }

    public void onDoubleClick(Event e) {
        System.out.println("=======触发鼠标双击事件========\n" + e);
    }

    public void onUp(Event e) {
        System.out.println("=======触发鼠标弹起事件========\n" + e);
    }

    public void onDown(Event e) {
        System.out.println("=======触发鼠标按下事件========\n" + e);
    }

    public void onMove(Event e) {
        System.out.println("=======触发鼠标移动事件========\n" + e);
    }

    public void onWheel(Event e) {
        System.out.println("=======触发鼠标滚动事件========\n" + e);
    }

    public void onOver(Event e) {
        System.out.println("=======触发鼠标悬停事件========\n" + e);
    }


}
