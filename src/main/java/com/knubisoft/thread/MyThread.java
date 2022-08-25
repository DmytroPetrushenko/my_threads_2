package com.knubisoft.thread;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyThread extends Thread {
    private static List<MyThread> threadList = new ArrayList<>();
    private final Thread currentThread;
    private String input;

    public MyThread() {
        currentThread = this;
        threadList.add(this);
    }

    @Override
    @SneakyThrows
    public void run() {
        Listener listener = new Listener();
        listener.setDaemon(true);
        listener.start();
        sleep(5000);
    }

    class Listener extends Thread {
        @Override
        @SneakyThrows
        public void run() {
            while (true) {
                if (input != null) {
                    System.out.println(currentThread.getName() + " thread got message: " + input);
                    input = null;
                    threadList.stream()
                            .filter(thread -> !thread.equals(currentThread))
                            .forEach(thread -> thread.setInput(" Hello, " + thread.getName()
                                    + "!!! This is " + currentThread.getName() + ")))"));
                }
                sleep(100);
            }
        }
    }
}
