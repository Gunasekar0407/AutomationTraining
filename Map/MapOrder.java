package Map;
import java.util.*;

public class MapOrder {
	 public void hashMapOrder() {
	        Map<Integer, String> hashMap = new HashMap<>();
	        hashMap.put(92, "Warner");
	        hashMap.put(67, "Powell");
	        hashMap.put(62, "Pooran");
	        hashMap.put(42, "Markram");
	        hashMap.put(26, "Pant");
	        System.out.println("Insertion Order of HashMap" + hashMap);
	    }

	    public void linkedHashMapOrder() {
	        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
	        linkedHashMap.put(92, "Warner");
	        linkedHashMap.put(67, "Powell");
	        linkedHashMap.put(62, "Pooran");
	        linkedHashMap.put(42, "Markram");
	        linkedHashMap.put(26, "Pant");
	        System.out.println("Insertion Order of LinkedHashMap" + linkedHashMap);
	    }

	    public void treeMapOrderOne() {
	        Map<Integer, String> treeMap = new TreeMap<Integer, String>();
	        treeMap.put(92, "Warner");
	        treeMap.put(67, "Powell");
	        treeMap.put(62, "Pooran");
	        treeMap.put(42, "Markram");
	        treeMap.put(26, "Pant");
	        try {
	            treeMap.put(null, "null");
	        } catch (NullPointerException exception){
	            System.out.println(exception.getMessage());
	        }
	        System.out.println("Insertion Order of TreeMap" + treeMap);
	        Map<Integer, String> reverse=((TreeMap<Integer, String>) treeMap).descendingMap();
	        for (Map.Entry<Integer, String> entry : reverse.entrySet()){
	            System.out.println("Insertion Order of treeSet in Descending Order" + entry.getKey() + " " + entry.getValue());
	        }
	        //Reverse Order Using For while.
	        Map<Integer, String> treeMap1 = new TreeMap<>(Collections.reverseOrder());
	        treeMap1.putAll(treeMap);
	        Set set = treeMap1.entrySet();
	        Iterator iterator = set.iterator();
	        while (iterator.hasNext()) {
	            Map.Entry me = (Map.Entry) iterator.next();
	            System.out.println("Insertion Order of treeSet in Descending Order" + me.getKey() + " " + me.getValue());
	        }
	        // Reverse Order Using For Loop.
	        Map<Integer, String> treeMap2 = new TreeMap<Integer, String>();
	        treeMap2.putAll(treeMap);
	        ArrayList<Integer> keys = new ArrayList<Integer>(treeMap2.keySet());
	        for (int count = keys.size() - 1; count >= 0; count--) {
	            System.out.println("Insertion Order of treeSet in Descending Order" + keys.get(count));
	        }
	        //Reverse Order Using For descendingkeyset(Only Intergers).
	        NavigableSet keySet = ((TreeMap<Integer, String>) treeMap).descendingKeySet();
	        System.out.println("Insertion Order of treeSet in Descending Order: " + keySet);
	        //Reverse Order Using For DescendingMap Method.
	        NavigableMap keyMap = ((TreeMap<Integer, String>) treeMap).descendingMap();
	        System.out.println("Insertion Order of treeSet in Descending Order: " + keyMap);
	    }

	    public static void main(String[] args) {
	        MapOrder mapOrder = new MapOrder();
	        mapOrder.hashMapOrder();
	        mapOrder.linkedHashMapOrder();
	        mapOrder.treeMapOrderOne();
	    }

}
