import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class List_Map {
    public static void main() {
        List arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr);
        System.out.println(arr.get(0));
        arr.sort((a, b) -> (int) b - (int) a);
        System.out.println(arr);

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map);
        map.entrySet().forEach(e -> {
            System.out.println(e.getKey() + " -> " + e.getValue());
        });

    }
}
