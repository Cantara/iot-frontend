package no.cantara.iot.frontend.properties;

import io.dropwizard.views.View;

import java.net.URI;


public class PropertiesView extends View {
    public static final String TEMPLATE_NAME = "properties.ftl";

    private String restBaseUrl = "-not-set-";
    private String wsUrl = "-not-set-";

    public PropertiesView() {
        super(TEMPLATE_NAME);
    }
    public PropertiesView(String deviceId, URI restBaseUri, URI wsUri) {
        super(TEMPLATE_NAME);
    }

    public PropertiesView(URI restBaseUri, URI wsUri) {
        super(TEMPLATE_NAME);
        this.restBaseUrl = restBaseUri.toString();
        this.wsUrl = wsUri.toString();

    }

    public String getRestBaseUrl() {
        return restBaseUrl;
    }

    public String getWsUrl() {
        return wsUrl;
    }
}

