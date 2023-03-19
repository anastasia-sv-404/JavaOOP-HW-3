package humanAndPet;

import humanAndPet.Comparator.PetNameComparator;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(); // Исходно: у питомца есть имя, возраст, он не голоден и не спит.
//         Имя и возраст могут быть заданы при создании экземпляра.
        Bird bird = new Bird();
        WaterTurtle waterTurtle = new WaterTurtle();
        Cat cat2 = new Cat();
        Bird bird2 = new Bird();
        WaterTurtle waterTurtle2 = new WaterTurtle();

        Human human = new Human();// Исходно: у человека есть имя, и у него нет повреждений на коже.
        // Имя может быть задано при создании экземпляра.
        House house = new House(human); // Дом - это список питомцев указанного человека.

        house.addPet(cat);
        house.addPet(bird);
        house.addPet(waterTurtle);
        house.addPet(cat2);
        house.addPet(bird2);
        house.addPet(waterTurtle2);

//        System.out.println(human);
//      System.out.println(cat);
//      System.out.println(bird);
//      System.out.println(waterTurtle);

        house.print();
        System.out.println();

        house.getPets().sort(new PetNameComparator()); // Сортируем список питомцев в доме по именам.
        house.print();
        System.out.println();

        Collections.sort(house.getPets());// Сортируем список питомцев в доме по возрасту (по возрастанию).
        house.print();

//        if (!house.isEmpty()) {
//            getActionsWithPet(house, human);
//        } // Запуск метода взаимод-ия с питомцем: поиск по имени, попытка переименовать найденного питомца,
//        попытка покормить найденного питомца.

        giveFoodToOlderPet(cat, bird, human); //Человек кормит питомца, который старше по возрасту.
    }

    static void getActionsWithPet(House house, Human human) {
        Pet pet = null;
        boolean check = true;

        while (check) {
            System.out.printf("Введите имя питомца, с которым человек будет взаимодействовать: ");
            Scanner scanner = new Scanner(System.in);
            String petName = scanner.nextLine();
            pet = house.findInHouse2(petName);
            if (pet != null) {
                System.out.printf("Питомец c именем %s найден.\n", petName);
                check = false;
            } else {
                System.out.printf("В доме нет питомца с именем %s.\n", petName);
            }
        }

        human.giveAnotherNameForPet(pet); // Меняем питомцу имя. В случае изменения - питомец нанесет урон человеку
//(разный в зависимости от типа Питомца).
        System.out.println();

        human.callPet(pet); //Человек позвал питомца. Питомец не спит. Если может ответить - отвечает.
//      Также питомец двигается в сторону человека - по-разному в зависимости от типа Питомца.
        human.giveFoodToPet(pet); // Человек пробует покормить питомца. Питомец не голоден.
        System.out.println();

        pet.changeState(); // Питомец уснул

        System.out.println("Питомец " + pet.getName() + " сейчас: " + pet.getState() +
                ". Питомец проголодался? Ответ: " + pet.getHungry());// Если питомец уснул, то он стал голодным.
        human.callPet(pet); // Человек разбудил питомца.
        System.out.println();
        human.giveFoodToPet(pet); // Человек покормил питомца.
    }

    static void giveFoodToOlderPet(Pet p1, Pet p2, Human human){
        if (p1.compareTo(p2) < 0){
            human.giveFoodToPet(p2);
        } else if (p1.compareTo(p2) > 0) {
            human.giveFoodToPet(p1);
        } else{
            System.out.println("Человек не смог выбрать питомца, которого нужно покормить.");
        }
    }
}
