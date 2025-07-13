import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Maps {
    public static void main(String[] args) {
        Map<Integer,String> itemsMap = new HashMap<>();
        itemsMap.put(1,"item 1");
        itemsMap.put(2,"item 2");
        itemsMap.put(3,"item 3");
        itemsMap.put(4,"item 4");
        itemsMap.put(5,"item 5");
        itemsMap.put(6,"item 6");
        itemsMap.replaceAll((itemNo,itemName) -> "Item " + itemNo );
        itemsMap.replace(1,"Item 1","Item 0");
        itemsMap.forEach((itemNo, itemName) -> itemsMap.replace(itemNo,"The Item "+itemNo));
        List<String> itemsList = itemsMap.values().stream().toList();
        itemsList.forEach(System.out::println);
        itemsMap.forEach((itemNo, itemName) -> System.out.println(itemNo +" : "+ itemName));

        Map<String,Integer> occurancesMap = new HashMap<>();
        itemsMap.forEach((itemNo,itemName) ->{
            occurancesMap.put(itemName,occurancesMap.getOrDefault(itemName,0)+1);
        });

        occurancesMap.forEach((itemName,count) -> System.out.println(itemName +" : "+count));

        // have to fix this
        Map<String, Map<String, Integer>> itemCountMap = new HashMap<>();
       // itemsMap.forEach((itemNo,itemName)-> itemCountMap.put(itemName,occurancesMap.entrySet()));
    }
}