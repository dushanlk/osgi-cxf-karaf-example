package lk.dushan.example.osgi.cxf.core.service;

import org.osgi.service.component.annotations.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
@Component(immediate = true)
public class ExampleServiceImpl implements ExampleService {

    @Override
    public String process(String username, String password) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] digest = md.digest((username + password).getBytes(StandardCharsets.UTF_8));
        final StringBuilder hash = new StringBuilder();

        for (final byte b : digest) {
            hash.append(String.format("%02x", b));
        }

        return hash.toString();
    }
}
