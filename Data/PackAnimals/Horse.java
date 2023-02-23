package Data.PackAnimals;

import Data.IPackAnimal;
import Data.PackAnimal;

public class Horse extends PackAnimal implements IPackAnimal {
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
