package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MultiThreadService {		
    private ExecutorService executor = Executors.newCachedThreadPool();
    private List<CompletableFuture<Void>> tasks = new ArrayList<>(1000);
    Assignment8 assignment = new Assignment8();
    
	public  List<Integer> deployThreads() {
        for (int i = 0; i < 1000; i++) {
            CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), executor)
            		.thenAcceptAsync(numbers -> assignment.addItems(numbers));
            tasks.add(task);
        }
        while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000)

        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        return assignment.getItems();
        //Collections.sort(allIntegers);
	}
}