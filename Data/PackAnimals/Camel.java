package Data.PackAnimals;

import Data.PackAnimal;

public class Camel extends PackAnimal {
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
