package com.concurrentModificationException.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ConcurrenyModificationExcepExample {

	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "Sudesha");
		map.put(2, "vanita");
		map.put(3, "shital");
		map.put(4, "Teju");
		map.put(5, "Shweta");

		Iterator<Entry<Integer, String>> it1 = map.entrySet().iterator();

		while (it1.hasNext()) {
			Entry<Integer, String> entry = it1.next();
			Integer key = entry.getKey();
			
			if (key.equals(3)) {
				map.remove(key);
			} else {
				System.out.println(entry.getKey() + " \t " + entry.getValue());
			}
		}
	}
}
