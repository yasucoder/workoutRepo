package java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.math.BigDecimal;

public class Collectionsfeature {

	public static void foreacheg() {
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("A", 1);
		items.put("B", 2);
		items.put("C", 3);
		items.put("D", 4);
		items.put("E", 5);
		// for(Map.Entry<String, Integer> item : items.entrySet()){
		// System.out.println(item.getKey()+" : " + item.getValue());
		// }

		// items.forEach((k,v)->System.out.println("Item "+k+" : " + v));
		items.forEach((k, v) -> {
			System.out.println("Item " + k + " : " + v);

			if ("E".equals(k)) {
				System.out.println("Hello E");
			}

		});

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);

		list.forEach(listItem -> System.out.println(listItem));

		list.forEach(listItem -> {
			System.out.println(listItem);
			if (16 == listItem) {
				System.out.println("Found:" + listItem);
			}

		});
		Integer val = 2;
		List<String> itemList = new ArrayList<>();
		itemList.add("A");
		itemList.add("B");
		itemList.add("C");
		itemList.add("D");
		itemList.add("E");
		itemList.stream().filter(s -> s.contains("B"))
				.forEach(System.out::println);
	}

	public static void StreamEx1() {
		List<String> lines = Arrays.asList("spring", "node", "Application");
		List<String> result = getFilterOutput(lines, "Application");
		for (String temp : result) {
			System.out.println(temp); // output : spring, node
		}

		getFilterOutput_java8(lines, "Application");

	}

	private static List<String> getFilterOutput(List<String> lines,
			String filter) {
		List<String> result = new ArrayList<>();
		for (String line : lines) {
			if (!"Application".equals(line)) { // we dont like Application
				result.add(line);
			}
		}
		return result;
	}

	private static List<String> getFilterOutput_java8(List<String> lines,
			String filter) {
		List<String> list = lines.stream().filter(line -> !line.equals(filter))
				.collect(Collectors.toList());
		list.forEach(System.out::println);
		return list;
	}

	public static void StreamEx2() {
		List<Person> persons = Arrays.asList(new Person("Application", 30),
				new Person("jack", 20), new Person("lawrence", 40));

		Person result = persons
				.stream()
				.filter(p -> "Application".equals(p.getName())
						&& 20 == p.getAge()).findAny().orElse(null);

		System.out.println(result);

		Person result1 = persons.stream()
				.filter(person -> "check".equals(person.getName())).findAny()
				.orElse(null);
		System.out.println(result);

		String resultval = persons.stream()
				.filter(p -> "Application".equals(p.getName()))
				.map(Person::getName).findAny().orElse(null);

		System.out.println(result);

		List<String> names = persons.stream().map(Person::getName)
				.collect(Collectors.toList());

		names.forEach(System.out::println);

	}

	public static void StreamEx3() {
		// convert Stuff to stuffPublic

		List<Staff> staff = Arrays.asList(
				new Staff("Application", 30,new BigDecimal(10000)), 
				new Staff("jack", 27, new BigDecimal(20000)), 
				new Staff("lawrence", 33, new BigDecimal(30000)));

		List<StaffPublic> sp = staff.stream().map(s -> {

			StaffPublic sptem = new StaffPublic();
			sptem.setName(s.getName());
			sptem.setAge(s.getAge());
			if ("Application".equals(s.getName())) {
				sptem.setExtra("this field is for Application only!");
			}
			return sptem;
		}).collect(Collectors.toList());

		System.out.println(sp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StreamEx3();

	}

}
