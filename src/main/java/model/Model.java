package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Model implements IVisitable {

    protected String name;

    protected List<Entity> entities;

    public Model(String name){
        this.name = name;
        entities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitModel(this);
    }
}
