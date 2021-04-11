package search.repository;

public interface PersonRepository {
    boolean addPerson(String person, int index);
    void searchPeople(String pattern);
    void printAllPeople();
}
