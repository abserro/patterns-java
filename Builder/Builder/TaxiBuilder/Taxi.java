package Builder.TaxiBuilder;

import Builder.CategoryPassenger;
import Builder.Passenger;
import Builder.Vehicle;

public class Taxi extends Vehicle {
    private boolean hasChildTaxi;
    private static final int LIMIT_PASSENGERS = 4;
    private boolean passengerLimitExceeded = false;

    public boolean checkChild() {
        for (Passenger passenger : this.passengers){
            if (passenger.getCategoryPassenger() == CategoryPassenger.Child) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void viewInfo() {
        System.out.println("Driver: " + this.driver.getCategory());
        System.out.println("Passengers (count = " + this.passengers.size() + "): ");
        for (Passenger passenger : this.passengers) {
            System.out.println();
            passenger.viewInfo();
        }
        System.out.println("Child seat: " + this.hasChildTaxi);
        System.out.println("Ready: " + this.readyToGo());
    }

    @Override
    public void setPassenger(Passenger passenger) {
        if (this.passengers.size() + 1 > LIMIT_PASSENGERS) {
            if (!passengerLimitExceeded) {
                System.out.println("Passengers too many!");
                passengerLimitExceeded = true;
            }
            return;
        }
        this.hasChildTaxi = this.checkChild();
        this.passengers.add(passenger);
    }
}
