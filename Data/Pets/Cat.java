package Data.Pets;

import Data.Pet;

public class Cat extends Pet {
    private final String type = "Cat";
    public Cat(String name, String birthDate) {
        super(name, birthDate);
    }

    public Cat() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
