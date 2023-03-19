package humanAndPet;

public class WaterTurtle extends Pet{

    public WaterTurtle(String name, int age) {
        super(name, age);
    }

    public WaterTurtle(String name) {
        super(name);
    }

    public WaterTurtle() {
    }

    @Override
    void moveTo(Human human) {
        System.out.printf("%s %s плывет к человеку %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
    }

    @Override
    void damage(Human human) {
        System.out.printf("%s %s укусила человека %s.\n", this.getClass().getSimpleName(), super.getName(),
                human.getName());
        human.setHasWounds(true);
    }
}