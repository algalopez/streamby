package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id.DeleteCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.delete_category_by_id.DeleteCategoryByIdRequest;
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
public class DeleteCategoryController {

  private final DeleteCategoryByIdActor actor;

  @Operation(summary = "Delete a category")
  @APIResponse(responseCode = "204")
  @DELETE
  @Path("/{categoryId}")
  public void deleteCategory(@PathParam("categoryId") Long categoryId) {
    var request = DeleteCategoryByIdRequest.builder().categoryId(categoryId).build();
    actor.command(request);
  }
}
