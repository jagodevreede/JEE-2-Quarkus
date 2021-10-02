package com.acme.inventory.repository;

import javax.ejb.Stateless;
import java.io.InputStream;
import java.util.Scanner;

@Stateless
public class ProductService {
    public String getFileContents() {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("example.txt");

        return inputStreamToString(stream);
    }

    private String inputStreamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
