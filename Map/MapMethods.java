package Map;
import java.util.*;

public class MapMethods {
	public void methods() {
        LinkedHashMap<String, Integer> runs = new LinkedHashMap<String, Integer>();
        runs.put("Warner", 92);
        runs.put("Powell", 67);
        runs.put("Pooran", 62);
        runs.put("Markram", 42);
        runs.put("Pant", 26);
        System.out.println(runs);
        // Check the key is present or not
        if (runs.containsKey("Pooran")) {
            System.out.println("Pooran name is present in the LinkedHashMap.");
        }
        //Getting Value for key
        System.out.println("Getting Run for Pant: " + runs.get("Pant"));
        // Checking Map is Empty
        if (runs.isEmpty()) {
            System.out.println("Map is Empty");
        } else {
            System.out.println(" Map is Not Empty" + runs);
        }
        // Deleting element of Markram
        System.out.println("Delete info of Markram" + runs.remove(42));
        // Inserting element if not present already
        runs.putIfAbsent("Marsh", 10);
        runs.putIfAbsent("Pant", 26);
        //  providing value for new key which is absent
        runs.computeIfAbsent("Kane", Key -> 4);
        System.out.println(" After adding new player runs" + runs);

        // providing new value for keys which is present
        runs.computeIfPresent("Pooran", (Key, Value) -> Value + 1);
        System.out.println("After adding One Run" + runs);
        // size of map
        System.out.println("Size of Map:" + runs.size());
        // Using values() to get the values of map
        System.out.println("The collection of value is: " + runs.values());
        // replaceAll method to replace value
        runs.replaceAll((Key, Value) -> Value - Value);
        System.out.println("After Replacing values" + runs);
    }

    public static void main(String[] args) {
        MapMethods mapMethods = new MapMethods();
        mapMethods.methods();
    }
}
