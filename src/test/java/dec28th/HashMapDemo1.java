package dec28th;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		
		HashMap<String, String> hMap=new HashMap<String, String>();
		
		hMap.put("GM", "Ravi");
		hMap.put("AGM", "Sam");
		hMap.put("QA", "John");
		
		System.out.println(hMap);
		
		Set<Entry<String, String>> entries=hMap.entrySet();
		
		
		//for each loop
		
		for(Entry<String, String> entry:entries)
		{
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}

	}

}
