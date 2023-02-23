package Data;

abstract class PackAnimal extends Animal{
    private PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }
    private PackAnimal() {
        super();
    }
}

