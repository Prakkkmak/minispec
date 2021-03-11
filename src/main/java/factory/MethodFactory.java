package main.java.factory;

import main.java.model.Method;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MethodFactory {
    private static MethodFactory instance = null;

    private MethodFactory(){

    }

    public static MethodFactory getInstance(){
        if(instance == null){
            instance = new  MethodFactory();
        }
        return instance;
    }

    public Method createMethod(Node node){
        Method method = null;
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element methodElement = (Element) node;
            method = new Method(methodElement.getAttribute("name"), methodElement.getAttribute("type"), methodElement.getAttribute("scope"));
        }
        return method;
    }
}
