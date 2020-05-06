package server;

import common.CarTelemetryResource;
import data.Car;
import data.Fahrzeugdaten;
import data.TelemetryData;
import data.TelemetryDatas;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.math.BigInteger;

public class CarTelemetryServerResource extends ServerResource implements CarTelemetryResource {
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
    public TelemetryDatas represent() {
        if (carId != -1) {
            Fahrzeugdaten.Cars cars = jaxb.getCars();
            for (Car curCar : cars.getCar()) {
                if (curCar.getIdCar().intValue() == carId) {
                    return curCar.getTelemetryDatas();
                }
            }
        }
        return null;
    }

    @Override
    public TelemetryData store(TelemetryData type) {
        if (carId != -1) {
            Fahrzeugdaten.Cars cars = jaxb.getCars();
            for (Car curCar : cars.getCar()) {
                if (curCar.getIdCar().intValue() == carId) {
                    int newId = 0;

                    int highestId = 0;
                    for (TelemetryData curData : curCar.getTelemetryDatas().getTelemetryData()) {
                        if (curData.getIdTelemetryData().intValue() > highestId){
                            highestId = curData.getIdTelemetryData().intValue();
                        }
                    }
                    newId = highestId++;

                    type.setIdTelemetryData(new BigInteger(newId+""));
                    curCar.getTelemetryDatas().getTelemetryData().add(type);

                    return type;
                }
            }
        }
        return null;
    }
}
