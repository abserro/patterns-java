package Component;

import java.util.List;

public abstract class Component {

    public abstract double getWeight();
    public abstract void getInfo();
    public abstract void add(Component component);
    public abstract void remove(Component component);
}
