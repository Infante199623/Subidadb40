/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoPokemon;

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
public class SqlLiteEquipo {	 
            
    private ArrayList<EquipoPokemon> arrayEquipo;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public SqlLiteEquipo() {
        
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
    
    public void setArrayEquipo(ArrayList<EquipoPokemon> arrayEquipo) {
        this.arrayEquipo = arrayEquipo;
    }
     public ArrayList<EquipoPokemon>  getArrayRegion() {
        return this.arrayEquipo;
    }    
    public static int AddConsultaEquipo(String region,String nombre,int miembros,String color,String fecha)throws SQLException{
        int id = 0;
        
        String query = "INSERT INTO equipo (region,nombre,color,miembros,fecha) VALUES (?,?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
        
        ps.setString(1, region);
        ps.setString(2, nombre);
        ps.setString(3, color);
        ps.setInt(4, miembros);
        ps.setString(5, fecha);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            id=rs.getInt(1);
        }
        
        return id;

        }
    public static void deleteEquipo(EquipoPokemon r) throws SQLException{
            
        String query = "DELETE FROM equipo WHERE nombre = ?";
        PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, r.getNombre_Equipo());
            ps.executeUpdate();
 
    }
    public static void get_EquipoSistema(ArrayList<EquipoPokemon> arrayEquipo,SqlLiteEquipo r) throws SQLException{
  
    Statement stmt = null;
    int id_equipo = 0;
    String region = null;
    String nombre = null;
    String color = null;
    int miembros  = 0;
    String fecha = null;
   
    
    String query = "select * from equipo";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     EquipoPokemon u = new EquipoPokemon();

                     id_equipo = rs.getInt("id_equipo");
                     u.setId_Equipo(id_equipo);

                     region = rs.getString("region");
                     u.setRegion(region);
                     
                     nombre = rs.getString("nombre");
                     u.setNombre_Equipo(nombre);
                     
                     color = rs.getString("color");
                     u.setColor_Equipo(color);

                     miembros = rs.getInt("miembros");
                     u.setMiembrosEquipo(miembros);

                     fecha = rs.getString("fecha");
                     u.setFechaCreacion(fecha);

                     arrayEquipo.add(u);
                 }
             } catch (SQLException e ) {
             }
    }
      
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<EquipoPokemon> arrayEquipo){
      
             SqlLiteEquipo r = new SqlLiteEquipo();
              try{
                SqlLiteEquipo.get_EquipoSistema(arrayEquipo,r);
            }catch(SQLException e){}
      }
            
}