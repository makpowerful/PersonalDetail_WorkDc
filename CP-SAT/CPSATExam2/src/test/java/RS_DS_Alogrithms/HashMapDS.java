package RS_DS_Alogrithms;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HashMapDS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// HASH MAP
	//	O(1)  [key, value]
		//Default Capacity is 16-    Size -  4
		//Load Factor - 0.75% ~ 12
		//Threshold ->  Capacity * Load factor= 192 => Rehased
		//Size
		String a = "rahul";
		System.out.println(a.hashCode());
		// 0
		HashMap<Integer,String>  map = new HashMap<Integer,String>();
		map.put(2134, "ram");
		map.put(123, "tim");
		map.put(43, "Tom");
		map.put(6464, "Sam");
		
		System.out.println(map.get(43));
		
//	Set<Entry<Integer,String>>	entrySet = map.entrySet();
//	
//	for(Entry<Integer,String> entry : entrySet)
//	{
//		System.out.println(entry.getKey()+   entry.getValue());
//	}
	
	HashMap<Integer,String>  map1 = new HashMap<Integer,String>();
	map1.put(9990, "Sam");
	map1.put(9990, "hello");
	
	map1.putAll(map);
	Set<Entry<Integer,String>>	entrySet = map1.entrySet();
	map1.remove(9990);
	map1.replace(43, "Tam");
	for(Entry<Integer,String> entry : entrySet)
	{
		System.out.println(entry.getKey()+   entry.getValue());
	}
	
	Set<Integer> keySet = map1.keySet();
	
	for(Integer key : keySet)
	{
		System.out.println(key);
	}
	
	System.out.println(map1.containsKey(420));
	System.out.println(map1.containsValue("rahul"));
	System.out.println(map1.containsValue("hello"));
	System.out.println(map1.size()); 
	//map1.clear();
	
	TreeMap sortedHashMap = new TreeMap(map1);
	
	System.out.println("Sorted data"+sortedHashMap);
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	}

}
