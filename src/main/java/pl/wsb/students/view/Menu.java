package pl.wsb.students.view;

import java.util.*;

public class Menu {

    private final HashMap<String, MenuItem> menuItems = new HashMap<>();

    public void addMenuItem(String keyToPress, String name, Runnable action) {
        menuItems.put(
                keyToPress,
                new MenuItem(
                        keyToPress,
                        name,
                        action
                )
        );
    }

    public void handleAction(String keyPressed) {
        if (keyPressed == null) {
            System.err.println("Please, select one of the menu options...");
            return;
        }   //if
        if (!menuItems.containsKey(keyPressed)) {
            System.err.println("Please, select one of the menu options...");
            return;
        }   //if
        menuItems.get(keyPressed).execute();
    }

    public void printMenu() {
        if (menuItems.size() == 0) {
            System.err.println("No menu items provided...");
            return;
        }   //if
        System.out.printf("%s%n", "---- Main menu ----");
        for (Map.Entry<String, MenuItem> set : menuItems.entrySet()) {
            System.out.printf("%s%n", set.getValue().generateText());
        }
    }

}
