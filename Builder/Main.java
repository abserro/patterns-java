import Builder.BusBuilder.BusBuilder;
import Builder.TaxiBuilder.TaxiBuilder;
import Builder.Vehicle;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        TaxiBuilder taxiBuilder = new TaxiBuilder();
        BusBuilder busBuilder = new BusBuilder();

        Vehicle taxi = director.createVehicle(taxiBuilder);
        System.out.println("\n***TAXI***");
        taxi.viewInfo();

        System.out.println("\n***BUS***");
        Vehicle bus = director.createVehicle(busBuilder);
        bus.viewInfo();
    }
}