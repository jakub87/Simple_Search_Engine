package search.strategy;

import search.model.Person;

import java.util.List;
import java.util.Map;

public interface SearchingStrategy {
    void search(Map<String, List<Integer>> map, List<Person> personList, String pattern);
}
