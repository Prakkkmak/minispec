package test.java.visitor;

import main.java.model.Attribute;
import main.java.model.Entity;
import main.java.model.Model;
import main.java.model.SimpleType;
import main.java.visitor.CheckVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckVisitorTest {

    CheckVisitor visitor;

    @BeforeEach
    void setUp() {
        visitor = new CheckVisitor();
    }

    @Test
    void testHaveCycle(){
        Model model = new Model("Model1");
        Entity entity1 = new Entity("A", "B");
        Entity entity2 = new Entity("B", "C");
        Entity entity3 = new Entity("C", "A");
        model.getEntities().add(entity1);
        model.getEntities().add(entity2);
        model.getEntities().add(entity3);
        model.accept(visitor);
        assertFalse(visitor.isModelValid);
    }

    @Test
    void testNoCycle(){
        Model model = new Model("Model1");
        Entity entity1 = new Entity("A", "B");
        Entity entity2 = new Entity("B");
        model.getEntities().add(entity1);
        model.getEntities().add(entity2);
        model.accept(visitor);
        assertTrue(visitor.isModelValid);
    }

    @Test
    void testDuplicateDeclaration(){
        Model model = new Model("Model");
        Entity entity1 = new Entity("A", "B");
        entity1.addAttribute(new Attribute("a1", new SimpleType("Integer")));
        Entity entity2 = new Entity("B");
        entity2.addAttribute(new Attribute("a1", new SimpleType("String")));
        model.getEntities().add(entity1);
        model.getEntities().add(entity2);
        model.accept(visitor);
        assertFalse(visitor.isModelValid);
    }

    @Test
    void testNotDuplicateDeclaration(){
        Model model = new Model("Model");
        Entity entity1 = new Entity("A", "B");
        entity1.addAttribute(new Attribute("a1", new SimpleType("Integer")));
        Entity entity2 = new Entity("B");
        entity2.addAttribute(new Attribute("a2", new SimpleType("String")));
        model.getEntities().add(entity1);
        model.getEntities().add(entity2);
        model.accept(visitor);
        assertTrue(visitor.isModelValid);
    }

}