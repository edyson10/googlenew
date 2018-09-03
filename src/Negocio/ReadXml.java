/*
*@autor edyson
*/
package Negocio;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class ReadXml {
    
    private String lugares;
    
    private static String xmlSource = "https://maps.googleapis.com/maps/api/place/textsearch/xml?types=restaurant&location=7.8890971,-72.49668&radius=10000&key=AIzaSyCRtL6mH1q2LB0glBzcmu1UvvVA5BUp_l0";

    public String getLugares() {
        return lugares;
    }

    public void setLugares(String lugares) {
        this.lugares = lugares;
    }
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        ReadXml read = new ReadXml();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder dombuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document w3cDocument = dombuilder.parse(xmlSource);
        DOMBuilder jdomBuilder = new DOMBuilder();
        Document jdomDocument = jdomBuilder.build(w3cDocument);

        // Obtener el elemento Raiz
        Element rootNode = jdomDocument.getRootElement();

        List list = rootNode.getChildren("result");

        //Se recorre la lista de hijos 'result'
        String cad = "";
        for (int i = 0; i < list.size(); i++) {
            Element campo = (Element) list.get(i);
            cad += "\n" +("Nombre: " + campo.getChildTextTrim("name") + "  Dirección: " + campo.getChildTextTrim("formatted_address")+ " estado " + campo.getChildTextTrim("opening_hours"));
        }
        //read.lugares = cad;
        JOptionPane.showMessageDialog(null, cad);
    }
}