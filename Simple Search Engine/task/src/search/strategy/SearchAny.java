package search.strategy;

import search.model.Person;

import java.util.*;

public class SearchAny implements SearchingStrategy {
    @Override
    public void search(Map<String, List<Integer>> map, List<Person> personList, String pattern) {
        Set<Integer> resultIndex = new HashSet<>();

        Arrays.stream(pattern.split(" "))
                .filter(map::containsKey)
                .forEach( x -> resultIndex.addAll(map.get(x)));
        if (!resultIndex.isEmpty()) {
            System.out.println(resultIndex.size() + " persons found:");
            resultIndex.forEach( x -> System.out.println(personList.get(x)));
        } else {
            System.out.println("No matching people found.");
        }
    }
}
