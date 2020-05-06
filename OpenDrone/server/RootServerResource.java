package server;

import common.RootResource;
import org.restlet.resource.ServerResource;

public class RootServerResource extends ServerResource implements RootResource {
    @Override
    public String represent() {
        return "Welcome to my Car-Application!";
    }
}
