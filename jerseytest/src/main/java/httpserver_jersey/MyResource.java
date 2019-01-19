package httpserver_jersey;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.resource.Singleton;


/**
 * Created by tanghao on 2017/2/16.
 * jersey
 * httpserver
 */

@Singleton
@Path("service")
public class MyResource {


    /**
     *
     * HTTP请求信息
     *
     * @param resourceName
     * @param description
     * @param request
     * @param uriInfo
     * @param httpHeaders
     * @return
     */
    @Path("{sub_path:[a-zA-Z0-9]*}")
    @GET
    @Consumes({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
    public String getResourceName(
            @PathParam("sub_path") String resourceName,
            @DefaultValue("Just a Test !") @QueryParam("desc") String description,
            @Context Request request,
            @Context UriInfo uriInfo,
            @Context HttpHeaders httpHeaders
            ){


        System.out.println("###############this.hashCode:##########"+this.hashCode());

        //输出HTTP请求信息

        System.out.println("------------------- HTTP REQUEST --------------------");

        StringBuilder strgBuilder = new StringBuilder();
        strgBuilder.append(request.getMethod()+" ");
        strgBuilder.append(uriInfo.getRequestUri().toString()+" ");
        strgBuilder.append("HTTP/1.1[\\r\\n]");
        System.out.println(strgBuilder.toString());

        //HTTP请求头信息
        MultivaluedMap <String,String> headers = httpHeaders.getRequestHeaders();
        Iterator<String> iterator = headers.keySet().iterator();
        while (iterator.hasNext()){
            String headerName = iterator.next();
            System.out.println(headerName + ":" + headers.get(headerName) + "[\\r\\n]");
        }

        System.out.println("[\\r\\n]");
        String responseStr =resourceName + "[" + description + "]";

        return responseStr;
    }

    public static void main(String[] args) {

        URI uri = UriBuilder.fromUri("http://127.0.0.1").port(10000).build();
        ResourceConfig rc = new PackagesResourceConfig("httpserver_jersey");
        try {
            HttpServer server = GrizzlyServerFactory.createHttpServer(uri,rc);
            server.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
