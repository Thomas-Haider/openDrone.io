package common;

import org.restlet.resource.Get;

public interface RootResource {
    @Get("txt")
    public String represent();
}
