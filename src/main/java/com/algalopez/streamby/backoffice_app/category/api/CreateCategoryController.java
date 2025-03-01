package com.algalopez.streamby.backoffice_app.category.api;

import com.algalopez.streamby.backoffice_app.category.application.create_category.CreateCategoryActor;
import com.algalopez.streamby.backoffice_app.category.application.create_category.CreateCategoryRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
public class CreateCategoryController {

  private final CreateCategoryActor actor;

  @Operation(summary = "Create a category")
  @APIResponse(responseCode = "204")
  @POST
  @Path("/")
  public void createCategory(CreateCategoryRequest request) {
    actor.command(request);
  }
}
