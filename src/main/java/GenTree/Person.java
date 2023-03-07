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
}


