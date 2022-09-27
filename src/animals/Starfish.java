package animals;

public class Starfish extends Animal{

    public Starfish(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return (animal instanceof Seal || animal instanceof Shark|| animal instanceof Starfish);
    }
}
