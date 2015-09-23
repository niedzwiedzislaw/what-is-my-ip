package pl.server.ws.api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.server.ws.api.v1.IPController;
import pl.util.Logging;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

@Path(V1.PATH)
@Component
@Scope("request")
public class V1 {
    public static final String PATH = "/v1";

    @Autowired
    IPController ipController;

    @Logging
    Logger logger;

    @PostConstruct
    public void setup() {
        logger.info("Creating V1 bean");
    }

    @Path(IPController.PATH)
    public IPController camera() {
        return ipController;
    }
}
