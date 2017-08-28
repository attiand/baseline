import javax.ws.rs.*
import javax.ws.rs.core.*

@Produces(MediaType.APPLICATION_JSON)
@Path("/baseline")
class BaselineResource {

	@GET
	Response getBaselines() {
		return Response.ok().entity(["baseline1", "baseline2"]).build();
	}	
	
	@Path("/{baseline}")
	Response getBaseline(@PathParam('baseline') String baseline) {
		return Response.ok().entity(baseline).build();
	}
}