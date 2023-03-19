package humanAndPet;

import humanAndPet.Interface.Sayable;

public class Cat extends Pet implements Sayable {

    public Cat(String name, int age){
        super(name, age);
    }

    public Cat(String name) {
        super(name);
    }

    public Cat() {
    }

    @Override
    void moveTo(Human human) {
        System.out.printf("%s %s идет на мягких лапках к человеку %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
    }

    @Override
    void damage(Human human) {
        System.out.printf("%s %s поцарапал человека %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
        human.setHasWounds(true);
    }

    @Override
    public void voice() {
        System.out.println("Мяу.");
    }
}