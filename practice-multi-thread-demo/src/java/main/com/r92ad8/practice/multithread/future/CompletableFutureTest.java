package com.r92ad8.practice.multithread.future;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            return "task1";
        }, executorService);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            return "task2";
        }, executorService);
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            return "task3";
        }, executorService);
        CompletableFuture<String> task4 = CompletableFuture.supplyAsync(() -> {
            return "task4";
        }, executorService);
        CompletableFuture.allOf(task1,task2,task3,task4);


    }
}
