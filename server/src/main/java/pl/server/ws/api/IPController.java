package pl.server.ws.api;


import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.util.Logging;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(IPController.PATH)
public class IPController {
    public static final String PATH = "/ip";

    @Logging
    private Logger logger;

    @RequestMapping
    public String get(HttpServletRequest request) throws Exception {
        logger.info("Requesting IP");
        return request.getRemoteAddr();
    }
}
