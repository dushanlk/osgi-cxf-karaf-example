package lk.dushan.example.osgi.cxf.core.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.Bus;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.transport.http.HttpDestinationFactory;
import org.apache.cxf.transport.servlet.ServletDestinationFactory;
import org.glassfish.jersey.internal.RuntimeDelegateImpl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
@Component(immediate = true)
public class Rest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rest.class);

    private Route route;

    @Activate
    public void activate(Map<String, Object> config) {
        LOGGER.info("Starting REST API....");

        final JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        RuntimeDelegate.setInstance(new RuntimeDelegateImpl());

        serverFactory.setServiceBeans(getServiceBeans());
        serverFactory.setProvider(new JacksonJsonProvider());

        final ServletDestinationFactory destinationFactory = new ServletDestinationFactory();
        final Bus bus = serverFactory.getBus();
        bus.setExtension(destinationFactory, HttpDestinationFactory.class);

        final JAXRSBindingFactory factory = new JAXRSBindingFactory();
        factory.setBus(bus);

        final BindingFactoryManager manager = bus.getExtension(BindingFactoryManager.class);
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
        serverFactory.create();

        LOGGER.info("Started REST API....");
    }

    private List<Object> getServiceBeans() {
        LinkedList<Object> providers = new LinkedList<>();
        providers.add(route);
        return providers;
    }

    @Reference
    public void setRoute(Route route) {
        this.route = route;
    }
}
