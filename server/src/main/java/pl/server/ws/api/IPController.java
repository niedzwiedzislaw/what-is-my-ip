package pl.server.ws.api;


import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(IPController.PATH)
public class IPController {
    public static final String PATH = "/ip";

    private Logger logger;

    @RequestMapping
    public String get(HttpServletRequest request) {
        logger.info("Requesting IP");
        return request.getRemoteAddr();
    }
}
