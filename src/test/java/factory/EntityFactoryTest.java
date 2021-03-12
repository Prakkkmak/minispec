package test.java.factory;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;
import java.util.List;

import main.java.factory.EntityFactory;
import main.java.model.Entity;

public class EntityFactoryTest {

    EntityFactory entityfactory;

    @BeforeEach
    void setUp() {
        entityfactory = EntityFactory.getInstance();
    }

    @Test
    public void testMaterializeFromXmlWithoutAttributes() {
        // TODO
        String xml = "<entities>"
                        +"<entity name=\"patrick\"></entity>"
                    +"</entities>";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        List<Entity> entityList = null;
        try {
            builder = docFactory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xml)));
            entityList = entityfactory.materializeFromXml(doc);
            //System.out.println(entityList.get(1));
            assertTrue(entityList.size() == 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }  
    }

    @Test
    public void testMaterializeFromXmlWithAttribute(){
        String xml = "<entities>"
                +"<entity name=\"patrick\">"
                +"<attributes>"
                +"<attribute name = \"test\">"
                +"<simpletype symbol = \"int\"/>"
                +"</attribute>"
                +"</attributes>"
                +"</entity>"
                +"</entities>";
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        List<Entity> entityList = null;
        try {
            builder = docFactory.newDocumentBuilder();
            doc = builder.parse(new InputSource(new StringReader(xml)));
            entityList = entityfactory.materializeFromXml(doc);
            System.out.println(entityList.get(0).getAttributes().get(0).getType());
            assertEquals(entityList.get(0).getAttributes().get(0).getType().toString(), "int");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fail();
        }
    }



}
