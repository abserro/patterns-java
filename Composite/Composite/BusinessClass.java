package Composite;

import Component.Component;
import Enumirate.ClassesPlane;
import Primitive.Passenger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BusinessClass extends Component {
    private final int maxCountPassengers = 20;
    private final double limitWeightBaggage = 35;
    private final List<Component> passengers = new ArrayList<>();
    private final List<List<String>> seats = new ArrayList<>();

    public BusinessClass() {
        String[] letters = {"A", "B", "C", "D"};
        for (int i = 0; i < maxCountPassengers / 4; i++) {
            for (String letter : letters) {
                List<String> row = new ArrayList<>();
                String seat = letter + (i + 1);
                row.add(seat);
                row.add("false");
                this.seats.add(row);
            }
        }
    }


    @Override
    public double getWeight() {
        double weightBaggage = 0;
        for (Component passenger : this.passengers) {
            weightBaggage += passenger.getWeight();
        }
        return weightBaggage;
    }

    @Override
    public void getInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\u001B[36m***BUSINESS_CLASS***\u001B[0m");
        System.out.println("COUNT_PASSENGERS: " + this.passengers.size());
        System.out.printf("%-20s %-15s %-10s%n", "NAME", "CLASS", "WEIGHT_BAGGAGE");
        for (Component passenger : this.passengers) {
            if (passenger.getWeight() > limitWeightBaggage) {
                System.out.print("\u001B[31m");
                passenger.getInfo();
                System.out.print("\u001B[0m");
            } else {
                passenger.getInfo();
            }
        }
        System.out.println("WEIGHT_BAGGAGE: " + df.format(this.getWeight()));

    }

    public void mapSeat() {
        int rowCount = 5; // количество строк
        int colCount = 4; // количество столбцов
        System.out.println("\u001B[36m***BUSINESS_CLASS***\u001B[0m");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int index = i + j * rowCount;
                if (index >= seats.size()) {
                    break;
                }
                String color = Objects.equals(seats.get(index).get(1), "true") ? "35" : "30";
                System.out.print("\u001B[" + color + "m" + seats.get(index).get(0) + "\u001B[0m");
                System.out.print("\t\t");
            }
            System.out.println(); // переход на новую строку
        }
    }


    @Override
    public void remove(Component component) {
        String seat = ((Passenger) component).getTicket();
        for (List<String> row : this.seats) {
            if (Objects.equals(seat, row.get(0))) {
                row.set(1, "false");
            }
        }
        passengers.remove(component);
    }

    @Override
    public void add(Component passenger) {
        if (this.passengers.size() + 1 > this.maxCountPassengers) {
            return;
        }
        this.passengers.add(passenger);
    }

    public void fillBusinessClass() {
        Random random = new Random();
        int countPassengers = random.nextInt(maxCountPassengers - 1 + 1) + 1;
        for (int i = 0; i < countPassengers; i++) {
            double weight = 5.0 + (60.0 - 5.0) * random.nextDouble();
            weight = weight < 5.0 ? 0.0 : weight;
            Passenger passenger = new Passenger("Passenger" + i, ClassesPlane.Business, this.seats.get(i % 25).get(0), weight);
            seats.get(i % 25).set(1, "true");
            this.add(passenger);
        }
    }
}
