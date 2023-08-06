package ANIMALS.storage;


import ANIMALS.model.AbstractAnimal;
import ANIMALS.model.AbstractPackAnimal;
import ANIMALS.model.AbstractPet;
import ANIMALS.model.implement.*;
import ANIMALS.model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * интерфейс Base
 * Хранилище на HashMap
 */
public class NurseryBase implements Base {
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public NurseryBase() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Лаванда", LocalDate.of(2022, 1, 11));

        cat.learnSkill(new Skill("Поймать мышь"));
        cat.learnSkill(new Skill("Урчит"));
        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Бланка", LocalDate.of(2021, 1, 7));
        dog.learnSkill(new Skill("Принести палку"));
        dog.learnSkill(new Skill("Сидеть"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Банифаций", LocalDate.of(2022, 4, 1));
        hamster.learnSkill(new Skill("Набить рот семечками"));
        hamster.learnSkill(new Skill("Притвориться мертвым"));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Плотва", LocalDate.of(2021, 2, 4));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Skill("Бег трусцой"));
        horse.learnSkill(new Skill("Прыжок через препятствие"));
        horse.learnSkill(new Skill("Бег галопом"));
        dbAnimals.put(horse.getId(), horse);

        AbstractPackAnimal horse2 = new Horse("Килька", LocalDate.of(2022, 12, 1));
        horse2.setLoadCapacity(400);
        horse2.learnSkill(new Skill("Прыжок через препятствие"));
        horse2.learnSkill(new Skill("НБег галопом"));
        dbAnimals.put(horse2.getId(), horse2);

        AbstractPackAnimal donkey = new Donkey("Осел", LocalDate.of(2020, 8, 24));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Skill("Подать голос"));
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Василий Алибабаевич", LocalDate.of(2020, 5, 20));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Skill("Плюнуть"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        return new ArrayList<>(dbAnimals.values());
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}