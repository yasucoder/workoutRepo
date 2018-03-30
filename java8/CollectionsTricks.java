package java8feature;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsTricks {	
	
	public static Map<String,String> readonlycollection(Map<String,String> mapper){
		
		return Collections.unmodifiableMap(mapper);
		
	}

	public static void main(String arg[]){
		Map<String,String> mapper = new HashMap<String,String>();
		Map<String,String> outmapper = new HashMap<String,String>();
		mapper.put("1", "First");
		mapper.put("2", "Second");
		outmapper = CollectionsTricks.readonlycollection(mapper);
		outmapper.remove("1");
	}
}
