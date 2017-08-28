import javax.ws.rs.*
import javax.ws.rs.core.*
import com.sun.jersey.api.core.*
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory
import org.glassfish.grizzly.http.server.HttpServer
import static com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING

@Grapes([
	@Grab('com.sun.jersey:jersey-server:1.19.4'),
	@Grab('com.sun.jersey:jersey-core:1.19.4'),
	@Grab('com.sun.jersey:jersey-grizzly2:1.19.4'),
	@Grab('com.sun.jersey:jersey-json:1.19.4'),
	@Grab('javax.ws.rs:jsr311-api:1.1.1')
])

def db = new Database()

ResourceConfig resources = new ClassNamesResourceConfig(BaselineResource)
def uri = UriBuilder.fromUri("http://localhost/").port(6789).build();

resources.getFeatures().put(FEATURE_POJO_MAPPING, true);

HttpServer httpServer = GrizzlyServerFactory.createHttpServer(uri, resources);
println("Jersey app started with WADL available at ${uri}application.wadl")
System.in.read();
httpServer.stop();