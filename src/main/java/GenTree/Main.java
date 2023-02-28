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

        Tree tree = new Tree();
        tree.addParent(Anton,Sergei);
        tree.addParent(Alyona,Sergei);
        tree.addParent(Sergei,Egor);
        tree.addParent(Vasya,Sasha);
        tree.addParent(Nina,Sasha);
        tree.addParent(Sasha,Egor);

        tree.researchGrandparents();

//        for(Relationship t : tree.getTree()) {
//            System.out.println(t);
//        }

        System.out.println(new Research(tree).getResearch(Egor, "grandparent"));
    }
}
