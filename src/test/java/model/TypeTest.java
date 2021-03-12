package test.java.model;

import main.java.model.MultipleType;
import main.java.model.SimpleType;
import main.java.model.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {



    @Test
    void testToString() {
        Type type = new SimpleType("Integer");
        assertEquals("Integer", type.toString());
    }

    @Test
    void testToStringVoid() {
        Type type = new SimpleType("void");
        assertEquals("void", type.toString());
    }

    @Test
    void testToStringGeneric() {
        Type subType = new SimpleType("Integer");
        Type type = new MultipleType(MultipleType.Collection.ARRAY, subType);
        assertEquals("Array<Integer>", type.toString());
    }

    @Test
    void testToStringGenericWithoutCollectionSpecified() {
        Type subType = new SimpleType("Integer");
        Type type = new MultipleType(subType);
        assertEquals("List<Integer>", type.toString());
    }
    @Test
    void testToStringGenericWithMultipleAsGeneric() {
        Type subType = new SimpleType("Integer");
        Type multipleSubType = new MultipleType(MultipleType.Collection.BAG, subType);
        Type type = new MultipleType(multipleSubType);
        assertEquals("List<Bag<Integer>>", type.toString());
    }
}