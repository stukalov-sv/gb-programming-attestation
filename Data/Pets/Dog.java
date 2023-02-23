package Data.Pets;

import Data.IPet;
import Data.Pet;

public class Dog extends Pet implements IPet {
    private final String type = "Dog";
    public Dog(String name, String birthDate) {
        super(name, birthDate);
    }

    public Dog() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
