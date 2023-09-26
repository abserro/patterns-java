package Primitive;

import Component.Component;
import Enumirate.ClassesPlane;

import java.text.DecimalFormat;
import java.util.List;

public class Passenger extends Component {
    private final String name;
    private double weightBaggage;
    private final ClassesPlane classPlane;
    private final String ticket;

    public Passenger(String name, ClassesPlane classPlane, String ticket, double weightBaggage) {
        this.name = name;
        this.ticket = ticket;
        this.weightBaggage = weightBaggage;
        this.classPlane = classPlane;
    }

    public String getTicket() {
        return ticket;
    }

    public void setWeight(double weightBaggage) {
        this.weightBaggage = weightBaggage;
    }

    @Override
    public double getWeight() {
        return this.weightBaggage;
    }

    @Override
    public void getInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.printf("%-20s %-15s %-10s %-10s%n", this.name, this.classPlane, this.ticket, df.format(this.weightBaggage));
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
