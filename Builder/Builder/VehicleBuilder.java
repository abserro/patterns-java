package Builder;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleBuilder {
    protected Driver driver;
    protected List<Passenger> passengers = new ArrayList<>();

    public abstract void setDriver();

    public abstract void setPassenger(String name, int age, boolean benefit);

    public Vehicle getVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.setDriver(driver);
        for (Passenger passenger : this.passengers) {
            vehicle.setPassenger(passenger);
        }
        return vehicle;
    }

    protected abstract Vehicle createVehicle();
}
