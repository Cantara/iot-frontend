package no.cantara.iot.frontend;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import no.cantara.iot.frontend.hello.IotFrontendResource;
import no.cantara.iot.frontend.hello.api.Planet;
import no.cantara.iot.frontend.hello.api.Saying;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class IotFrontendFullStackIntegrationTest {

    @ClassRule
    public static final DropwizardAppRule<IotFrontendDropwizardConfiguration> RULE =
            new DropwizardAppRule<>(IotFrontendApplication.class, ResourceHelpers.resourceFilePath("IotFrontend-test.yml"));

    @Test
    public void getIotFrontend() {
        Client client = JerseyClientBuilder.createClient();

        Response response = client.target(
                String.format("http://localhost:%d/IotFrontend" + IotFrontendResource.PATH, RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus()).isEqualTo(200);
    }

    @Test
    public void postIotFrontend() {
        Client client = JerseyClientBuilder.createClient();

        Response response = client.target(
                String.format("http://localhost:%d/IotFrontend" + IotFrontendResource.PATH, RULE.getLocalPort()))
                .request()
                .post(Entity.json(new Planet("Neptune", "Bad Santa")));

        assertThat(response.getStatus()).isEqualTo(200);
        Saying saying = response.readEntity(Saying.class);
        assertThat(saying.getContent()).isEqualTo("Hello Bad Santa on planet Neptune");
    }

}
