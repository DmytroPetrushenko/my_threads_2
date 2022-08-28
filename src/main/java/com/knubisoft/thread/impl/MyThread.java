package com.knubisoft.thread.impl;

import java.util.concurrent.SynchronousQueue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyThread extends Thread {
    private final SynchronousQueue<String> in;
    private final SynchronousQueue<String> out;
    private String event;

    public MyThread(SynchronousQueue<String> in, SynchronousQueue<String> out, String event) {
        this.in = in;
        this.out = out;
        this.event = event;

    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String take = in.take();
            System.out.println(take);
            out.put(event);
        }
    }

    @SneakyThrows
    public void sendMessage() {
        out.put(event);
    }
}
