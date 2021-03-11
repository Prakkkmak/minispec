package main.java.model;

public class SimpleType extends Type{


    protected String symbol;

    public SimpleType(String symbol) {
        super(0, 1);
        this.symbol = symbol;
    }

    public SimpleType(String symbol, Boolean notNull) {
        this(symbol);
        if(notNull) this.min = 1;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
