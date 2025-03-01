package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.get_all_categories.GetAllCategoriesActor;
import com.algalopez.streamby.backoffice_app.category.application.get_all_categories.GetAllCategoriesResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@RequiredArgsConstructor
@Tag(name = "Category", description = "Category API")
@Path("/backoffice-app/category/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GetAllCategoriesController {

  private final GetAllCategoriesActor actor;

  @Operation(summary = "Get all categories")
  @APIResponse(
      responseCode = "200",
      content = @Content(schema = @Schema(implementation = GetAllCategoriesResponse.class)))
  @GET
  @Path("/")
  public GetAllCategoriesResponse getAllCategories() {
    return actor.query(null);
  }
}
