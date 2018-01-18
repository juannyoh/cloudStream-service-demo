package com.dituhui.saas.websocket;


import java.util.concurrent.ArrayBlockingQueue;

public class LogCacheUtils {

    private static final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10000);

    public static void put(String msg) {
        queue.offer(msg);
    }

    /**
     * 获取日志，如果没取到，方法会阻塞
     * 
     * @return
     * @throws InterruptedException
     */
    public static String take() throws InterruptedException {
        return queue.take();
    }

}
