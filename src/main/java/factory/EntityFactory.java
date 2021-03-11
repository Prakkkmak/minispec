package main.java.factory;


import main.java.model.Attribute;
import main.java.model.Entity;

import main.java.model.Method;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public final class EntityFactory {

    private static EntityFactory instance = null;
    AttributeFactory attributeFactory;
    MethodFactory methodFactory;

    private EntityFactory(){

    }

    public static EntityFactory getInstance(){
        if(instance == null){
            instance = new  EntityFactory();
        }
        return instance;
    }

    public List<Entity> materializeFromXml(String filename) throws ParserConfigurationException, SAXException, IOException{
        List<Entity> listeEntity = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document document = builder.parse(new File(filename));
	    
	    document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("entity");

        Entity currentEntity = null;

        for (int i = 0; i < nList.getLength(); i++){
            currentEntity = createEntity(nList.item(i));
            listeEntity.add(currentEntity);
        }        

        return listeEntity;
    }

    public List<Entity> materializeFromXml(Document document){
        List<Entity> listeEntity = new ArrayList<>();
	    
	    document.getDocumentElement().normalize();

        NodeList nList = document.getElementsByTagName("entity");

        Entity currentEntity = null;

        for (int i = 0; i < nList.getLength(); i++){
            currentEntity = createEntity(nList.item(i));
            listeEntity.add(currentEntity);
        }        

        return listeEntity;
    }


    public Entity createEntity(Node node){

        methodFactory = MethodFactory.getInstance();
        attributeFactory = AttributeFactory.getInstance();
        Entity e = null;
        NodeList nListAttribute;
        NodeList nListMethods;
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element entityElement = (Element) node;
            String name = entityElement.getAttribute("name");
            e = new Entity(name);
            nListAttribute = entityElement.getElementsByTagName("attribute");
            if (nListAttribute != null){
                for (int i = 0; i < nListAttribute.getLength(); i++){
                    Attribute attribute = attributeFactory.createAttribute(nListAttribute.item(i));
                    e.addAttribute(attribute);
                }
            }
            nListMethods = entityElement.getElementsByTagName("method");
            if(nListMethods != null){
                for (int i = 0; i<nListMethods.getLength(); i++){
                    Method method = methodFactory.createMethod(nListMethods.item(i));
                    e.addMethod(method);
                }
            }
        }
        return e;
    }

}
