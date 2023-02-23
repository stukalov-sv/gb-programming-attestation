package Data.PackAnimals;

import Data.PackAnimal;

public class Horse extends PackAnimal {
    private final String type = "Horse";
    public Horse(String name, String birthDate) {
        super(name, birthDate);
    }

    public Horse() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
