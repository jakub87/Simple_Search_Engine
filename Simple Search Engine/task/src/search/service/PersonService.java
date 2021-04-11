package search.service;

import search.model.Person;
import search.repository.PersonRepository;
import search.strategy.SearchingStrategy;
import java.util.*;

public class PersonService implements PersonRepository {

    private List<Person> personList;
    private Map<String, List<Integer>> map;
    private SearchingStrategy searchingStrategy;

    public void setSearchingStrategy(SearchingStrategy searchingStrategy) {
        this.searchingStrategy = searchingStrategy;
    }

    public PersonService() {
        personList = new ArrayList<>();
        map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public boolean addPerson(String person, int index) {
        String[] personDetails = person.split(" ");
        if (personDetails.length == 2) {
            personList.add(new Person(personDetails[0], personDetails[1]));
        } else {
            personList.add(new Person(personDetails[0], personDetails[1], personDetails[2]));
        }
        createInvertedIndex(personDetails, index);
        return true;
    }

    private void createInvertedIndex(String [] personDetails, int index) {
        for (int i = 0; i < personDetails.length; i++) {
            if (map.containsKey(personDetails[i])) {
                List<Integer> list = map.get(personDetails[i]);
                list.add(index);
                map.replace(personDetails[i], list);
            } else {
                map.put(personDetails[i], new ArrayList<>(List.of(index)));
            }
        }
    }

    @Override
    public void searchPeople(String pattern) {
        searchingStrategy.search(map, personList, pattern);
    }

    @Override
    public void printAllPeople() {
        System.out.println("\n=== List of people ===");
        personList.forEach(System.out::println);
    }

    public void showMAp() {
        map.forEach( (x, y) -> System.out.println( x + " -> " + y));
    }
}
