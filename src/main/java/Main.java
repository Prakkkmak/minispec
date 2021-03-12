package main.java;

import main.java.factory.ModelFactory;
import main.java.model.Model;
import main.java.utils.Beautifer;
import main.java.visitor.IVisitor;
import main.java.visitor.Visitor;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        ModelFactory modelFactory = ModelFactory.getInstance();


        try {
            File file = new File("model.xml");
            builder = docFactory.newDocumentBuilder();
            doc = builder.parse(file);
            Model model = modelFactory.createModel(doc);
            Visitor visitor = new Visitor();
            model.accept(visitor);
            System.out.println(visitor.getGeneratedCode());
            Beautifer beautifer = new Beautifer();
            System.out.println(beautifer.Beautify(visitor.getGeneratedCode()));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
