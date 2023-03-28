package org.acme.ride;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.types.ObjectId;
import org.jboss.logging.Logger;

@Path("/rides")
public class DriveResource {
    private static final Logger LOG = Logger.getLogger(DriveResource.class);

    @Inject
    RideRepository repository;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        Ride ride = repository.findById(new ObjectId(id));
        LOG.info("Called @Path(/{id})");
        return Response.ok(ride).build();
    }

    @GET
    public Response get() {
        LOG.info("Called GET");

        return Response.ok(repository.listAll()).build();
    }


    @POST
    public Response create(RideResponse r) throws URISyntaxException {
        LOG.info("Called POST");
        Ride ride=new Ride(r.candidate_id, r.mentor_id, r.car_id, r.start_time, r.end_time, r.price);
        repository.persist(ride);
        return Response.created(new URI("/" +ride.id )).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Ride ride) {
        LOG.info("Called PUT");
        ride.id = new ObjectId(id);
        repository.update(ride);
        return Response.ok(ride).build();

    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        LOG.info("Called DELETE");

        Ride ride = repository.findById(new ObjectId(id));
        repository.delete(ride);
        return Response.noContent().build();
    }
}
