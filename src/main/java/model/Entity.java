package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Entity implements IVisitable {
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

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEntity(this);
    }
}

