package jersey.http.start;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import java.net.URI;

public class Starter {
    public static void main(String[] args) {
        JettyHttpContainerFactory.createServer(URI.create("http://localhost:8087/"), new RestApplication());
    }
}
