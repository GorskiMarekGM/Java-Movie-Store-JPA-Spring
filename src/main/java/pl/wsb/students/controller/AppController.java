package pl.wsb.students.controller;

import pl.wsb.students.model.Customer;
import pl.wsb.students.model.Movie;
import pl.wsb.students.model.Transaction;
import pl.wsb.students.service.StoreManager;
import pl.wsb.students.view.Menu;

import java.util.Scanner;

public class AppController {

    public static void run(StoreManager storeManager) {
        if (storeManager == null) {
            System.err.println("There is no store manager in place... We cannot open the store.");
            return;
        }   //if
        Menu menu = new Menu();
        initMenu(storeManager, menu);
        menu.printMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.handleAction(scanner.next());
            System.out.printf("%nWhat would you like to do next?%n");
            menu.printMenu();
        }   //while
    }

    private static void initMenu(StoreManager storeManager, Menu menu) {
        if (storeManager == null) {
            System.err.println("There is no menu to init...");
            return;
        }   //if
        menu.addMenuItem(
                "1",
                "Sell a movies",
                () -> {
                    Customer customer = new Customer();
                    storeManager.sell(customer);
                    storeManager.sell(customer);
                    storeManager.sell(customer);
                    System.out.printf("Movies sold... customer loyalty points: %s %n", customer.getPoints());
                }
        );
        menu.addMenuItem(
                "2",
                "Display transactions",
                () -> {
                    for (Transaction transaction: storeManager.getTransactions()) {
                        System.out.printf("Transaction amount: %s %n", transaction.getAmount());
                    }   //for
                }
        );
        menu.addMenuItem(
                "3",
                "Display movies",
                () -> {
                    for (Movie movie: storeManager.getMovies()) {
                        System.out.printf("Movie title: %s, stock: %s %n", movie.getTitle(), movie.getStock());
                    }   //for
                }
        );
        menu.addMenuItem(
                "9",
                "Exit",
                () -> {
                    System.out.println("Thank you! Bye.");
                    System.exit(0);
                }
        );
    }
}
