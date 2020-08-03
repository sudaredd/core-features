package com.util;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HeapSizeDifferences {

	  static Collection<Object> objects = new ArrayList<Object>();
	  static long lastMaxMemory = 0;

	  public static void main(String[] args) {
	    try {
	      List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
	      System.out.println("Running with: " + inputArguments);
	      while (true) {
	        printMaxMemory();
	        consumeSpace();
	        printMaxMemory();
	      }
	    } catch (OutOfMemoryError e) {
	      freeSpace();
	      printMaxMemory();
	      e.printStackTrace();
	    }
	    System.out.println("....continuing....");
	    for(int i=0; i<10000;i++) {
	    	if(i==9999)System.out.println("test");
	    }
	    printMaxMemory();
	  }

	  static void printMaxMemory() {
	    long currentMaxMemory = Runtime.getRuntime().maxMemory();
	      System.out.format("Runtime.getRuntime().maxMemory(): %,dK.%n", currentMaxMemory / 1024);

	    /*if (currentMaxMemory != lastMaxMemory) {
	      lastMaxMemory = currentMaxMemory;
	      System.out.format("Runtime.getRuntime().maxMemory(): %,dK.%n", currentMaxMemory / 1024);
	    }*/
	  }

	  static void consumeSpace() {
	    objects.add(new int[1_000_000]);
	  }

	  static void freeSpace() {
	    objects.clear();
	  }
	}
