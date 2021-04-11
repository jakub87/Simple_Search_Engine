package search.strategy;

import search.model.Person;

import java.util.*;
import java.util.stream.IntStream;

public class SearchNone implements SearchingStrategy {
    @Override
    public void search(Map<String, List<Integer>> map, List<Person> personList, String pattern) {
        Set<Integer> resultIndex = new HashSet<>();
         Arrays.stream(pattern.split(" "))
                .filter(map::containsKey)
                .forEach( x -> resultIndex.addAll(map.get(x)));

        if (!resultIndex.isEmpty()) {
            System.out.println(personList.size() - resultIndex.size() + " persons found:");
            Set<Integer> tempSet = new HashSet<>();
            IntStream.range(0, personList.size()).forEach(tempSet::add);
            tempSet.removeAll(resultIndex);
            tempSet.forEach( x -> System.out.println(personList.get(x)));
        } else {
            System.out.println("No matching people found.");
        }





    }
}
