package pl.wsb.students.view;

public class MenuItem {

    private final String keyToPress;
    private final String text;
    private final Runnable action;

    public MenuItem(String keyToPress, String text, Runnable action) {
        this.keyToPress = keyToPress;
        this.text = text;
        this.action = action;
    }

    public String generateText() {
        return String.format(
                "%s) %s (please, press %s)",
                keyToPress,
                text,
                keyToPress
        );
    }

    public void execute() {
        if (action == null) {
            System.err.println("No action provided...");
            return;
        }   //if
        action.run();
    }

}
