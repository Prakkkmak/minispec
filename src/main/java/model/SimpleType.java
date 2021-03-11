package main.java.model;

public class SimpleType extends Type{


    public SimpleType(String symbol) {
        super(symbol, 0, 1);
    }

    public SimpleType(String symbol, Boolean notNull) {
        super(symbol, 0, 1);
        if(notNull) this.min = 1;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
