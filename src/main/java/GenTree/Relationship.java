package GenTree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relationship {
    private Person p1;
    private Person p2;
    private String rel;

    public  Relationship(Person p1, Person p2, String rel) {
        this.p1 = p1;
        this.p2 = p2;
        this.rel = rel;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",p1,p2,rel);
    }
}