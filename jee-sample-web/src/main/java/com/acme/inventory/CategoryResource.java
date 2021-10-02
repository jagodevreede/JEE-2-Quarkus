package com.acme.inventory;

import com.acme.inventory.repository.Category;
import com.acme.inventory.repository.CategoryRepository;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @EJB
    private CategoryRepository categoryRepository;

    @Consumes(MediaType.TEXT_PLAIN)
    @POST
    public Category addNewCategory(String name) {
        return categoryRepository.newCategory(name);
    }

    @GET
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

}
