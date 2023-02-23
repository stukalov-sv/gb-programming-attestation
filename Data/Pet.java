package Data;

public abstract class Pet extends Animal {
    protected Pet(String name, String birthDate) {
        super(name, birthDate);
    }
    protected Pet() {
        super();
    }
}
