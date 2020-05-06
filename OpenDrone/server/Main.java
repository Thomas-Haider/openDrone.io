package server;

import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args) throws Exception{
        Component component = new Component();
        component.getDefaultHost().attach("/fahrzeugdaten", new EnergieServer());

        Server server = new Server(Protocol.HTTP, 8184, component);
        server.start();
    }
}
