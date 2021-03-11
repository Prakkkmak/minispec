package main.java.factory;

import main.java.model.Attribute;
import main.java.model.Entity;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AttributeFactory {
    private static AttributeFactory instance = null;

    private AttributeFactory(){

    }

    public static AttributeFactory getInstance(){
        if(instance == null){
            instance = new  AttributeFactory();
        }
        return instance;
    }

    public Attribute createAttribute(Node node){
        Attribute attribute = null;
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element attributeElement = (Element) node;
            String type = attributeElement.getAttribute("type");
            String name = attributeElement.getAttribute("name");
            String value = attributeElement.getAttribute("value");
            attribute = new Attribute(type, name);
            attribute.setDefaultValue(value);
        }
        return attribute;
    }

}
