package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdActor;
import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdRequest;
import com.algalopez.streamby.backoffice_app.category.application.get_category_by_id.GetCategoryByIdResponse;
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
public class GetCategoryByIdController {

  private final GetCategoryByIdActor actor;

  @Operation(summary = "Get category by subcategoryId")
  @APIResponse(
      responseCode = "200",
      content = @Content(schema = @Schema(implementation = GetCategoryByIdActor.class)))
  @GET
  @Path("/{categoryId}")
  public GetCategoryByIdResponse getCategoryById(@PathParam("categoryId") Long categoryId) {
    GetCategoryByIdRequest request =
        GetCategoryByIdRequest.builder().categoryId(categoryId).build();
    return actor.query(request);
  }
}
