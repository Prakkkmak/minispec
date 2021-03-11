package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

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
}
