package com.knubisoft.thread.impl;

import com.knubisoft.thread.MyThreadSynchronousQueue;
import lombok.SneakyThrows;

public class MyThreadA extends Thread implements MyThreadSynchronousQueue {
    private final String event = "PONG";

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String take = queue.take();
            System.out.println(take);
            queue.put(event);
        }
    }

    @Override
    @SneakyThrows
    public void sendMessage() {
        queue.put(event);
    }
}
