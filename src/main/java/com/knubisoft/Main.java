package com.knubisoft;

import com.knubisoft.thread.impl.MyThreadA;
import com.knubisoft.thread.impl.MyThreadB;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MyThreadA threadA = new MyThreadA();
        MyThreadB threadB = new MyThreadB();
        threadA.start();
        threadB.start();
        Thread.sleep(500);
        threadB.sendMessage();
        Thread.sleep(2000);
        threadA.interrupt();
        threadB.interrupt();

    }
}
