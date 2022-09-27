package areas;

import animals.Animal;
import animals.Buzzard;
import animals.Parrot;

public class Cage extends Habitat implements IArea{

    public Cage(int capacity) {
        super(capacity);
    }

    @Override
    protected boolean correctHabitat(Animal animal) {
        return (animal instanceof Buzzard || animal instanceof Parrot);
    }
}
