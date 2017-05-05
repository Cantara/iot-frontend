package no.cantara.iot.frontend.properties;

import com.codahale.metrics.annotation.Metered;
import io.swagger.annotations.Api;
import org.constretto.annotation.Configuration;
import org.constretto.annotation.Configure;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.net.URI;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by baardl on 23.10.15.
 */
@Path("properties")
@Api("properties")
@Produces(MediaType.TEXT_HTML)
@Controller
public class PropertiesResource {
    private static final Logger log = getLogger(PropertiesResource.class);

    private final URI restBaseUri;
    private final URI wsUri;

    @Configure
    public PropertiesResource(@Configuration("iot_device_rest_url")String restBaseUri, @Configuration("iot_ws_url")String wsUri) {
        this.restBaseUri = URI.create(restBaseUri);
        this.wsUri = URI.create(wsUri);
    }


    @Metered
    @GET
    @Produces("application/javascript")
    @Path("/override.js")
    public PropertiesView getService(@Context HttpServletResponse response) {
        return new PropertiesView(restBaseUri,wsUri);
    }


}
