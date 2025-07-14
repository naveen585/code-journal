import java.util.*;
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
       // itemsList.forEach(System.out::println);
        //itemsMap.forEach((itemNo, itemName) -> System.out.println(itemNo +" : "+ itemName));

        Map<String,Integer> occurancesMap = new HashMap<>();
        itemsMap.forEach((itemNo,itemName) ->{
            occurancesMap.put(itemName,occurancesMap.getOrDefault(itemName,0)+1);
        });

       // occurancesMap.forEach((itemName,count) -> System.out.println(itemName +" : "+count));


        //practising Map of Map
        Map<String, Map<String, Integer>> itemCountMap = new HashMap<>();
        itemsMap.forEach((itemNo, itemName) -> itemCountMap.put(itemName,
                occurancesMap.entrySet().stream()
                        .filter(item -> item.getKey().startsWith(itemName))
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))));

        //System.out.println(itemCountMap.get("The Item 1"));
        //itemCountMap.forEach(((item, itemMap) -> System.out.println(item+" "+itemMap.get(item)+" ")));

        //Treemap vs Hashmap
        Map<String, String> hashMapEx = new HashMap<>();
        Map<String, String> treeMapEx = new TreeMap<>();
        hashMapEx.put("banana", "yellow");
        hashMapEx.put("apple", "red");
        hashMapEx.put("grape", "purple");
        treeMapEx.putAll(hashMapEx);
        System.out.println("Hash Map values: ");
        hashMapEx.forEach((itemName,itemColor)-> System.out.println(itemName+ " : " + itemColor));
        System.out.println("Tree Map values: ");
        treeMapEx.forEach((itemName,itemColor)-> System.out.println(itemName+ " : " + itemColor));

        //Count Word Frequency
        //input = hello world hello java
        String str = "hello world hello java";
        String[] strArr = str.toLowerCase().split(" ");
        Map<String,Integer> frequencyMap = new TreeMap<>();
        for(String s : strArr){
            frequencyMap.put(s,frequencyMap.getOrDefault(s,0)+1);
        }
        frequencyMap.forEach((word,count) -> System.out.println(word+" : "+count));

        //Character Frequency
        //input = hello world hello java
        char[] charArr = str.replaceAll(" ","").toCharArray();
        Map<Character, Integer> charFrequencyMap = new TreeMap<>();
        for(char c : charArr){
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c,0)+1);
        }
        charFrequencyMap.forEach((c,count)-> System.out.println(c+" : "+count));
        }
}