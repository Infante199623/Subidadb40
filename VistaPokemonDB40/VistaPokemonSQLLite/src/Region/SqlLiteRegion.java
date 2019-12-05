/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Region;

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
public class SqlLiteRegion {	 
            
    private ArrayList<Region> arrayRegion;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public SqlLiteRegion() {
        
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
    
    public void setArrayRegion(ArrayList<Region> arrayRegion) {
        this.arrayRegion = arrayRegion;
    }
     public ArrayList<Region>  getArrayRegion() {
        return this.arrayRegion;
    }    
    public static int AddConsultaRegion(String nombre,String piedras_region,int total_pokemon,String gimnasio_liga,SqlLiteRegion r)throws SQLException{
        int id = 0;
        
        String query = "INSERT INTO region (nombre,piedras_region,total_pokemon,gimnasio_liga) VALUES (?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) r.getCon().prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setString(2, piedras_region);
        ps.setInt(3, total_pokemon);
        ps.setString(4, gimnasio_liga);

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            id=rs.getInt(1);
        }
        
        return id;

        }
    public static void deleteRegion(Region r) throws SQLException{
            
        String query = "DELETE FROM region WHERE nombre = ?";
        PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
 
    }
    public static void get_PokemonSistema(ArrayList<Region> arrayRegion,SqlLiteRegion r) throws SQLException{
  
    Statement stmt = null;
    int id_region = 0;
    String nombre = null;
    String piedras_Region = null;
    int pokemon_registrados_total  = 0;
    String gimnasio_liga = null;
   
    
    String query = "select * from region";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     Region u = new Region();

                     id_region = rs.getInt("id_region");
                     u.setId_Region(id_region);

                     nombre = rs.getString("nombre");
                     u.setNombre(nombre);

                     piedras_Region = rs.getString("piedras_region");
                     u.setPiedras_Region(piedras_Region);

                     pokemon_registrados_total = rs.getInt("total_pokemon");
                     u.setPokemon_Registrados_Total(pokemon_registrados_total);

                     gimnasio_liga = rs.getString("gimnasio_liga");
                     u.setGimnasio_Liga(gimnasio_liga);

                     arrayRegion.add(u);
                 }
             } catch (SQLException e ) {
             }
    }
        public static void updateRegion(Region r) throws SQLException{
            
           
           String query = "UPDATE region SET nombre = ? ,piedras_region = ? , total_pokemon = ? , gimnasio_liga = ? WHERE nombre = ?";
            try{
                    
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1, r.getNombre());
                ps.setString(2, r.getPiedras_Region());
                ps.setInt(3, r.getPokemon_Registrados_Total());
                ps.setString(4, r.getGimnasio_Liga());
                ps.executeUpdate();
            }catch(SQLException e){System.out.println("Eee"+e);}
    }
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<Region> arrayRegion){
      
             SqlLiteRegion r = new SqlLiteRegion();
              try{
                SqlLiteRegion.get_PokemonSistema(arrayRegion,r);
            }catch(SQLException e){}
      }
            
}