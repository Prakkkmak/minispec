package main.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Model;

public class Visitor implements IVisitor{

    protected StringBuilder generatedCode;

    public Visitor(){
        generatedCode = new StringBuilder();
    }

    public String getGeneratedCode(){
        return generatedCode.toString();
    }

    @Override
    public void visitEntity(Entity entity) {
        generatedCode.append("public class ");
        generatedCode.append(entity.getName());
        generatedCode.append("{");
        for (Attribute attribute : entity.getAttributes()) {
            attribute.accept(this);
        }
        generatedCode.append("}");
    }

    @Override
    public void visitModel(Model model) {
        //TODO
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        //TODO
    }
}
