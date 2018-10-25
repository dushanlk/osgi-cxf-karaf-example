package lk.dushan.example.osgi.cxf.core.rest;

import lk.dushan.example.osgi.cxf.core.api.Example;
import lk.dushan.example.osgi.cxf.core.service.ExampleService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
@Component(immediate = true)
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class RouteImpl implements Route {

    private static final Logger LOGGER = LoggerFactory.getLogger(RouteImpl.class);

    private ExampleService service;

    @POST
    @Path("/example")
    public Response example(final Example request) {
        try {
            LOGGER.info("Request received: {}", request);

            final String hash = service.process(request.getUsername(), request.getPassword());
            LOGGER.info("Generated hash: {}", hash);

            final HashMap<String, String> response = new HashMap<>();
            response.put("hash", hash);
            return Response.ok(response).build();
        } catch (NoSuchAlgorithmException e) {
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    @Reference
    public void setService(ExampleService service) {
        this.service = service;
    }
}
