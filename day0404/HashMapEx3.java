package day0404;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) {
			phoneBook.put(groupName, new HashMap<>());
		}
	}
	static void addPhoneNo(String gN , String n , String tel) {
		addGroup(gN);
		HashMap group = (HashMap)phoneBook.get(gN);
		group.put(tel, n);
	}
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println(" * "+e.getKey() + "["+subSet.size()+"]");
			while (subIt.hasNext()) {
				Map.Entry subeE = (Map.Entry)subIt.next();
				String t = (String)subeE.getKey();
				String n = (String)subeE.getValue();
				System.out.println(n+ " "+t);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "000-0000-0000");
		addPhoneNo("친구", "김자바", "111-1111-1111");
		addPhoneNo("친구", "김자바", "222-2222-2222");
		addPhoneNo("회사", "김대리", "333-3333-3333");
		addPhoneNo("회사", "김대리", "444-4444-4444");
		addPhoneNo("회사", "박대리", "555-5555-5555");
		addPhoneNo("회사", "이과장", "666-6666-6666");
		addPhoneNo("세탁", "010-7777-7777");
		printList();
		
		
	}
}
