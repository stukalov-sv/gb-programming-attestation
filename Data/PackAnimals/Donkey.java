package Data.PackAnimals;

import Data.PackAnimal;

public class Donkey extends PackAnimal {
    private final String type = "Donkey";
    public Donkey(String name, String birthDate) {
        super(name, birthDate);
    }

    public Donkey() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
