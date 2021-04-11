package collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CollectionD {

    List<String> list = List.of("1","2","3");
    Set<String> set = Set.of("1","2","3");
    Map<String, Integer> map = Map.of("1",1, "2",2, "3", 3);

    Map<String, Integer> mapEntries = Map.ofEntries(entry("1",1),entry("2",2),entry("3",4),entry("4",4));

    public List<String> getList() {
        return list;
    }

    public Set<String> getSet() {
        return set;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public Map<String, Integer> getMapEntries() {
        return mapEntries;
    }
}
