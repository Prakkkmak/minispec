package test.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.visitor.IVisitor;
import main.java.visitor.Visitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

    Visitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new Visitor();
    }

    @Test
    void visitEntity() {
        Entity entity = new Entity("MaClasse");
        entity.accept(visitor);
        assertEquals("public class MaClasse{}", visitor.getGeneratedCode());
    }

    @Test
    void visitEntityWithAttribute() {
        Entity entity = new Entity("MaClasse");
        entity.getAttributes().add(new Attribute("int", "a"));
        entity.accept(visitor);
        assertEquals("public class MaClasse{int a;}", visitor.getGeneratedCode());
    }

    @Test
    void visitModel() {

    }

    @Test
    void visitAttribute() {
        Attribute attribute = new Attribute("int", "a");
        attribute.accept(visitor);
        assertEquals("int a;", visitor.getGeneratedCode());
    }

    @Test
    void visitAttributeWithDefaultValue() {
        Attribute attribute = new Attribute("int", "a");
        attribute.setDefaultValue("999");
        attribute.accept(visitor);
        assertEquals("int a=999;", visitor.getGeneratedCode());
    }
}