package humanAndPet;

import humanAndPet.Interface.Sayable;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Human {
    private String name;
    private boolean hasWounds;
    private String[] humanName = new String[]{"Вася", "Петя", "Степа", "Иван", "Сергей", "Вова"};

    /**
     * Общий приватный конструктор для класса.
     *
     * @param name      имя
     * @param hasWounds статус: есть ли повреждения на коже
     */
    private Human(String name, boolean hasWounds) {
        if (name.isEmpty()) {
            Random random = new Random();
            this.name = humanName[random.nextInt(0, humanName.length)];
        } else {
            this.name = name;
        }
        this.hasWounds = hasWounds;
    }

    /**
     * Публичный переопределенный конструктор класса. Есть возможность задать произвольное имя.
     *
     * @param name имя
     */
    public Human(String name) {
        this(name, false);
    }

    /**
     * Публичный переопределенный конструктор класса. Без аргументов.
     */
    public Human() {
        this("");
    }

    public String getName() {
        return name;
    }

    public boolean getHasWounds() {
        return hasWounds;
    }

    public void setHasWounds(boolean hasWounds) {
        this.hasWounds = hasWounds;
    }

    public void giveAnotherNameForPet(Pet pet) {
        boolean check = true;

        while (check) {
            System.out.printf("Человек %s хочет поменять имя питомца %s %s? 1 - да, 2 - нет\n", this.name,
                    pet.getClass().getSimpleName(), pet.getName());
            Scanner firstScanner = new Scanner(System.in);

            if (!firstScanner.hasNextInt()) {
                System.out.println("Было введено неверное значение. Нужно попробовать еще раз.");
            } else {
                int answer = firstScanner.nextInt();
                if (answer == 1) {
                    System.out.printf("Человеку %s нужно ввести новое имя питомца: ", this.name);
                    Scanner secondScanner = new Scanner(System.in);
                    String anotherName = secondScanner.nextLine();
                    pet.setName(anotherName);
                    System.out.println("Новое имя питомца - это: " + pet.getName());
                    System.out.println("Питомцу не понравилось, что его имя поменяли.");
                    pet.damage(this);
                } else {
                    System.out.println("Имя питомца осталось прежним.");
                }
                check = false;
            }
        }
    }

    public void giveFoodToPet(Pet pet) {
        System.out.printf("Человек %s пробует покормить питомца %s %s.\n", this.name, pet.getClass().getSimpleName(),
                pet.getName());
        if (pet.getHungry()) {
            System.out.printf("Человек %s покормил питомца %s.\n", this.name, pet.getName());
            pet.takeFood();
        } else {
            System.out.printf("Питомец %s не голоден.\n", pet.getName());
        }
    }

    private void toWakePet(Pet pet) {
        if (pet.getState() == Pet.State.isSleeping) {
            System.out.printf("Человек %s разбудил питомца %s.\n", this.name, pet.getName());
            pet.changeState();
        }
    }

    public void callPet(Pet pet) {
        System.out.printf("Человек %s зовет питомца %s %s. \n", this.name, pet.getClass().getSimpleName(),
                pet.getName());
        if (pet.getState() == Pet.State.isNotSleeping) {
            if (pet instanceof Sayable) {
                System.out.printf("Питомец %s не спит. Питомец отвечает: ", pet.getName());
                ((Sayable) pet).voice();
                pet.moveTo(this);
            } else {
                System.out.printf("Питомец %s не спит. ", pet.getName());
                pet.moveTo(this);
            }
        } else {
            toWakePet(pet);
        }
    }

    @Override
    public String toString() {
        return "У нас есть человек " + name + ". У человека есть повреждения на коже? Ответ: " + this.hasWounds + ".";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}