import Builder.Vehicle;
import Builder.VehicleBuilder;

import java.util.Random;

public class Director {
    private static final int maxAge = 65;
    private static final int minAge = 0;
    private static final int rangeCount = 35;

    public Vehicle createVehicle(VehicleBuilder builder) {
        builder.setDriver();
        Random random = new Random();
        int countPassengers = random.nextInt(rangeCount);
        for (int i = 0; i < countPassengers; i++) {
            int randomAge = random.nextInt(maxAge - minAge + 1) + minAge;
            boolean randomBenefit = random.nextBoolean();
            builder.setPassenger("Passenger" + i, randomAge, randomBenefit);
        }
        return builder.getVehicle();
    }
}
