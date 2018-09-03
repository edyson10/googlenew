/*
*@autor edyson
*/
package Negocio;

import Vista.FormVista;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Lugares {

    List<Ciudad> listaCiudades = new LinkedList<>();
    List listaPaises = new LinkedList();
    private static String latitud, longitud, busquedad;
    FormVista view = new FormVista() {
    };
    Xml xml = new Xml();

    public Lugares() {
        cargarXml();
    }

    public void cargarXml() {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("Lugares.xml");
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List paises = rootNode.getChildren("Pais");

            for (int i = 0; i < paises.size(); i++) {
                Element pais = (Element) paises.get(i);
                String nombrePais = pais.getAttributeValue("nombre");

                List lista_ciudades = pais.getChildren();
                //Se recorre la lista de ciudades
                for (int j = 0; j < lista_ciudades.size(); j++) {
                    //Se obtiene el elemento 'ciudad'
                    Element ciudad = (Element) lista_ciudades.get(j);

                    String nombreCiudad = ciudad.getAttributeValue("nombre");
                    String longitud = ciudad.getChildTextTrim("longitud");
                    String latitud = ciudad.getChildTextTrim("latitud");
                    listaCiudades.add(new Ciudad(nombreCiudad, longitud, latitud));
                }
                listaPaises.add(nombrePais);
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
    }

    public Ciudad buscarCiudad(String nombre) {
        Ciudad ciudad = null;
        for (int i = 0; i < listaCiudades.size(); i++) {
            if (listaCiudades.get(i).getNombre().equalsIgnoreCase(nombre)) {
                ciudad = listaCiudades.get(i);
                latitud = ciudad.getLatitud();
                longitud = ciudad.getLongitud();
                //System.out.println("Nombre: "+listaCiudades.get(i).getNombre()+" Latitud: "+listaCiudades.get(i).getLatitud()+" Longitud: "+listaCiudades.get(i).getLongitud());
            }
        }
        return ciudad;
    }

    public String busquedad(String nombre) {
        this.busquedad = nombre;
        return busquedad;
    }

    public String url() {
        String xmlSource = "https://maps.googleapis.com/maps/api/place/textsearch/xml?types="
                + busquedad
                + "&location="
                + latitud
                + ","
                + longitud
                + "&radius=10000&key=AIzaSyCRtL6mH1q2LB0glBzcmu1UvvVA5BUp_l0";
        return xmlSource;
    }

    public HashMap xmlGoogle() {
        xml.xmlGoogle();
        return xml.lista();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Lugares();
    }
}
