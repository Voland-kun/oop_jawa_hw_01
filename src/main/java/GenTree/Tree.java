package GenTree;


import java.util.HashSet;

public class Tree {
    private HashSet<Relationship> tree = new HashSet<>();

    public HashSet<Relationship> getTree() {
        return tree;
    }

    public void addParent(Person parent, Person child) {
        tree.add(new Relationship(parent, child, "parent"));
        tree.add(new Relationship(child, parent, "child"));
    }

    public void addChild(Person child, Person parent) {
        tree.add(new Relationship(child, parent, "child"));
        tree.add(new Relationship(parent, child, "parent"));
    }

    public void addGrandchild(Person grandchild, Person grandparent) {
        tree.add(new Relationship(grandchild, grandparent, "grandchild"));
        tree.add(new Relationship(grandparent, grandchild, "grandparent"));
    }

    public void addGrandparent(Person grandparent, Person grandchild) {
        tree.add(new Relationship(grandparent, grandchild, "grandparent"));
        tree.add(new Relationship(grandchild, grandparent, "grandchild"));
    }

    public void marry(Person p1, Person p2) {
        tree.add(new Relationship(p1, p2, "spouse"));
        tree.add(new Relationship(p2, p1, "spouse"));
    }

    public void researchGrandparents() {
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
