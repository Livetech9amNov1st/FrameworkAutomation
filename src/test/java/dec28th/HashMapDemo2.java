package dec28th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		
		HashMap<String, String> hMap=new HashMap<String, String>();
		
		hMap.put("GM", "Ravi");
		hMap.put("AGM", "Sam");
		hMap.put("QA", "John");
		
		System.out.println(hMap);
		
		Set<Entry<String, String>> entries=hMap.entrySet();
		
		
		//iterator
		
		Iterator<Entry<String, String>> it=entries.iterator();
		
		Entry<String, String> entry=null;
		
		while(it.hasNext())
		{
			entry=it.next();
			
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
		
	}
}
