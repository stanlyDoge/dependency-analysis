package org.jboss.da.communication.pnc.endpoints;

import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.PAGE_INDEX_DEFAULT_VALUE;
import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.PAGE_INDEX_QUERY_PARAM;
import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.PAGE_SIZE_DEFAULT_VALUE;
import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.PAGE_SIZE_QUERY_PARAM;
import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.QUERY_QUERY_PARAM;
import static org.jboss.da.communication.pnc.endpoints.EndpointsParams.SORTING_QUERY_PARAM;
import org.jboss.da.communication.pnc.model.BuildConfiguration;
import org.jboss.da.communication.pnc.model.BuildConfigurationSet;
import org.jboss.da.communication.pnc.model.PNCResponseWrapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

/**
 *
 * @author Honza Brázdil <jbrazdil@redhat.com>
 */
@Path("/build-configuration-sets")
@Consumes(MediaType.APPLICATION_JSON)
public interface BuildConfigurationSetEndpoint {

    @GET
    Response getAll(
            @QueryParam(PAGE_INDEX_QUERY_PARAM) @DefaultValue(PAGE_INDEX_DEFAULT_VALUE) int pageIndex,
            @QueryParam(PAGE_SIZE_QUERY_PARAM) @DefaultValue(PAGE_SIZE_DEFAULT_VALUE) int pageSize,
            @QueryParam(SORTING_QUERY_PARAM) String sort, @QueryParam(QUERY_QUERY_PARAM) String q);

    @POST
    Response createNew(@HeaderParam("Authorization") String authorization,
            BuildConfigurationSet buildConfigurationSetRest);

    public class BuildConfigurationSetSingleton extends PNCResponseWrapper<BuildConfigurationSet> {
    }

    public class BuildConfigurationSetPage extends PNCResponseWrapper<List<BuildConfigurationSet>> {
    }
}
