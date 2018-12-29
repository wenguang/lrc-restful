package jersey.http.start;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {

    public RestApplication() {
        this.packages("jersey.http.rest");
    }
}
