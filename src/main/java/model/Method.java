package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Method implements IVisitable {

    protected String scope;

    protected String type;

    protected String name;

    protected List<Attribute> attributes;

    public Method(String name,String type, String scope){
        this.attributes = new ArrayList<>();
        this.scope = scope;
        this.type = type;
        this.name = name;
    }

    public Method(String name, String type){
        this(name, type, null);
    }

    public Method(String name){
        this(name, "void", null);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitMethod(this);
    }
}
