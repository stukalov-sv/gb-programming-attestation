package Data.Pets;

import Data.IPet;
import Data.Pet;

public class Hamster extends Pet implements IPet {
    private final String type = "Hamster";
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
    }

    public Hamster() {
        super();
    }

    @Override
    public String type() {
        return type;
    }
}
