package Controller;

import java.util.Scanner;

import Data.PackAnimals.Camel;
import Data.PackAnimals.Donkey;
import Data.PackAnimals.Horse;
import Data.Pets.Cat;
import Data.Pets.Dog;
import Data.Pets.Hamster;
import Services.AnimalCountService;
import Services.AnimalRegistrationService;

public class RegistrationController {
    AnimalRegistrationService animalRegistrationService = new AnimalRegistrationService();

    public void button() {
        while (true) {
            Scanner iScanner = new Scanner(System.in);
            int action;
            System.out.println("\nAnimals in list - " + AnimalCountService.getCount());
            System.out.println("\nChoose action you want:\n" +
                    "Show all animals - 1\n" +
                    "Add animal - 2\n" +
                    "Choose animal - 3\n" +
                    "Exit - 4\n");

            action = iScanner.nextInt();

            switch (action) {
                case 1:
                    animalRegistrationService.info();
                    break;
                case 2:
                    addAnimals();
                    break;
                case 3:
                    selectAnimal();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Incorrect data. Try again\n");
                    break;
            }
        }
    }

    private void addAnimals() {
        Scanner iScanner = new Scanner(System.in);
        String type;
        String name;
        String birthDate;

        System.out.println("What animal add?\n" +
                "Cat, Dog, Hamster, Horse, Camel, Donkey");

        type = iScanner.next();

        switch (type) {
            case "Cat":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Cat(name, birthDate));
                break;
            case "Dog":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Dog(name, birthDate));
                break;
            case "Hamster":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Hamster(name, birthDate));
                break;
            case "Horse":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Horse(name, birthDate));
                break;
            case "Camel":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Camel(name, birthDate));
                break;
            case "Donkey":
                System.out.println("Enter name:");
                name = iScanner.next();
                System.out.println("Enter birth date:");
                birthDate = iScanner.next();
                animalRegistrationService.addAnimals(new Donkey(name, birthDate));
                break;
            default:
                System.out.println("Incorrect data. Try again");
                button();
                break;
        }
    }

    private void selectAnimal() {
        Scanner iScanner = new Scanner(System.in);

        if (animalRegistrationService.checkFill()) {
            int select;
            int action;
            System.out.println("Enter number of interesting animal:");
            animalRegistrationService.info();
            System.out.println();
            select = iScanner.nextInt();
            while (true) {
                if (select <= animalRegistrationService.sizeArrayAnimals()) {
                    animalRegistrationService.selectAnimals(select);
                    break;
                } else {
                    System.out.println("Incorrect data. Try again\n");
                }
            }

            System.out.println("\nWhat doing with animal?");
            System.out.println("Learn new command - 1\n" + 
                                "Print known command list - 2\n" + 
                                "Remove animal from list - 3\n" + 
                                "Return to pervious menu - 4\n");
            action = iScanner.nextInt();
            switch (action) {
                case 1:
                    String command;
                    System.out.println("Enter new command:");
                    command = iScanner.next();
                    animalRegistrationService.teachCommand(command);
                    break;
                case 2:
                    animalRegistrationService.getCommand();
                    break;
                case 3:
                    animalRegistrationService.deleteAnimals();
                    break;
                case 4:
                    button();
                    break;
                default:
                    System.out.println("Incorrect data. Try again");
                    selectAnimal();
                    break;
            }
        } else {
            System.out.println("Animal list is empty. Try again");
        }
    }
}
