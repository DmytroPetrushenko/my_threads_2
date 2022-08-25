package com.knubisoft.thread.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.concurrent.SynchronousQueue;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyThread extends Thread {
    private static final SynchronousQueue<String> queue = new SynchronousQueue<>();
    private String event;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String take = queue.take();
            System.out.println(take);
            queue.put(event);
        }
    }

    @SneakyThrows
    public void sendMessage() {
        queue.put(event);
    }
}
