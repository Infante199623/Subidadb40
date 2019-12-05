/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador1;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Infante96
 */
public class GestionContenido extends  DefaultHandler {	 
            
            Entrenador e;
            String fichero = "";
            private ArrayList<Entrenador> arrayEntrenador = new ArrayList();

        public void setArrayEntrenador(ArrayList<Entrenador> arrayEntrenador) {
            this.arrayEntrenador = arrayEntrenador;
        }
            
            
    public GestionContenido() {
	        super();
	    }	    
	    public void startDocument() {
	       // System.out.println("Comienzo del Documento XML");
               
	    }	    
	    public void endDocument() {
	       // System.out.println("Final del Documento XML");
	   
            }	 
	    public void startElement(String uri, String nombre,String nombreC, Attributes atts) {
	      //  System.out.printf("\t Principio Elemento: %s %n",nombre);
                fichero = nombre;     
                if(fichero.equals("entrenador")){
                    e = new Entrenador();
                
                }

	    } 	
	    public void endElement(String uri, String nombre,String nombreC) {
	       // System.out.printf("\tFin Elemento: %s %n", nombre);
                 fichero = nombre;
                
                if(fichero.equals("entrenador")){
                      arrayEntrenador.add(e);
                }
	    }	
	    public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		   String car = new String(ch, inicio, longitud);
               //quitar saltos de línea	
		   car = car.replaceAll("[\t\n]","");	   
		   //System.out.printf ("\t Caracteres: %s %n", car);
                   
                    if(fichero.equals("nombre")){
                       e.setNombre(String.valueOf(car));
                   } 
                    if(fichero.equals("ciudad")){
                       e.setCiudad(String.valueOf(car));
                   }
                    if(fichero.equals("edad")){
                       e.setEdad(Integer.parseInt(car));
                   }
                    if(fichero.equals("pokemonCapturados")){
                       e.setPokemon_Capturados(Integer.parseInt(car));
                   }
                    if(fichero.equals("equipo")){
                         e.setEquipo(String.valueOf(car));
                    }
	    }	
            
}