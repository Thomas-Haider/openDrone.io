package webClasses;

import common.CarResource;
import common.CarTelemetryResource;
import common.CarsResource;
import data.Car;
import data.Fahrzeugdaten;
import data.TelemetryData;
import data.TelemetryDatas;
import org.restlet.resource.ClientResource;

import java.util.List;

public class Client {
    private String link;

    public Client(String link) {
        this.link = link;
    }

    public Fahrzeugdaten.Cars getCars(){
        CarsResource usersResource = ClientResource.create(this.link+"/cars/", CarsResource.class);
        return usersResource.represent();
    }
    public Car addCar(Car type){
        CarsResource employeesResource = ClientResource.create(link+"/cars/", CarsResource.class);
        return employeesResource.store(type);
    }

    public Car getCar(int id){
        CarResource userResource = ClientResource.create(this.link+"/car/"+id, CarResource.class);
        return userResource.represent();
    }

    public TelemetryDatas getTelemetry(int id){
        CarTelemetryResource usersResource = ClientResource.create(this.link+"/car/" + id + "/Telemetry", CarTelemetryResource.class);
        return usersResource.represent();
    }

    public TelemetryData addTelemetry(int id, TelemetryData type){
        CarTelemetryResource usersResource = ClientResource.create(this.link+"/car/" + id + "/Telemetry", CarTelemetryResource.class);
        return usersResource.store(type);
    }

}
