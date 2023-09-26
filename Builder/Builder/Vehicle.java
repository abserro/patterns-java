package Builder;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected Driver driver;
    protected List<Passenger> passengers = new ArrayList<>();
    private int LIMIT_PASSENGERS;
    private boolean passengerLimitExceeded = false;


    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public abstract void setPassenger(Passenger passenger);

    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public void viewInfo() {
        System.out.println("Driver: " + this.driver.getCategory());
        System.out.println("Passengers (count = " + this.passengers.size() + "): ");
        for (Passenger passenger : this.passengers) {
            System.out.println();
            passenger.viewInfo();
        }
        System.out.println("Ready: " + this.readyToGo());
    }

    public boolean readyToGo() {
        return (this.driver != null || this.passengers.size() > 0 && this.passengers.size() < this.LIMIT_PASSENGERS);
    }
}
