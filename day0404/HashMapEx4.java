package day0404;

import java.util.*;
import java.util.Map.Entry;


public class HashMapEx4 {
	public static void main(String[] args) {
		String[]data = {"A","K","A","K","D","K","A","K","K","K","Z","D"};
		Map<Object, Object> map = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], value.intValue()+1);
			}else {
				map.put(data[i], 1);
			}
		}
		Iterator<?> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>)it.next();
			int value = ((Integer)entry.getValue());
			System.out.println(entry.getKey() + " : " + printBar('#',value) + " "+value);
		}
	}
	public static String printBar(char c,int v) {
		char[]bar = new char[v];
		for (int i = 0; i < bar.length; i++) {
			bar[i]=c;
		}
		return new String(bar);
	}
}
