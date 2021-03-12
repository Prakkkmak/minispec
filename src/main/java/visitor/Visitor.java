package main.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Method;
import main.java.model.Model;

import java.util.List;

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
        if(null != entity.getInherits()){
            generatedCode.append(" extends ");
            generatedCode.append(entity.getInherits());
        }
        generatedCode.append("{");
        for (Attribute attribute : entity.getAttributes()) {
            attribute.accept(this);
            generatedCode.append(";");
        }
        for (Method method : entity.getMethods()) {
            method.accept(this);
        }
        generatedCode.append("}");
    }

    @Override
    public void visitModel(Model model) {
        generatedCode.append("package ");
        generatedCode.append(model.getName());
        generatedCode.append(";");
        for (Entity e : model.getEntities()) {
            e.accept(this);
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        generatedCode.append(attribute.getType());
        generatedCode.append(" ");
        generatedCode.append(attribute.getName());
        if(null != attribute.getDefaultValue()){
            generatedCode.append("=");
            generatedCode.append(attribute.getDefaultValue());
        }
    }

    @Override
    public void visitMethod(Method method) {
        if(null != method.getScope()){
            generatedCode.append(method.getScope());
        }
        generatedCode.append(" ");
        generatedCode.append(method.getType());
        generatedCode.append(" ");
        generatedCode.append(method.getName());
        generatedCode.append("(");
        List<Attribute> attributes = method.getAttributes();
        for (int i = 0; i < attributes.size(); i++) {
            if(0 != i) generatedCode.append(",");
            attributes.get(i).accept(this);
        }
        generatedCode.append("){");
        generatedCode.append("/* TODO Generated Code */");
        if(!"void".equals(method.getType().toString())){
            generatedCode.append("return new ");
            generatedCode.append(method.getType());
            generatedCode.append("();");
        }
        generatedCode.append("}");
    }
}
