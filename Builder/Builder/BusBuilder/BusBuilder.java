package Builder.BusBuilder;

import Builder.Vehicle;
import Builder.VehicleBuilder;

public class BusBuilder extends VehicleBuilder {
    @Override
    public void setDriver() {
        this.driver = BusDriver.getInstance();
    }

    @Override
    public void setPassenger(String name, int age, boolean benefit) {
        this.passengers.add(new BusPassenger(name, age, benefit));
    }

    @Override
    protected Vehicle createVehicle() {
        return new Bus();
    }

}
