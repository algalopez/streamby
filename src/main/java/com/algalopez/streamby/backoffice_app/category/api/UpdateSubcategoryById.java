package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id.UpdateSubcategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.update_subcategory_by_id.UpdateSubcategoryByIdRequest;
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
public class UpdateSubcategoryById {

  private final UpdateSubcategoryByIdActor actor;

  @Operation(summary = "Updates a subcategory")
  @APIResponse(responseCode = "204")
  @PUT
  @Path("/{categoryId}/subcategory/{subcategoryId}")
  public void updateSubcategory(
      @PathParam("categoryId") Long categoryId,
      @PathParam("subcategoryId") Long subcategoryId,
      UpdateSubcategoryByIdRequest request) {
    var finalRequest = request.withCategoryId(categoryId).withSubcategoryId(subcategoryId);
    actor.command(finalRequest);
  }
}
