package com.coderscampus.assignment8;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Assignment8Test {
	
	List<Integer> allIntegers = new ArrayList<>();	

	@Test
	public void should_return_1000000_items_multi_threaded () {
			
	     
        MultiThreadService thread = new MultiThreadService();
        allIntegers=thread.deployThreads();
        assertEquals(1000000,allIntegers.size());
	}
	
	
	@Test
    public void should_return_1000000_items_single_threaded () {

        Assignment8 assignment = new Assignment8();
 
        for (int i=0; i<1000; i++) {
            List<Integer> numbersList = assignment.getNumbers();
            //System.out.println(numbersList);
            allIntegers.addAll(numbersList);
        }
        
        assertEquals(1000000,allIntegers.size());
    }
}
