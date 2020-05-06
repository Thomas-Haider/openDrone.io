package server;

import common.CarResource;
import data.Car;
import data.Fahrzeugdaten;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class CarServerResource extends ServerResource implements CarResource {

    private int carId;

    private JAXB jaxb = EnergieServer.getJAXB();

    @Override
    protected void doInit() throws ResourceException {
        try {
            this.carId = Integer.parseInt(getAttribute("IdCar"));
        } catch (NumberFormatException e) {
            this.carId = -1;
        }
    }

    @Override
    public Car represent() {
        Fahrzeugdaten.Cars cars = jaxb.getCars();
        for (Car ourCar : cars.getCar()){
            if (ourCar.getIdCar().intValue() == carId){
                return ourCar;
            }
        }

        return null;
    }

    @Override
    public Car store(Car type) {
        if (carId != -1){
            Fahrzeugdaten.Cars cars = jaxb.getCars();
            for (Car ourCar : cars.getCar()) {
                if (ourCar.getIdCar().intValue() == carId) {
                    ourCar.setFirstName(type.getFirstName());
                    ourCar.setLastName(type.getLastName());
                    return ourCar;
                }
            }
        }
        return null;
    }

    @Override
    public Car remove() {
        if (carId != -1){
            Fahrzeugdaten.Cars cars = jaxb.getCars();
            for (Car ourCar : cars.getCar()) {
                if (ourCar.getIdCar().intValue() == carId) {
                    Car oldCar = ourCar;
                    cars.getCar().remove(ourCar);
                    return oldCar;
                }
            }
        }
        return null;
    }
}
