package GenTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person implements GenTree {
    private String name;
    private int age;



    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
        this.age = 0;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void addParent(Person parent) {
        tree.add(new Relationship(parent, this, "parent"));
        tree.add(new Relationship(this, parent, "child"));
    }

    @Override
    public void addChild(Person child) {
        tree.add(new Relationship(child, this, "child"));
        tree.add(new Relationship(this, child, "parent"));
    }

    @Override
    public void addGrandchild(Person grandchild) {
        tree.add(new Relationship(this, grandchild, "grandparent"));
        tree.add(new Relationship(grandchild, this, "grandchild"));
    }

    @Override
    public void addGrandparent(Person grandparent) {
        tree.add(new Relationship(grandparent, this, "grandparent"));
        tree.add(new Relationship(this, grandparent, "grandchild"));
    }

    @Override
    public void marry(Person spouse) {
        tree.add(new Relationship(this, spouse, "spouse"));
        tree.add(new Relationship(spouse, this, "spouse"));
    }
}


