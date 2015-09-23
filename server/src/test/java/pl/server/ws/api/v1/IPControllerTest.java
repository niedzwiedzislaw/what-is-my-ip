package pl.server.ws.api.v1;

import junitparams.JUnitParamsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

@RunWith(JUnitParamsRunner.class)
public class IPControllerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTest() throws Exception {
//        String responseMsg = maintenanceController.test();
//        assertEquals("OK", responseMsg);
    }

    @Test
    public void testException() throws Exception {
//        try {
//            maintenanceController.exception();
//            fail();
//        } catch (RestException e) {
//            assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getStatusCode());
//        }
    }
}