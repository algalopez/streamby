package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.update_category_by_id.UpdateCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.update_category_by_id.UpdateCategoryByIdRequest;
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
public class UpdateCategoryByIdController {

  private final UpdateCategoryByIdActor actor;

  @Operation(summary = "Updates a category")
  @APIResponse(responseCode = "204")
  @PUT
  @Path("/{categoryId}")
  public void updateCategory(
      @PathParam("categoryId") Long categoryId, UpdateCategoryByIdRequest request) {
    var finalRequest = request.withCategoryId(categoryId);
    actor.command(finalRequest);
  }
}
