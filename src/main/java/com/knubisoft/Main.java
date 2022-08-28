package com.knubisoft;

import com.knubisoft.thread.impl.MyThread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.SneakyThrows;

public class Main {
    private static final String EVENT_1 = "PING";
    private static final String EVENT_2 = "PONG";
    private static final String EVENT_3 = "PANG";
    private static final int SIZE = 3;

    @SneakyThrows
    public static void main(String[] args) {
        List<String> events = List.of(EVENT_1, EVENT_2, EVENT_3);
        List<SynchronousQueue<String>> queueList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            queueList.add(new SynchronousQueue<>());
        }

        List<MyThread> myThreads = IntStream.range(0, SIZE).boxed()
                .map(num -> new MyThread(queueList.get(num),
                        queueList.get(getQueueNumber(num + 1)), events.get(num)))
                .collect(Collectors.toList());
        myThreads.forEach(Thread::start);

        Thread.sleep(500);
        myThreads.get(1).sendMessage();
        Thread.sleep(1000);
    }

    private static int getQueueNumber(Integer next) {
        return next == SIZE ? 0 : next;
    }
}
