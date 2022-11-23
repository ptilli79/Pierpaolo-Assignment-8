package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MultiThreadApp {

	public static void main(String[] args) {
		List<Integer> allIntegers = new ArrayList<>();		
     
        MultiThreadService thread = new MultiThreadService();
        allIntegers=thread.deployThreads();

        System.out.println("\nThe txt file has been converted to an ArrayList of: "+allIntegers.size()+" elements");
        Collections.sort(allIntegers);
        
        System.out.println("\nCounting duplicate numbers --> ");
        Map<Integer, Long> counterMap = allIntegers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(counterMap);
	}
}