package search.controler;

import search.service.PersonService;
import search.strategy.SearchAll;
import search.strategy.SearchAny;
import search.strategy.SearchNone;
import search.strategy.SearchingType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class PersonControler {
    private PersonService personService;
    private Scanner scanner;

    public PersonControler() {
        personService = new PersonService();
        scanner = new Scanner(System.in);
    }

    public void addPeople(String pathFile) {
       try {
          List<String> peopleList = Files.readAllLines(Paths.get(pathFile));
          for (int i = 0; i < peopleList.size(); i++) {
                personService.addPerson(peopleList.get(i), i);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchPeople(SearchingType searchType) {
        System.out.println("Enter a name or email to search all suitable people.");
        String pattern = scanner.nextLine();
        if (searchType == SearchingType.ALL) {
            personService.setSearchingStrategy(new SearchAll());
            personService.searchPeople(pattern);
        } else if (searchType == SearchingType.ANY) {
            personService.setSearchingStrategy(new SearchAny());
            personService.searchPeople(pattern);
        } else if (searchType == SearchingType.NONE) {
            personService.setSearchingStrategy(new SearchNone());
            personService.searchPeople(pattern);
        }
    }

    public void printAllPeople() {
        personService.printAllPeople();
    }

    public void show() {
        personService.showMAp();
    }

}
