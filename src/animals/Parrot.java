package animals;

public class Parrot extends Animal{
    public Parrot(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return animal instanceof Parrot;
    }
}
