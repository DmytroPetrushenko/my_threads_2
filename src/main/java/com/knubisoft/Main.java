package com.knubisoft;

import com.knubisoft.thread.impl.MyThread;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MyThread threadA = new MyThread();
        MyThread threadB = new MyThread();
        threadA.setEvent("PONG");
        threadB.setEvent("PING");
        threadA.start();
        threadB.start();
        Thread.sleep(500);
        threadB.sendMessage();
        Thread.sleep(2000);
        threadA.interrupt();
        threadB.interrupt();

    }
}
