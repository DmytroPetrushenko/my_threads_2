package com.knubisoft.thread;

import java.util.concurrent.SynchronousQueue;

public interface MyThreadSynchronousQueue {
    static final SynchronousQueue<String> queue = new SynchronousQueue<>();

    void sendMessage();
}
