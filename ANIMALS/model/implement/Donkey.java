package ANIMALS.model.implement;

import ANIMALS.model.AbstractPackAnimal;
import ANIMALS.model.AnimalGenius;

import java.time.LocalDate;

public class Donkey extends AbstractPackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.DONKEY);
    }
}