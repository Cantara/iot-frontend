package no.cantara.iot.frontend.device;

import com.codahale.metrics.annotation.Metered;
import io.swagger.annotations.Api;
import org.constretto.annotation.Configuration;
import org.constretto.annotation.Configure;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by baardl on 23.10.15.
 */
@Path("device")
@Api("device")
@Produces(MediaType.TEXT_HTML)
@Controller
public class DeviceResource {
    private static final Logger log = getLogger(DeviceResource.class);

    private final URI restBaseUri;
    private final URI wsUri;

    @Configure
    public DeviceResource(@Configuration("iot_device_rest_url")String restBaseUri, @Configuration("iot_ws_url")String wsUri) {
        this.restBaseUri = URI.create(restBaseUri);
        this.wsUri = URI.create(wsUri);
    }


    @Metered
    @GET
    @Path("/")
    public DeviceView getService(@Context HttpServletResponse response) {
        return new DeviceView();
    }

    @Metered
    @GET
    @Path("/{deviceId}")
    @Produces(MediaType.APPLICATION_XML)
    public DeviceView findModelByModelId(@PathParam("deviceId") String deviceId, @Context HttpServletResponse response) {
        return new DeviceView(deviceId, restBaseUri, wsUri);
    }



}
