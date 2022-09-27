package areas;

import animals.Animal;
import animals.Gazelle;
import animals.Lion;
import animals.Zebra;

public class Enclosure extends Habitat implements IArea{

    public Enclosure(int capacity) {
        super(capacity);
    }

    @Override
    public boolean correctHabitat(Animal animal) {
        return (animal instanceof Gazelle || animal instanceof Lion || animal instanceof Zebra);
    }
}
