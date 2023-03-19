package humanAndPet;

import humanAndPet.Interface.Sayable;

public class Bird extends Pet implements Sayable {

    public Bird(String name, int age) {
        super(name, age);
    }

    public Bird(String name) {
        super(name);
    }

    public Bird() {
    }

    @Override
    void moveTo(Human human) {
        System.out.printf("%s %s летит к человеку %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
    }

    @Override
    void damage(Human human) {
        System.out.printf("%s %s клюнул человека %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
        human.setHasWounds(true);
    }

    @Override
    public void voice() {
        System.out.println("Чирик-чирик.");
    }

}
