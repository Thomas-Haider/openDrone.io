package server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class EnergieServer extends Application {
    private static final JAXB jaxb = new JAXB("data.xml");

    public static JAXB getJAXB(){
        return jaxb;
    }

    public EnergieServer(){
        setName("Restful Products-Application");
        setOwner("Thomas Haider");
        setAuthor("Thomas Haider");
    }

    @Override
    public Restlet createInboundRoot(){
        Router router = new Router(getContext());
        router.attachDefault(RootServerResource.class);
        router.attach("/cars/", CarsServerResource.class);
        router.attach("/car/{IdCar}", CarServerResource.class);
        router.attach("/car/{IdCar}", CarServerResource.class);
        router.attach("/car/{IdCar}/Telemetry", CarTelemetryServerResource.class);
        return router;
    }
}
