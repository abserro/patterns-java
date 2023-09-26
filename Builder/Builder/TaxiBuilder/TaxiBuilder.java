package Builder.TaxiBuilder;

import Builder.Vehicle;
import Builder.VehicleBuilder;

public class TaxiBuilder extends VehicleBuilder {

    @Override
    public void setDriver() {
        this.driver = TaxiDriver.getInstance();
    }

    @Override
    public void setPassenger(String name, int age, boolean benefit) {
        this.passengers.add(new TaxiPassenger(name, age));
    }

    @Override
    protected Vehicle createVehicle() {
        return new Taxi();
    }
}
