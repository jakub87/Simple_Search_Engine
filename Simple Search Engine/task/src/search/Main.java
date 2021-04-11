package search;

import search.controler.PersonControler;
import search.menu.MainMenu;
import search.strategy.SearchingType;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonControler personControler = new PersonControler();
        Scanner scanner = new Scanner(System.in);
        personControler.addPeople(args[1]);

        int select;
        do {
            MainMenu.menu();
            select = Integer.parseInt(scanner.nextLine());
            if (select == 1) {
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                String strategy = scanner.nextLine();
                if (strategy.equals("ALL")) {
                    personControler.searchPeople(SearchingType.ALL);
                } else if (strategy.equals("ANY")) {
                    personControler.searchPeople(SearchingType.ANY);
                } else if (strategy.equals("NONE")) {
                    personControler.searchPeople(SearchingType.NONE);
                }
            } else if (select == 2) {
                 personControler.printAllPeople();
            } else if (select != 0){
                System.out.println("\nIncorrect option! Try again.");
            }
        }while (select != 0);
        System.out.println("\nBye!");
    }
}
