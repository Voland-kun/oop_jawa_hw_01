package GenTree;

import java.util.HashSet;

public interface GenTree {
    HashSet<Relationship> tree = new HashSet<>();

    default HashSet<Relationship> getTree() {
        return tree;
    }

    void addParent(Person child);

    void addChild(Person parent);

    void addGrandchild(Person grandparent);

    void addGrandparent(Person grandchild);

    public void marry(Person spouse);

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
