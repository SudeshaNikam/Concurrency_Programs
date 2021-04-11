package com.concurrency.concurrenthashMap;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

		map.put(8, "one");
		map.put(6, "Fourth");
		map.put(3, "Two");
		map.put(11, "Third");

		Iterator<ConcurrentHashMap.Entry<Integer, String>> itr = map.entrySet().iterator();

		while (itr.hasNext()) {
			ConcurrentHashMap.Entry<Integer, String> entry = itr.next();
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
}
