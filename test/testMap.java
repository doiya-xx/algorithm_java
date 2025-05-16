import java.util.*;
import java.util.stream.Collectors;

public class testMap {
    public static void main(String[] args) {
        testMap test = new testMap();
        
        test.testMap();
        test.testListMap();
    }
    
    private void testListMap() {
        List<Map<String, Integer>> listOfMaps = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("table_name1", i + 1);
            listOfMaps.add(map);
        }
        for (int i = 0; i < 4; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("table_name2", i + 1);
            listOfMaps.add(map);
        }
        // 打印listMap
        System.out.println(listOfMaps);
        
        // 使用stream将listMap中的map合并成一个map
        Map<String, Set<Integer>> resultMap = listOfMaps.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));
        
        // 打印合并后的map
        System.out.println(resultMap);
    }
    
    private void testMap() {
        Map<String, String> maps = new HashMap<>();
        maps.put("table_name1", "1, 2, 3, 4");
        maps.put("table_name2", "5, 6, 7, 8");
        
        System.out.println("maps = " + maps);
        
        Map<String, Set<Integer>> resultMap = maps.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> Arrays.stream(e.getValue().split(", "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toSet())
                ));
        
        System.out.println(resultMap);
    }
}
