package lk.dushan.example.osgi.cxf.core.service;

import java.security.NoSuchAlgorithmException;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
public interface ExampleService {

    String process(String username, String password) throws NoSuchAlgorithmException;
}
