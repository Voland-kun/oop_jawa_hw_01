package GenTree;

import java.util.HashSet;

public class Research {
    private HashSet<Relationship> source;
    public HashSet<Person> result;


    public Research(HashSet tree) {
        this.source = tree;
        this.result = new HashSet<Person>();
    }

    public HashSet<Person> getResearch(Person p1, String status) {
        for(Relationship p : source) {
            if (p.getP2() == p1 && p.getRel() == status.toLowerCase()) {
                result.add(p.getP1());
            }
        }
        return result;
    }
}
