package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/foobar")
    @Produces(MediaType.APPLICATION_JSON)
    public Foobar hello1() {
        Foobar foobar = new Foobar();
        foobar.setFoo("foo");
        foobar.setBar("bar");
        return foobar;
    }

    @GET
    @Path("/highlight")
    @Produces(MediaType.APPLICATION_JSON)
    public Highlight highlight() {
        return new Highlight();
    }
}