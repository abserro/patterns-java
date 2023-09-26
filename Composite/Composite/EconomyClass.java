package Composite;

import Component.Component;
import Enumirate.ClassesPlane;
import Primitive.Passenger;

import java.text.DecimalFormat;
import java.util.*;

public class EconomyClass extends Component {
    private final int maxCountPassengers = 150;
    private final double limitWeightBaggage = 25;
    private final List<Component> passengers = new ArrayList<>();
    private final List<List<String>> seats = new ArrayList<>();

    public EconomyClass() {
        String[] letters = {"A", "B", "C", "D", "E", "F"};
        for (int i = 0; i < maxCountPassengers / 6; i++) {
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
        for (Component component : this.passengers) {
            weightBaggage += component.getWeight();
        }
        return weightBaggage;
    }

    @Override
    public void getInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\u001B[32m***ECONOMY_CLASS***\u001B[0m");
        System.out.println("COUNT_PASSENGERS: " + this.passengers.size());
        System.out.printf("%-20s %-15s %-10s%n", "NAME", "CLASS", "WEIGHT_BAGGAGE");
        for (Component passenger : this.passengers) {
            if (passenger.getWeight() > limitWeightBaggage) {
                System.out.print("\u001B[31m");
                passenger.getInfo();
                System.out.print("\u001B[0m");
                ((Passenger) passenger).setWeight(0.0);
                System.out.print("\u001B[33m");
                passenger.getInfo();
                System.out.print("\u001B[0m");
            } else {
                passenger.getInfo();
            }
        }
        System.out.println("WEIGHT_BAGGAGE: " + df.format(this.getWeight()));
    }

    public void mapSeat() {
        int rowCount = 25; // количество строк
        int colCount = 6; // количество столбцов
        System.out.println("\u001B[32m***ECONOMY_CLASS***\u001B[0m");
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int index = i + j * rowCount;
                if (index >= seats.size()) {
                    break;
                }
                String color = Objects.equals(seats.get(index).get(1), "true") ? "30" : "35";
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
                row.set(1, "true");
            }
        }
        passengers.remove(component);
    }

    @Override
    public void add(Component component) {
        passengers.add(component);
    }

    public void fillEconomyClass() {
        Random random = new Random();
        int countPassengers = random.nextInt(maxCountPassengers - 70 + 1) + 70;
        Collections.shuffle(seats);
        for (int i = 0; i < countPassengers; i++) {
            double weight = 5.0 + (60.0 - 5.0) * random.nextDouble();
            weight = weight < 5.0 ? 0.0 : weight;
            Passenger passenger = new Passenger("Passenger" + i, ClassesPlane.Economy, this.seats.get(i % 25).get(0), weight);
            seats.get(i % 25).set(1, "true");
            this.add(passenger);
        }
        Collections.sort(seats, (o1, o2) -> {
            String s1 = o1.get(0);
            String s2 = o2.get(0);

            String s1Letter = s1.substring(0, 1);
            String s2Letter = s2.substring(0, 1);

            int letterCompare = s1Letter.compareTo(s2Letter);

            if (letterCompare == 0) {
                int s1Number = Integer.parseInt(s1.substring(1));
                int s2Number = Integer.parseInt(s2.substring(1));
                return Integer.compare(s1Number, s2Number);
            }

            return letterCompare;
        });
    }
}
