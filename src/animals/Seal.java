package animals;

public class Seal extends Animal {
    public Seal(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return (animal instanceof Seal || animal instanceof Starfish);
    }
}
