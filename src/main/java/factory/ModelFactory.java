package main.java.factory;

import main.java.model.Entity;
import main.java.model.Model;
import org.w3c.dom.Document;

import java.util.List;

public class ModelFactory {

    private static ModelFactory instance = null;
    public EntityFactory entityFactory = EntityFactory.getInstance();

    private ModelFactory(){

    }

    public static ModelFactory getInstance(){
        if(instance == null){
            instance = new ModelFactory();
        }
        return instance;
    }

    public Model createModel(Document doc){
        List<Entity> entityList;
        entityList = entityFactory.materializeFromXml(doc);
        Model model = new Model(doc.getDocumentElement().getAttribute("name"));
        model.getEntities().addAll(entityList);
        return model;
    }

}
