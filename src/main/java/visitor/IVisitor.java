package main.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Model;


public interface IVisitor {
    void visitEntity(Entity entity);
    void visitModel(Model model);
    void visitAttribute(Attribute attribute);
}
