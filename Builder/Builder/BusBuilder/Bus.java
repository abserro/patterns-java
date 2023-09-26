package Builder.BusBuilder;

import Builder.Passenger;
import Builder.Vehicle;

public class Bus extends Vehicle {
    private static final int LIMIT_PASSENGERS = 30;
    private boolean passengerLimitExceeded = false;
    
    @Override
    public void setPassenger(Passenger passenger) {
        if (this.passengers.size() + 1 > LIMIT_PASSENGERS) {
            if (!passengerLimitExceeded) {
                System.out.println("Passengers too many!");
                passengerLimitExceeded = true;
            }
            return;
        }
        this.passengers.add(passenger);
    }

}
