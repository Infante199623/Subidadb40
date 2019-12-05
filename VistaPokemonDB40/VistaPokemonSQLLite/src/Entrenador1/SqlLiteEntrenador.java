/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entrenador1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Infante96
 */
public class SqlLiteEntrenador{	 
            
    private ArrayList<Entrenador> arrayEntrenador;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public SqlLiteEntrenador() {
        
        this.ruta = "C:\\Users\\Infante96\\Desktop\\pokemon.db";
        this.url = "jdbc:sqlite:";
    
          try{
            this.con = (Connection) DriverManager.getConnection(this.url+this.ruta);   
                if(this.con== null){
                    con.close();
                }
            }catch (SQLException e){
                
                 System.out.println(""+e);
            }
    }

    public static Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void setArrayEntrenador(ArrayList<Entrenador> arrayEntrenador) {
        this.arrayEntrenador = arrayEntrenador;
    }
     public ArrayList<Entrenador>  getArrayEntrenador() {
        return this.arrayEntrenador;
    }    
    public static int AddConsultaEntrenador(String nombre,int edad,int pokemon_capturados,String ciudad,String equipo,SqlLiteEntrenador r)throws SQLException{
        int id = 0;
        
        String query = "INSERT INTO entrenador (nombre,edad,pokemon_capturados,ciudad,equipo) VALUES (?,?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) r.getCon().prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.setInt(3, pokemon_capturados);
        ps.setString(4, ciudad);
        ps.setString(5, equipo);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            id=rs.getInt(1);
        }
        
        return id;

        }
    public static void deleteEntrenador(Entrenador r) throws SQLException{
            
        String query = "DELETE FROM entrenador WHERE nombre = ?";
        PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
 
    }
    public static void get_EntrenadorSistema(ArrayList<Entrenador> arrayEntrenador,SqlLiteEntrenador r) throws SQLException{
  
    Statement stmt = null;
    int id_entrenador = 0;
    String nombre = null;
    int edad = 0;
    int pokemon_capturados  = 0;
    String ciudad = null;
    String equipo = null;
    
    String query = "select * from entrenador";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     Entrenador u = new Entrenador();

                     id_entrenador = rs.getInt("id_entrenador");
                     u.setId_Entrandor(id_entrenador);

                     nombre = rs.getString("nombre");
                     u.setNombre(nombre);

                     edad = rs.getInt("edad");
                     u.setEdad(edad);

                     pokemon_capturados = rs.getInt("pokemon_capturados");
                     u.setPokemon_Capturados(pokemon_capturados);
                        
                    ciudad = rs.getString("ciudad");
                    u.setCiudad(ciudad);
                     
                     equipo = rs.getString("equipo");
                     u.setEquipo(equipo);

                     arrayEntrenador.add(u);
                 }
             } catch (SQLException e ) {
             }
    }
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<Entrenador> arrayEntrenador){
      
             SqlLiteEntrenador r = new SqlLiteEntrenador();
              try{
                SqlLiteEntrenador.get_EntrenadorSistema(arrayEntrenador,r);
            }catch(SQLException e){}
      }
            
}