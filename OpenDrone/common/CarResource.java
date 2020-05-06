package common;

import data.Car;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface CarResource {
    @Get("xml")
    public Car represent();

    @Put("xml")
    public Car store(Car type);

    @Delete
    public Car remove();
}
