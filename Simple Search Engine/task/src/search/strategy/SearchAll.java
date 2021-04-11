package search.strategy;

import org.w3c.dom.ls.LSOutput;
import search.model.Person;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchAll implements SearchingStrategy {
    @Override
    public void search(Map<String, List<Integer>> map, List<Person> personList, String pattern) {
        List<Integer> resultIndex = new ArrayList<>();

        Arrays.stream(pattern.split(" "))
                .filter(map::containsKey)
                .forEach( x -> resultIndex.addAll(map.get(x)));

        Map<Integer, Long> filteredIndexMap = resultIndex.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (!filteredIndexMap.isEmpty()) {
            long counter = filteredIndexMap.entrySet().stream()
                    .filter(x -> x.getValue() == pattern.split(" ").length).count();

            System.out.println(counter + " persons found:");

            filteredIndexMap.entrySet().stream()
                    .filter( x -> x.getValue() == pattern.split(" ").length)
                    .forEach( x -> System.out.println(personList.get(x.getKey())));
        } else {
            System.out.println("No matching people found.");
        }
    }
}

