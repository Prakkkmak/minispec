package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

public class Attribute implements IVisitable {

    protected String type;
    protected String name;
    protected String defaultValue;

    public Attribute(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getType(){
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
