package Services;

import java.util.ArrayList;
import java.util.List;

import Data.Animal;
import Data.IPackAnimal;
import Data.IPet;

public class AnimalRegistrationService {
    private final List<Animal> homeAnimals = new ArrayList<>();
    private int selectAnimals;

    public void addAnimals(Animal animal) {
        if (animal instanceof IPackAnimal || animal instanceof IPet) {
            try (AnimalCountService AnimalCountService = new AnimalCountService()) {
                if (AnimalCountService.addCount(animal)) {
                    homeAnimals.add(animal);
                }
                System.out.println("\nAnimal added to list\n");
            } catch (AnimalExceptionService e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Incorrect data\n");
        }
    }

    public void deleteAnimals() {
        AnimalCountService AnimalCountService = new AnimalCountService();
        homeAnimals.remove(selectAnimals);
        AnimalCountService.removeCount();
        System.out.println("Animal deleted from list\n");
    }

    public void teachCommand(String command) {
        homeAnimals.get(selectAnimals).teachCommand(command);
        System.out.println("Animal learned new command\n");
    }

    public void getCommand() {
        if (homeAnimals.get(selectAnimals).getSizeCommand() != 0) {
            homeAnimals.get(selectAnimals).getCommand();
        } else {
            System.out.println("Learned command list is empty\n");
        }
    }

    public void selectAnimals(int select) {
        this.selectAnimals = select;
    }

    public void info() {
        if (homeAnimals.size() != 0) {
            int countAnimal = 0;
            for (Animal homeAnimals : homeAnimals) {
                System.out.println(countAnimal + 
                                    ". " + homeAnimals.type() + 
                                    ", " + homeAnimals.getName() + 
                                    ", birth: " + homeAnimals.getBirthDate());
                countAnimal++;
            }
        } else {
            System.out.println("List is empty. Try again\n");
        }
    }

    public boolean checkFill() {
        return homeAnimals.size() != 0;
    }

    public int sizeArrayAnimals() {
        return homeAnimals.size();
    }
}
