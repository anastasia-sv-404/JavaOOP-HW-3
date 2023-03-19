package geoTreeResearch;

public class Main {
    public static void main(String[] args) {
        Person ivan = new Person("Ivan", Person.Gender.man, 34);
        Person stepan = new Person("Stepan", Person.Gender.man, -5);//При вводе неверных значений
        // для возраста используется рандом.
        Person gosha = new Person("Gosha", Person.Gender.man, 12);
        Person olga = new Person("Olga", Person.Gender.woman, 5);

        Person sveta = new Person("Sveta", Person.Gender.woman, 10);

        stepan.print();
        stepan.setAge(10); // Задаем верное значение для возраста.
        stepan.print();
        System.out.println();

        Family ivanFamily = new Family(ivan);
        Family stepanFamily = new Family(stepan);
        Family goshaFamily = new Family(gosha);
        Family olgaFamily = new Family(olga);

        Family svetaFamily = new Family(sveta);

        mutualAddition(stepan, ivanFamily, stepanFamily); // Формируем список семьи для Ивана
        mutualAddition(gosha, ivanFamily, goshaFamily);
        mutualAddition(olga, ivanFamily, olgaFamily);
        mutualAddition(stepan, goshaFamily, stepanFamily);
        mutualAddition(olga, stepanFamily, olgaFamily);
        mutualAddition(gosha, olgaFamily, goshaFamily);

        System.out.print("Семья Ивана:\n");
        ivanFamily.print();
        System.out.println();

        System.out.print("Семья Степана:\n");
        stepanFamily.print();
        System.out.println();

        System.out.print("Семья Гоши:\n");
        goshaFamily.print();
        System.out.println();

        System.out.print("Семья Ольги:\n");
        olgaFamily.print();

        GeoTree tree = new GeoTree();

        tree.append(ivanFamily, Relationship.parent, stepanFamily, Relationship.child); // Формируем отношения между
        // персонами одной семьи.
        tree.append(ivanFamily, Relationship.parent, goshaFamily, Relationship.child);
        tree.append(ivanFamily, Relationship.parent, olgaFamily, Relationship.child);
        System.out.println();
        tree.append(ivanFamily, Relationship.parent, svetaFamily, Relationship.child); // Проверяем, что не можем
        // установить отношения между персонами, если они принадлежат разным семьям.

        System.out.println();
        System.out.println("Установлены следующие отношения между персонами: ");
        tree.print();


        new Result(tree, ivan, Relationship.parent).printWithSorting(SortType.name);// Кому Иван приходится родителем.
        // Сортировка вывода по именам.
        System.out.println();
        new Result(tree, Person.Gender.man).printWithSorting(SortType.age);// Выводим всех мужчин. Сортировка по возрасту.

    }
    static void mutualAddition(Person person, Family familyToAdd, Family personFamily) {
        familyToAdd.addToFamily(person);
        personFamily.addToFamily(familyToAdd.getPerson());
    }
}
