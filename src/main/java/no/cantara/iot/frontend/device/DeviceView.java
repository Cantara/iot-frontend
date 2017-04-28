package no.cantara.iot.frontend.device;

import io.dropwizard.views.View;

import java.net.URI;


public class DeviceView extends View {
    public static final String TEMPLATE_NAME = "device.ftl";

    public DeviceView() {
        super(TEMPLATE_NAME);
    }
    public DeviceView(String deviceId, URI restBaseUri, URI wsUri) {
        super(TEMPLATE_NAME);
    }
}

