package view.endpoints;

import com.google.gson.Gson;
import logic.StudentController;
import logic.TeacherController;
import security.Digester;
import shared.ReviewDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by Kasper on 19/10/2016.
 */

@Path("/api/teacher")
public class TeacherEndpoint extends UserEndpoint {


    @OPTIONS
    @Path("/review")
    public Response deleteReview() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Content-Type")
                .header("Access-Control-Allow-Methods","GET,PUT,POST,DELETE")
                .build();
    }

    @DELETE
    @Consumes("application/json")
    @Path("/review")
    public Response deleteReview(String data) {
        Gson gson = new Gson();

        ReviewDTO review = gson.fromJson(data, ReviewDTO.class);
        TeacherController teacherCtrl = new TeacherController();

        boolean isDeleted = teacherCtrl.softDeleteReview(review.getId());

        if (isDeleted) {
            String toJson = gson.toJson(Digester.encrypt(gson.toJson(isDeleted)));

            return successResponse(200, toJson);
        } else {
            return errorResponse(404, "Failed. Couldn't delete the chosen review.");
        }
    }
}