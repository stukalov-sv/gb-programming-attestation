package Data.Pets;

import Data.IPet;
import Data.Pet;

public class Cat extends Pet implements IPet {
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
