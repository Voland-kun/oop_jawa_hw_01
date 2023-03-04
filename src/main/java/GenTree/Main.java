package GenTree;

public class Main {
    public static void main (String[] args) {
        Person Anton = new Person("Антон");
        Person Alyona = new Person("Алёна");
        Person Vasya = new Person("Вася");
        Person Nina = new Person("Нина");
        Person Sergei = new Person("Сергей");
        Person Sasha = new Person("Саша");
        Person Egor = new Person("Егор");

        Sergei.addParent(Anton);
        Sergei.addParent(Alyona);
        Egor.addParent(Sergei);
        Sasha.addParent(Vasya);
        Sasha.addParent(Nina);
        Egor.addParent(Sasha);

        Egor.researchGrandparents();

        System.out.println(new Research(Egor.getTree()).getResearch(Egor, "grandparent"));
        System.out.println(new Research(Egor.getTree()).getResearch(Sergei, "parent"));
    }
}
