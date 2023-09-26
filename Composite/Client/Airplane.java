package Client;

import Component.Component;
import Composite.BusinessClass;
import Composite.EconomyClass;
import Composite.FirstClass;
import Enumirate.ClassesPlane;
import Primitive.Passenger;
import Primitive.Pilot;
import Primitive.Stewardess;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private static final double maxLimitBaggage = 5050.0;
    private List<Component> components = new ArrayList<>();

    public void fillAirplane() {
        this.createCrew();
        this.createFirstClass();
        this.createBusinessClass();
        this.createEconomyClass();
    }

    public void getInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        for (Component component : this.components) {
            component.getInfo();
        }
        System.out.print("READY_TO_GO: ");
        String color = this.readyToGo() ? "32" : "31";
        System.out.println("\u001B[" + color + "m" + this.readyToGo() + "\u001B[0m");
        System.out.println("TOTAL_WEIGHT: " + df.format(this.getWeight()));
    }

    public boolean readyToGo() {
        return this.components.size() > 8 && this.components.size() <= maxLimitBaggage;
    }

    public double getWeight() {
        double totalWeight = 0;
        for (Component component : this.components) {
            totalWeight += component.getWeight();
        }
        System.out.println();
        return totalWeight;
    }

    private void createCrew() {
        Pilot firstPilot = new Pilot("Robert Jackson");
        Pilot secondPilot = new Pilot("Donald Aguilar");
        components.add(firstPilot);
        components.add(secondPilot);
        for (int i = 0; i < 6; i++) {
            Stewardess stewardess = new Stewardess("Stewardess" + i);
            components.add(stewardess);
        }
    }

    private void createFirstClass() {
        FirstClass firstClass = new FirstClass();
        firstClass.fillFirstClass();
        components.add(firstClass);
        firstClass.mapSeat();
    }

    private void createBusinessClass() {
        BusinessClass businessClass = new BusinessClass();
        businessClass.fillBusinessClass();
        components.add(businessClass);
        businessClass.mapSeat();
    }

    private void createEconomyClass() {
        EconomyClass economyClass = new EconomyClass();
        economyClass.fillEconomyClass();
        components.add(economyClass);
        economyClass.mapSeat();
    }

    public void remove(Component component) {
        this.components.remove(component);
    }
}
