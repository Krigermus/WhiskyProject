package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Whisky;
import entities.dto.WhiskyDTO;
import errorhandling.dto.ExceptionDTO;
import facades.WhiskyFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Martin Frederiksen
 */
@Path("whisky")
@Produces(MediaType.APPLICATION_JSON)
public class WhiskyResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Whisky",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final WhiskyFacade FACADE = WhiskyFacade.getWhiskyFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @Path("setup")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Operation(summary = "Setup dummy whiskies in database",
            tags = {"Setup"})
    public String setupDatabase() {
        EntityManager em = EMF.createEntityManager();
        List<Whisky> whiskies = new ArrayList();
        whiskies.add(new Whisky("Glen Dronach Allardice 18år", "This is one of the best oloroso sherry whiskies we have tasted",  100000, 90000, 5, "https://bisgaard-vin.dk/wp-content/uploads/2016/01/GlenDronach-Allardice-18-Years-Old-Single-Highland-Malt-46.jpg"));
        whiskies.add(new Whisky("Glen Dronach Parlament 21år", "This is one of the best oloroso and PX sherry whiskies we have tasted", 130000, 110000, 5, "https://www.scoma.de/media/catalog/product/cache/2/small_image/800x940/9df78eab33525d08d6e5fb8d27136e95/org/050342.jpg"));
        em.getTransaction().begin();
        for(Whisky w : whiskies) {
            em.persist(w);
        }
        em.getTransaction().commit();
        return "{\"status\":\"completed\"}";
    };
    
    @GET
    @Path("{id}")
    @Operation(summary = "Get Whisky with specific id",
            tags = {"Whisky"},
            responses = {
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = WhiskyDTO.class)),
                        responseCode = "200", description = "Succesful operation"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "400", description = "Invalid Id supplied"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "404", description = "Whisky not found")})
    public WhiskyDTO getWhiskyById(@PathParam("id") int id) {
        if (id <= 0) {
            throw new WebApplicationException("Invalid Id supplied", 400);
        }
        try {
            WhiskyDTO whiskydto = FACADE.getWhisky(id);
            return whiskydto;
        } catch (Exception ex) {
            throw new WebApplicationException(ex.getMessage(), 404);
        }
    }

    @Operation(summary = "Get all Whiskies",
            tags = {"Whisky"},
            responses = {
                @ApiResponse(
                        content = @Content(mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = WhiskyDTO.class))),
                        responseCode = "200", description = "Succesful operation")})
    @GET
    @Path("all")
    public List<WhiskyDTO> getWhiskyAll() {
        return FACADE.getWhiskyAll();
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new Whisky",
            tags = {"Whisky"},
            responses = {
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = WhiskyDTO.class)),
                        responseCode = "200", description = "Succesful operation"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "500", description = "Internal Server Error")})
    public WhiskyDTO whiskyAdd(WhiskyDTO whiskydto) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @DELETE
    @Path("delete/{id}")
    @Operation(summary = "Delete a whisky with specific id",
            tags = {"Whisky"},
            responses = {
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = WhiskyDTO.class)),
                        responseCode = "200", description = "Succesful operation"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "400", description = "Invalid Id supplied"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "404", description = "Whisky not found")})
    public String deleteWhisky(@PathParam("id") long id) {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Edit a specific whisky",
            tags = {"Whisky"},
            responses = {
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = WhiskyDTO.class)),
                        responseCode = "200", description = "Succesful operation"),
                @ApiResponse(content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ExceptionDTO.class)),
                        responseCode = "500", description = "Internal Server Error")})
    public String editWhisky() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

}
