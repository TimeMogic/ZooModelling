package animals;

public class Gazelle extends Animal{
    public Gazelle(String nickName) {
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
