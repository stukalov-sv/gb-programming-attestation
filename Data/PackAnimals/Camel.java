package Data.PackAnimals;

import Data.IPackAnimal;
import Data.PackAnimal;

public class Camel extends PackAnimal implements IPackAnimal {
    private final String type = "Camel";
    public Camel(String name, String birthDate) {
        super(name, birthDate);
    }

    public Camel() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
