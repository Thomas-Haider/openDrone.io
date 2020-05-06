package common;

import data.Car;
import data.Fahrzeugdaten;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface CarsResource {
    @Get("txt")
    public Fahrzeugdaten.Cars represent();

    @Post("xml")
    public Car store(Car type);
}
