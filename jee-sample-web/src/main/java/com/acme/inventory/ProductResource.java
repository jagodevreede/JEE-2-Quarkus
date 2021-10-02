package com.acme.inventory;

import com.acme.inventory.repository.ProductRepository;
import com.acme.inventory.repository.ProductService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Resource(lookup="resource/jee-sample/priceMultiplier")
    private double priceMultiplier;

    @EJB
    private ProductRepository productRepository;

    @EJB
    private ProductService productService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("file")
    public String getContentsOfFile() {
        return productService.getFileContents();
    }

    @GET
    public List<ProductDTO> getProducts(@QueryParam("name") String name) {
        return productRepository.byName(name).stream()
                .map(p -> ProductDTO.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .listPrice(p.getListPrice().multiply(new BigDecimal(priceMultiplier)).setScale(2, RoundingMode.HALF_UP))
                        .modelYear(p.getModelYear())
                        .brand(p.getBrand().getName())
                        .category(p.getCategory().getName())
                        .build())
                .collect(Collectors.toList());
    }

}
