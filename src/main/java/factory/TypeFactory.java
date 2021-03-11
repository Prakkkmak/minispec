package main.java.factory;

import main.java.model.MultipleType;
import main.java.model.SimpleType;
import main.java.model.Type;

public class TypeFactory {

    private static TypeFactory instance = null;

    private TypeFactory(){ }

    public static TypeFactory getInstance(){
        if(instance == null){
            instance = new  TypeFactory();
        }
        return instance;
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
