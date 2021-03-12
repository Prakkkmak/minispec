package test.java.visitor;

import main.java.model.*;
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
        entity.getAttributes().add(new Attribute("a", SimpleType.INTEGER));
        entity.accept(visitor);
        assertEquals("public class MaClasse{Integer a;}", visitor.getGeneratedCode());
    }

    @Test
    void visitEntityWithInheritance() {
        Entity entity = new Entity("MaClasse", "ClasseB");
        entity.getAttributes().add(new Attribute("a", SimpleType.INTEGER));
        entity.accept(visitor);
        assertEquals("public class MaClasse extends ClasseB{Integer a;}", visitor.getGeneratedCode());
    }

    @Test
    void visitEntityWithAttributeAndMethods() {
        Entity entity = new Entity("MaClasse");
        entity.getAttributes().add(new Attribute("a", SimpleType.INTEGER));
        entity.getMethods().add(new Method("test", SimpleType.STRING, "public"));
        entity.accept(visitor);
        assertEquals("public class MaClasse{Integer a;public String test(){/* TODO Generated Code */return new String();}}", visitor.getGeneratedCode());
    }

    @Test
    void visitModel() {
        Model model = new Model("Model1");
        Entity entity1 = new Entity("MaClasse");
        Entity entity2 = new Entity("MaClasse");
        model.getEntities().add(entity1);
        model.getEntities().add(entity2);
        model.accept(visitor);
        assertEquals("package Model1;public class MaClasse{}public class MaClasse{}", visitor.getGeneratedCode());
    }

    @Test
    void visitAttribute() {
        Attribute attribute = new Attribute("a", SimpleType.INTEGER);
        attribute.accept(visitor);
        assertEquals("Integer a", visitor.getGeneratedCode());
    }

    @Test
    void visitAttributeWithDefaultValue() {
        Attribute attribute = new Attribute("a", SimpleType.INTEGER);
        attribute.setDefaultValue("999");
        attribute.accept(visitor);
        assertEquals("Integer a=999", visitor.getGeneratedCode());
    }

    @Test
    void visitMethod() {
        Method method = new Method("test", SimpleType.STRING, "public");
        method.accept(visitor);
        assertEquals("public String test(){/* TODO Generated Code */return new String();}", visitor.getGeneratedCode());
    }
}