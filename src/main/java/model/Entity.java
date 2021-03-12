package main.java.model;

import main.java.visitor.IVisitable;
import main.java.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Entity implements IVisitable {
    protected String name;
    protected List<Attribute> attributes;
    protected List<Method> methods;
    protected String inherits;
    public Entity(String name){
        attributes = new ArrayList<>();
        methods = new ArrayList<>();
        this.name = name;
    }
    public Entity(String name, String inherits){
        this(name);
        this.inherits = inherits;
    }
    public String getName(){
        return this.name;
    }
    public List<Attribute> getAttributes(){
        return this.attributes;
    }
    public String getInherits() {
        return inherits;
    }
    public List<Method> getMethods() {
        return methods;
    }
    public void addAttribute(Attribute a){
        this.attributes.add(a);
    }
    public void addMethod(Method method) {
        this.methods.add(method);
    }
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEntity(this);
    }


}

