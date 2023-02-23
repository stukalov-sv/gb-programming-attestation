package Data;

abstract class Pet extends Animal {
    private Pet(String name, String birthDate) {
        super(name, birthDate);
    }
    private Pet() {
        super();
    }
}
