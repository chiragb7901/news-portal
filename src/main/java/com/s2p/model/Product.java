package com.s2p.model;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @JoinTable(name="product_category", joinColumns = {
            @JoinColumn(name="product_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name="category_id")
    })
    @ElementCollection
    Set<Category> categories = new HashSet<Category>();

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
