package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id.DeleteSubcategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.delete_subcategory_by_id.DeleteSubcategoryByIdRequest;
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
public class DeleteSubcategoryController {

  private final DeleteSubcategoryByIdActor actor;

  @Operation(summary = "Delete a subcategory")
  @APIResponse(responseCode = "204")
  @DELETE
  @Path("/{categoryId}/subcategory/{subcategoryId}")
  public void deleteSubcategory(
      @PathParam("categoryId") Long categoryId, @PathParam("subcategoryId") Long subcategoryId) {
    var request =
        DeleteSubcategoryByIdRequest.builder()
            .categoryId(categoryId)
            .subcategoryId(subcategoryId)
            .build();
    actor.command(request);
  }
}
