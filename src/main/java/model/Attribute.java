package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

import java.util.Objects;

public class Attribute implements IVisitable {

    protected Type type;
    protected String name;
    protected String defaultValue;

    public Attribute(String name, Type type){
        this.type = type;
        this.name = name;
    }

    public Type getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitAttribute(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(name, attribute.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
