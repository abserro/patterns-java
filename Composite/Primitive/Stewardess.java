package Primitive;

import Component.Component;

import java.util.List;

public class Stewardess extends Component {
    private final String name;

    public Stewardess(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public void getInfo() {
        System.out.printf("%-20s %-20s%n", "STEWARDESS", this.name);
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
