import java.util.*;

class VehicleRegistry {

    private Map<String, Vehicle> vehicles = new HashMap<>();

    public void registerVehicle(String plate, String owner, String model) {
        if (vehicles.containsKey(plate)) {
            System.out.println("Vehicle already registered!");
            return;
        }

        vehicles.put(plate, new Vehicle(plate, owner, model));
        System.out.println("Vehicle registered successfully!");
    }

    public void getVehicle(String plate) {
        if (!vehicles.containsKey(plate)) {
            System.out.println("Vehicle not found!");
            return;
        }

        Vehicle v = vehicles.get(plate);
        System.out.println("Owner: " + v.owner);
        System.out.println("Model: " + v.model);
    }
}