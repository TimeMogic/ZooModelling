package areas;

import animals.Animal;
import animals.Seal;
import animals.Shark;
import animals.Starfish;

public class Aquarium extends Habitat implements IArea{

    public Aquarium(int capacity) {
        super(capacity);
    }

    @Override
    public boolean correctHabitat(Animal animal) {
        return (animal instanceof Shark || animal instanceof Starfish || animal instanceof Seal);
    }
}
