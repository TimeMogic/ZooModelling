package animals;

public class Shark extends Animal {
    public Shark(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return (animal instanceof Shark || animal instanceof Starfish);
    }
}
