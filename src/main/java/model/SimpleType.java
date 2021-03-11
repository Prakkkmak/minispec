package main.java.model;

public class SimpleType extends Type{
    public static Type STRING = new SimpleType("String");
    public static Type CHARACTER = new SimpleType("Character");
    public static Type INTEGER = new SimpleType("Integer");
    public static Type LONG = new SimpleType("Long");
    public static Type DOUBLE = new SimpleType("Double");
    public static Type FLOAT = new SimpleType("Float");
    public static Type VOID = new SimpleType("void");

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
