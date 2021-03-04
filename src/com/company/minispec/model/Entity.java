package com.company.minispec.model;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    protected String name;
    protected List<Attribute> attributes;

    public Entity(String name){
        attributes = new ArrayList<>();
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Attribute> getAttributes(){
        return this.attributes;
    }
}

