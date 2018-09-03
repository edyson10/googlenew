/*
*@autor edyson
*/
package Negocio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.DOMBuilder;
import org.xml.sax.SAXException;

public class Xml {

    HashMap<String, String> listaLugares = new HashMap();
    List listaNombres = new LinkedList<>();

    public Xml() {
    }

    public void xmlGoogle() {
        Lugares lugares = new Lugares();
        String url = lugares.url();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder dombuilder = factory.newDocumentBuilder();
            org.w3c.dom.Document w3cDocument = dombuilder.parse(url);
            DOMBuilder jdomBuilder = new DOMBuilder();
            Document jdomDocument = jdomBuilder.build(w3cDocument);

            // Obtener el elemento Raiz
            Element rootNode = jdomDocument.getRootElement();
            List list = rootNode.getChildren("result");
            //Se recorre la lista de hijos 'result'
            for (int i = 0; i < list.size(); i++) {
                Element campo = (Element) list.get(i);
                listaLugares.put(campo.getChildTextTrim("name"), campo.getChildTextTrim("formatted_address"));
                //System.out.println("Nombre: " + campo.getChildTextTrim("name") + "  Dirección: " + campo.getChildTextTrim("formatted_address"));
            }
//            Iterator it = listaLugares.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry e = (Map.Entry) it.next();
//                System.out.println(e.getKey() + " " + e.getValue());
//            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap lista() {
        return listaLugares;
    }
}
