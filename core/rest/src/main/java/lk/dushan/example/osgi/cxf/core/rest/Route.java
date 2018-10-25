package lk.dushan.example.osgi.cxf.core.rest;

import lk.dushan.example.osgi.cxf.core.api.Example;

import javax.ws.rs.core.Response;

/**
 * Authored by dushan.p@viewqwest.com on 25/10/18.
 */
public interface Route {

    Response example(final Example request);
}
