package typeinfo;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.HashMap;

//: typeinfo/PetCount.java
// Using instanceof.
import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

public class PetCount {

    /*
     * 嵌套类
     */
    @SuppressWarnings("serial")
    static class PetCounter extends HashMap<String, Integer> {
        // 继承了map，添加了一个count方法
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null) {
                put(type, 1);
            } else {
                put(type, quantity + 1);
            }
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Pet) {
                counter.count("Pet");
            } else if (pet instanceof Dog) {
                counter.count("Dog");
            } else if (pet instanceof Mutt) {
                counter.count("Mutt");
            } else if (pet instanceof Pug) {
                counter.count("Pug");
            } else if (pet instanceof Cat) {
                counter.count("Cat");
            } else if (pet instanceof Manx) {
                counter.count("EgyptianMau");
            } else if (pet instanceof Manx) {
                counter.count("Manx");
            } else if (pet instanceof Manx) {
                counter.count("Cymric");
            } else if (pet instanceof Rodent) {
                counter.count("Rodent");
            } else if (pet instanceof Rat) {
                counter.count("Rat");
            } else if (pet instanceof Mouse) {
                counter.count("Mouse");
            } else if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
        }
        // Show the counts:
        print();
        print(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
} /* Output:
  Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
  {Pug=3, Cat=9, Hamster=1, Cymric=7, Mouse=2, Mutt=3, Rodent=5, Pet=20, Manx=7, EgyptianMau=7, Dog=6, Rat=2}
  *///:~
