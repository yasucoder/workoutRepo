package java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	List<String> liststr = Arrays.asList("1", "2");
	//eval(list, n->true);
	System.out.println("Even Number:");
	eval(list, n->n%2 == 0);
	System.out.println("Odd Number:");
	eval(list, n->n%2 == 1);
	System.out.println("Odd Number:");
	eval(list, n-> n>3);

	}
	
	public static void eval(List<Integer> list,Predicate<Integer> predicate){
		
		for(Integer n :list){
			if(predicate.test(n)){
				System.out.println(n+" ");
			}
		}
	}
	

}
