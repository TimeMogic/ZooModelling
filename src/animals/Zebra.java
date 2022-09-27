package animals;

public class Zebra extends Animal {
    public Zebra(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return (animal instanceof Zebra || animal instanceof Gazelle);
    }
}
