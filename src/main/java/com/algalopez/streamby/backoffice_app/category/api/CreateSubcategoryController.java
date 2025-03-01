package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.create_subcategory.CreateSubcategoryActor;
import com.algalopez.streamby.backoffice_app.category.application.create_subcategory.CreateSubcategoryRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@RequiredArgsConstructor
@Tag(name = "Category", description = "Category API")
@Path("/backoffice-app/category/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateSubcategoryController {

  private final CreateSubcategoryActor actor;

  @Operation(summary = "Create a subcategory")
  @APIResponse(responseCode = "204")
  @POST
  @Path("/{categoryId}/subcategory")
  public void createSubcategory(
      @PathParam("categoryId") Long categoryId, CreateSubcategoryRequest request) {
    var finalRequest = request.withCategoryId(categoryId);
    actor.command(finalRequest);
  }
}
