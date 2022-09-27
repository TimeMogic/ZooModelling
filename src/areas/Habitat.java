package areas;

import animals.Animal;
import zoo.Codes;
import java.util.ArrayList;

public abstract class Habitat extends Area{

    private ArrayList<Animal> habitatAnimals;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.habitatAnimals = new ArrayList<>();
    }

    public ArrayList<String> getAnimalNames() {
        ArrayList<String> animalNames = new ArrayList<>();
        for (int i = 0; i < this.habitatAnimals.size(); i++) {
            animalNames.add(this.habitatAnimals.get(i).getNickname());
        }
        return animalNames;
    }

    public byte putInAnimal(Animal animal) {
        if (!this.correctHabitat(animal)){
            return Codes.WRONG_HABITAT;
        }else if (this.habitatAnimals.size() >= this.capacity) {
            return Codes.HABITAT_FULL;
        }else if (!this.isCompatible(animal)) {
            return Codes.INCOMPATIBLE_INHABITANTS;
        }else if (this.habitatAnimals.contains(animal)) {
            return Codes.ANIMAL_ADDED;
        } else {
            this.habitatAnimals.add(animal);
            return Codes.ANIMAL_ADDED;
        }
    }

    private boolean isCompatible(Animal animal){
        for (int i = 0; i < this.habitatAnimals.size(); i++) {
            if (!this.habitatAnimals.get(i).isCompatibleWith(animal)) {
                return false;   //check for incompatible animals
            }
        }
        return true;
    }

    public boolean removeAnimal(Animal animal) {
        return this.habitatAnimals.remove(animal);
    }

    protected abstract boolean correctHabitat(Animal animal);
}
