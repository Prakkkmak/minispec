package main.java.factory;

import main.java.model.MultipleType;
import main.java.model.SimpleType;
import main.java.model.Type;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TypeFactory {

    private static TypeFactory instance = null;

    private TypeFactory(){ }

    public static TypeFactory getInstance(){
        if(instance == null){
            instance = new  TypeFactory();
        }
        return instance;
    }

    public Type createType(Node node){
        Node currentNode = node;
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element e = (Element) currentNode;
            if(currentNode.getNodeName() .equals("simpletype") ){
                return new SimpleType(e.getAttribute("symbol"));
            }
            else{
                switch (e.getAttribute("symbol")){
                    case "List":
                        return new MultipleType(MultipleType.Collection.LIST, createType(currentNode.getFirstChild().getNextSibling()));
                    case "Bag":
                        return new MultipleType(MultipleType.Collection.BAG, createType(currentNode.getFirstChild().getNextSibling()));
                    case "Array":
                        return new MultipleType(MultipleType.Collection.ARRAY, createType(currentNode.getFirstChild().getNextSibling()));
                    case "Set":
                        return new MultipleType(MultipleType.Collection.SET, createType(currentNode.getFirstChild().getNextSibling()));
                    default:
                        throw new IllegalStateException("Unexpected value: " + e.getAttribute("symbol"));
                }
            }
        }
        return null;
    }

    public Type generateType(String symbol, int cardMin, int cardMax) throws Exception {
        if(cardMin > cardMax) throw new Exception("La cardinalité minimum doit etre suppérieure à la maximum");
        Type type = new SimpleType(symbol);
        if(cardMax > 1){
            type = new MultipleType(type);
        }
        return type;
    }

    public Type generateType(String symbol) throws Exception {
        return generateType(symbol, 1 , 1);
    }

    public Type generateType() throws Exception {
        return generateType("a");
    }
}
