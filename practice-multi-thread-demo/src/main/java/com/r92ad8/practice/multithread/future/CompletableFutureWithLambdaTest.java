package com.r92ad8.practice.multithread.future;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureWithLambdaTest {
    public static void main(String[] args) {

        ExecutorService executor =Executors.newFixedThreadPool(10);
        List<Long> ids = new ArrayList<>();
        for (long i = 0; i <100 ; i++) {
            ids.add(i);
        }
        List<List<Long>> partitionList = Lists.partition(ids, 10);
        List<Long> finalIds = partitionList.stream().map(partition -> {
            List<CompletableFuture<Long>> completableFutures = partition.stream().map(id -> CompletableFuture.supplyAsync(() -> {
                    return new Random().nextLong();
            }, executor)).collect(Collectors.toList());
            List<Long> list = completableFutures.stream().map(CompletableFuture::join).filter(Objects::nonNull).collect(Collectors.toList());
            return list;
        }).flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(finalIds);
    }
}
