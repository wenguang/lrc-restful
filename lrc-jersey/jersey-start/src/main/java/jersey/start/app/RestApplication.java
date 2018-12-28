package jersey.start.app;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {

    public RestApplication() {
        this.packages("jersey.start.service");
    }
}
