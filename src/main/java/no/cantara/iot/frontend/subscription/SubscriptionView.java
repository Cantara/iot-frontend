package no.cantara.iot.frontend.subscription;

import io.dropwizard.views.View;

import java.net.URI;


public class SubscriptionView extends View {
    public static final String TEMPLATE_NAME = "subscription.ftl";

    private String restBaseUrl = "-not-set-";
    private String wsUrl = "-not-set-";

    public SubscriptionView() {
        super(TEMPLATE_NAME);
    }
    public SubscriptionView(String deviceId, URI restBaseUri, URI wsUri) {
        super(TEMPLATE_NAME);
    }

    public SubscriptionView(URI restBaseUri, URI wsUri) {
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

