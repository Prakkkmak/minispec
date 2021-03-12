package main.java.model;

public class MultipleType extends Type{

    public enum Collection {
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

    protected Type type;

    public MultipleType(Collection collection, Type type, Integer min, Integer max) {
        super(min, max);
        this.collection = collection;
        this.type = type;
    }

    public MultipleType(Type type) {
        this(Collection.LIST, type);
    }

    public MultipleType(Collection collection, Type type) {
        this(collection, type, 0, Integer.MAX_VALUE);
    }

    @Override
    public String toString() {
        return this.collection.name + "<" + this.type.toString() + ">";
    }
}
