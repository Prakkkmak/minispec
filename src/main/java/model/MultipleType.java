package main.java.model;

public class MultipleType extends Type{

    enum Collection {
        ARRAY("Array"),
        BAG("Bag"),
        LIST("List"),
        SET("Set");

        public final String name;

        private Collection(String name) {
            this.name = name;
        }
    }


    protected Collection collection;

    public MultipleType(String symbol, Integer min, Integer max) {
        super(symbol, min, max);
    }

    public MultipleType(String symbol) {
        super(symbol, 0, Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return this.collection.name + "<" + this.symbol + ">";
    }
}
