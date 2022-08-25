package com.knubisoft.thread.impl;

import com.knubisoft.thread.MyThreadSynchronousQueue;
import lombok.SneakyThrows;

public class MyThreadB extends Thread implements MyThreadSynchronousQueue {
    private final String event = "PING";

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
