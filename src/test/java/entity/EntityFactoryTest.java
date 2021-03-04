package test.java.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.factory.EntityFactory;

public class EntityFactoryTest {
    
    @BeforeEach
    void setUp() {
        EntityFactory factory = EntityFactory.getInstance();
    }

    @Test
    void testMaterializeFromXml(){
        //TODO
    }

}
