package animals;

public class Lion extends Animal {
    public Lion(String nickName) {
        super(nickName);
    }

    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal == null) {
            return true;
        } else
            return animal instanceof Lion;
    }
}
