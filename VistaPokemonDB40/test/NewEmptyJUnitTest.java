/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Pokemon.Pokemon;
import Pokemon.VistaPokemon;
import Region.Region;
import Entrenador1.Entrenador;
import javax.swing.JComboBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Infante96
 */
public class NewEmptyJUnitTest {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public  void Test_Constructor_Clase_Pokemon(){
    
        Pokemon p1 = new Pokemon(25,"Pikachu","Electrico",90,"Voltio Cruel",3.35);
        Pokemon p2 = new Pokemon(9,"Blastoise","Agua",130,"Hidrobomba",43.2);
        Pokemon p3 = new Pokemon(447,"Riolu","Lucha",50,"Tajo Cruzado",11.26);
       
        Assert.assertEquals("Pikachu",p1.getNombre());
        Assert.assertEquals("Riolu",p3.getNombre());
        Assert.assertEquals(130,p2.getHurt());
        
        
    }
    @Test 
    public  void Test_Anadir_Pokemon_Array_List(){
    
        Pokemon p1 = new Pokemon(25,"Pikachu","Electrico",90,"Voltio Cruel",3.35);
      
        VistaPokemon v = new VistaPokemon();
        int total_vehiculos = 0;
        Assert.assertEquals(total_vehiculos, v.arrayPokemon.size());
        
        v.arrayPokemon.add(p1);
       // total_vehiculos =  v.arrayPokemon.size();
        Assert.assertEquals(total_vehiculos+1, v.arrayPokemon.size());
        
    }
    @Test
    public void Test_Eliminar_Pokemon_Array(){
    
        Pokemon p3 = new Pokemon(447,"Riolu","Lucha",50,"Tajo Cruzado",11.26);

        VistaPokemon v = new VistaPokemon();
        int eliminado = 0;

        v.arrayPokemon.add(p3);
        //Primero lo  he añadido por que si no el array no va a tener ningun elemento para eliminar.
        v.arrayPokemon.remove(v.arrayPokemon.size()-1);
        Assert.assertEquals(eliminado, v.arrayPokemon.size());
    
    }
     @Test
    public void Test_UsoDeSetGet_Region_Clse(){
    
        Region p3 = new Region(0, "verde","Hoem", 256,"GimSS");

    
        String piedra_region =p3.getPiedras_Region();
         Assert.assertEquals(piedra_region,p3.getPiedras_Region());
         p3.setPiedras_Region("amarillo");
         piedra_region = "amarillo";
        Assert.assertEquals(piedra_region,p3.getPiedras_Region());
    }
    @Test
    public void Test_Get_Entrenador_Entrenador_Clse(){
        Entrenador e1 = new Entrenador(1, "Luis",40,200, "rojo","Granada");

       Assert.assertEquals(1,e1.getId_Entrenador());
       Assert.assertEquals(40,e1.getEdad());
       Assert.assertEquals("Luis",e1.getNombre());
    }
   
    @Test
    public void Test_Anadir_ComboBox_Datos(){
        int i = 0;
        JComboBox micombo=new JComboBox();
        
        String var = null;
        micombo.addItem(var);
        Assert.assertEquals(1,micombo.getItemCount());
    
    }
        @Test
    public void Test_Eliminar_ComboBox_Datos(){
        int i = 0;
        JComboBox micombo=new JComboBox();
        
        String var = null;
        micombo.addItem(var);       
        micombo.removeItemAt(0);
        Assert.assertEquals(0,micombo.getItemCount());
    
    }
}