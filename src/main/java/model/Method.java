package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

public class Method implements IVisitable {

    protected String scope;

    protected String type;

    protected String name;

    protected List<Attribute> attributes;

    public Method(String name, String type, String scope){
        this.attributes = new ArrayList<>();
        this.name = name;
        this.type = type;
        this.scope = scope;
    }

    public Method(String name, String type){
        this(name, type, null);
    }

    public Method(String name){
        this(name, "void", null);
    }

    public String getScope() {
        return scope;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitMethod(this);
    }
}
