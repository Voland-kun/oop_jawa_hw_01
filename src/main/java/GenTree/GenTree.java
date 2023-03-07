package GenTree;

import java.util.HashSet;

public interface GenTree {
    HashSet<Relationship> tree = new HashSet<>();

    default HashSet<Relationship> getTree() {
        return tree;
    }

    default void addParent(Person parent) {
        tree.add(new Relationship(parent, (Person)this, "parent"));
        tree.add(new Relationship((Person)this , parent, "child"));
    }

    default void addChild(Person child) {
        tree.add(new Relationship(child, (Person)this, "child"));
        tree.add(new Relationship((Person)this, child, "parent"));
    }

    default void addGrandchild(Person grandchild) {
        tree.add(new Relationship((Person)this, grandchild, "grandparent"));
        tree.add(new Relationship(grandchild, (Person)this, "grandchild"));
    }

    default void addGrandparent(Person grandparent) {
        tree.add(new Relationship(grandparent, (Person)this, "grandparent"));
        tree.add(new Relationship((Person)this, grandparent, "grandchild"));
    }

    default void marry(Person spouse) {
        tree.add(new Relationship((Person)this, spouse, "spouse"));
        tree.add(new Relationship(spouse, (Person)this, "spouse"));
    }

    default void researchGrandparents() {
        HashSet<Relationship> temp = new HashSet<>();
        for(Relationship t : tree) {
            if (t.getRel().equals("parent")) {
                for(Relationship c : tree) {
                    if (t.getP2() == c.getP1() && c.getRel().equals("parent")) {
                        temp.add(new Relationship(t.getP1(), c.getP2(), "grandparent"));
                        temp.add(new Relationship(c.getP2(), t.getP1(), "grandchild"));
                    }
                }
            }
        }
        tree.addAll(temp);
    }
}
