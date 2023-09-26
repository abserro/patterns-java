package Builder.BusBuilder;

import Builder.CategoryPassenger;
import Builder.Passenger;

public class BusPassenger extends Passenger {
    private double ticketPrice = 100;

    public BusPassenger(String name, int age, boolean benefit) {
        super(name, age, benefit);
        if (getCategoryPassenger() == CategoryPassenger.Child) {
            this.ticketPrice = 0.0; // free ticket
        } else {
            this.ticketPrice = benefit ? (this.ticketPrice * 0.7) : this.ticketPrice;
        }
    }

    @Override
    public void viewInfo() {
        System.out.println("\tName: " + this.getName());
        System.out.println("\tAge: " + this.getAge());
        System.out.println("\tCategory: " + this.getCategoryPassenger());
        System.out.println("\tPrice ticket: " + this.ticketPrice);
    }
}
