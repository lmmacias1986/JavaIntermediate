package runner;

import airport.Airport;
import models.MilitaryType;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        List<Plane> planes = createPlanes();
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());

        logger.info("Military airport sorted by max distance: {}", militaryAirport.sortByMaxDistance());
        logger.info("Passenger airport sorted by max speed: {}", passengerAirport.sortByMaxSpeed());
        logger.info("Plane with max passenger capacity: {}", passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }


    private static List<Plane> createPlanes() {
        List<Plane> planes = new ArrayList<>();
        planes.add(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164));
        planes.add(new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192));
        planes.add(new PassengerPlane("Boeing-747", 980, 16100, 70500, 242));
        planes.add(new PassengerPlane("Airbus A320", 930, 11800, 65500, 188));
        planes.add(new PassengerPlane("Airbus A330", 990, 14800, 80500, 222));
        planes.add(new PassengerPlane("Embraer 190", 870, 8100, 30800, 64));
        planes.add(new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140));
        planes.add(new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196));
        planes.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER));
        planes.add(new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER));
        planes.add(new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER));
        planes.add(new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER));
        planes.add(new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER));
        planes.add(new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        return planes;
    }
}