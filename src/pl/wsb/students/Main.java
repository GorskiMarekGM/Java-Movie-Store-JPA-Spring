package pl.wsb.students;

import pl.wsb.students.controller.AppController;
import pl.wsb.students.service.StoreManager;

public class Main {

    public static void main(String[] args) {
        AppController.run(
                new StoreManager()
        );
    }
}
