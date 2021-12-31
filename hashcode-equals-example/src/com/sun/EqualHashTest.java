package com.sun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EqualHashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person(11,"Sunny", 32);
		Person p2 = new Person(22,"Raihan", 40);
		Person p3 = new Person(33,"Miran", 36);
		Person p4 = new Person(11,"Sunny", 32);
		
		System.out.println("p1.hashCode(): "+p1.hashCode());
		System.out.println("p2.hashCode(): "+p2.hashCode());
		System.out.println("p3.hashCode(): "+p3.hashCode());
		System.out.println("p4.hashCode(): "+p4.hashCode());
		
		HashSet<Person> pSet = new HashSet<>();
		pSet.add(p1);
		pSet.add(p2);
		pSet.add(p3);
		pSet.add(p4);
		pSet.forEach(p->System.out.println("Hashset: "+p));
		
		HashMap<Person, Person> pMap = new HashMap<>();
		pMap.put(p1, p1);
		pMap.put(p2, p2);
		pMap.put(p3, p3);
		pMap.put(p4, p4);
		
		/*for(Map.Entry<Person, Person> person : pMap.entrySet()){
			System.out.println("Key: "+person.getKey()+" value: "+person.getValue());
		}*/
		
		pMap.forEach((k,v)->System.out.println("key: "+k+" value: "+v));
	}

}
