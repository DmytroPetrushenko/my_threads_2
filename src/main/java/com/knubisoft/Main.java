package com.knubisoft;

import com.knubisoft.thread.MyThread;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        MyThread myThreadOne = new MyThread();
        MyThread myThreadTwo = new MyThread();

        myThreadOne.start();
        myThreadTwo.start();
        myThreadOne.setInput("Let's go!");
    }
}
