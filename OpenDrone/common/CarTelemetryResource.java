package common;

import data.TelemetryData;
import data.TelemetryDatas;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface CarTelemetryResource {
    @Get("txt")
    public TelemetryDatas represent();

    @Post("xml")
    public TelemetryData store(TelemetryData type);
}
