package main.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Method;
import main.java.model.Model;

import java.util.*;

public class CheckVisitor implements IVisitor{

    //TODO On check dans un modele

    protected Map<String, String> heritances;
    protected Map<String, List<Attribute>> attributes;

    public Boolean isModelValid = true;


    public CheckVisitor(){
        heritances = new HashMap<>();
        attributes = new HashMap<>();
    }

    protected boolean isInParent(String source, String target){
        String nextHerit = heritances.get(target);
        while(null != nextHerit){
            if(source.equals(nextHerit)) return true;
            nextHerit = heritances.get(nextHerit);
        }
        return false;
    }
    protected boolean haveCycles(){
        for (Map.Entry<String, String> entry : heritances.entrySet()) {
            String child = entry.getKey();
            String parent = entry.getValue();
            if(isInParent(child, parent)){
                return true;
            }
        }
        return false;
    }

    protected boolean attributeInParents(List<Attribute> attributesToCheck, String parent){
        if(null == parent || !attributes.containsKey(parent)) return false;
        List<Attribute> parentAttributes = attributes.get(parent);
        for(Attribute attr : parentAttributes){
            if(attributesToCheck.contains(attr)) return true;
        }
        //if(null == heritances.get(parent)) return false;
        return attributeInParents(attributesToCheck, heritances.get(parent));
    }

    protected boolean haveDuplicateDeclaration(List<Entity> entities){
        for(Entity entity : entities){
            if(attributeInParents(entity.getAttributes(), entity.getInherits())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void visitModel(Model model) {
        for (Entity entity : model.getEntities()) {
            entity.accept(this);
        }
        if(haveCycles()){
            isModelValid = false;
            System.out.println("ERROR Cycle");
        }
        else if(haveDuplicateDeclaration(model.getEntities())){
            isModelValid = false;
            System.out.println("ERROR Duplicate declaration");
        }
    }

    @Override
    public void visitEntity(Entity entity) {
        heritances.put(entity.getName(), entity.getInherits());
        attributes.put(entity.getName(), entity.getAttributes());
    }

    @Override
    public void visitAttribute(Attribute attribute) {

    }

    @Override
    public void visitMethod(Method method) {

    }
}
