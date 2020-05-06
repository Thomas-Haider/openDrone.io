package server;

import common.CarsResource;
import data.Car;
import data.Fahrzeugdaten;
import org.restlet.resource.ServerResource;

import java.math.BigInteger;
import java.util.List;

public class CarsServerResource extends ServerResource implements CarsResource {
    private JAXB jaxb = EnergieServer.getJAXB();

    @Override
    public Fahrzeugdaten.Cars represent() {
        return jaxb.getCars();
    }

    @Override
    public Car store(Car type) {
        int newId = 0;
        List<Car> cars = jaxb.getCars().getCar();

        int highestId = 0;
        for (Car ourCar : cars) {
            if (ourCar.getIdCar().intValue() > highestId){
                highestId = ourCar.getIdCar().intValue();
            }
        }
        newId = highestId++;

        type.setId(BigInteger.valueOf(newId));
        jaxb.getCars().getCar().add(type);
        return type;
    }
}
