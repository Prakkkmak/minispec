package main.java.factory;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Type;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AttributeFactory {
    private static AttributeFactory instance = null;
    TypeFactory typeFactory = TypeFactory.getInstance();
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
            String name = attributeElement.getAttribute("name");
            String value = attributeElement.getAttribute("value");
            Type type = typeFactory.createType(node.getFirstChild());
            attribute = new Attribute(name, type);
            attribute.setDefaultValue(value);
        }
        return attribute;
    }

}
