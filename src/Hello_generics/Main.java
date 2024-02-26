package Hello_generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Hello_generics> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Truck());

        for (Hello_generics vehicle : vehicles) {
            System.out.println(vehicle.getNumberOfWheels());
        }
    }
}