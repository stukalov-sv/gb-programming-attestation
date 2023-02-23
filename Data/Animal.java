package Data;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String birthDate;
    private final List<String> command = new ArrayList<>();

    private Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    private Animal() {}

    public void teachCommand(String command) {
        this.command.add(command);
    }

    public void getCommand() {
        int count = 0;
        for (String item : command) {
            if (command.size() > count) {
                System.out.print(item + ", ");
            } else {
                System.out.print(item);
            }
            count++;
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public abstract String type();

    public int getSizeCommand() {
        return command.size();
    }
}
