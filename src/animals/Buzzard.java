package animals;

public class Buzzard extends Animal {
    public Buzzard(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
        return animal instanceof Buzzard;
    }
}
