/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pokemon;

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
public class SqlLitePokemon {	 
            
    private ArrayList<Pokemon> arrayPokemon;
    protected String puerto;
    protected static Connection con;
    protected String driver;
    protected String url;
    protected String modo;
    protected String ruta;
    protected String contrasena;
    
    public SqlLitePokemon() {
        
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
    
    public void setArrayPokemon(ArrayList<Pokemon> arrayPokemon) {
        this.arrayPokemon = arrayPokemon;
    }
     public ArrayList<Pokemon>  getArrayRegion() {
        return this.arrayPokemon;
    }    
    public static int AddConsultaPokemon(String nombre,String entrenador,String tipo,String ataque,int hurt,double peso)throws SQLException{
        int id = 0;
        
        String query = "INSERT INTO pokemon (nombre,entrenador,tipo,ataque,peso,hurt) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
        
        ps.setString(1, nombre);
        ps.setString(2, entrenador);
        ps.setString(3, tipo);
        ps.setString(4, ataque);
        ps.setDouble(5, peso);
        ps.setInt(6, hurt);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            id=rs.getInt(1);
        }
        
        return id;

        }
    public static void deletePokemon(Pokemon r) throws SQLException{
        
        try{
            String query = "DELETE FROM pokemon WHERE nombre = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, r.getNombre());
            ps.executeUpdate();
        }catch(SQLException e){}
 
    }
    public static void get_EquipoSistema(ArrayList<Pokemon> arrayPokemon,SqlLitePokemon r) throws SQLException{
  
    Statement stmt = null;
    int id_pokemon = 0;
    String ataque = null;
    String nombre = null;
    String tipo = null;
    String entrenador = null;
    int hurt  = 0;
    double peso = 0.0;
   
    
    String query = "select * from pokemon";
    
        try {
            
            stmt = r.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(query);
                 
                 while (rs.next()) {
                     
                     
                     Pokemon u = new Pokemon();

                     id_pokemon = rs.getInt("id_pokemon");
                     u.setId_registro(id_pokemon);

                     nombre = rs.getString("nombre");
                     u.setNombre(nombre);
                     
                     tipo = rs.getString("tipo");
                     u.setTipo(tipo);
                     
                     entrenador = rs.getString("entrenador");
                     u.setEntrenador(entrenador);
                     
                     ataque = rs.getString("ataque");
                     u.setAtaque(ataque);

                     hurt = rs.getInt("hurt");
                     u.setHurt(hurt);

                     peso = rs.getDouble("peso");
                     u.setPeso(peso);
                
                    arrayPokemon.add(u);
                }
             }catch(SQLException e ) {}
        
    }
    
    public static void cerrarConexion() throws SQLException{  
        con.close();
    }
	public static void recogerDatos(ArrayList<Pokemon> arrayPokemon){
      
             SqlLitePokemon r = new SqlLitePokemon();
            
             try{
                SqlLitePokemon.get_EquipoSistema(arrayPokemon,r);
            }catch(SQLException e){}
      }
            
}