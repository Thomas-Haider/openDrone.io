package webClasses;


import data.Car;
import data.Fahrzeugdaten;
import data.TelemetryData;
import data.TelemetryDatas;

public class Controller {
    private static final Client client = new Client("http://localhost:8184/fahrzeugdaten");

    public static Fahrzeugdaten.Cars getCars(){
        return client.getCars();
    }

    public static void addCar(String name, String type){
        Car car = new Car();
        car.setName(name);
        car.setTyp(type);
        client.addCar(car);
    }

    public static Car getCar(int id){
        return client.getCar(id);
    }

    public static TelemetryDatas getTelemetry(int id){
        return client.getTelemetry(id);
    }

    public static void addTelemetry(int carID,double latitude, double longitude, double capacity, double speed){
        TelemetryData telemetryData = new TelemetryData();
        telemetryData.setLatitude(latitude);
        telemetryData.setLongitude(longitude);
        telemetryData.setCapacity(capacity);
        telemetryData.setSpeed(speed);
        client.addTelemetry(carID,telemetryData);
    }
}
