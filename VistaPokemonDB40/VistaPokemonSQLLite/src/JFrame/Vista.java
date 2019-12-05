/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import Entrenador1.GestionContenido;
import Entrenador1.Entrenador;
import Entrenador1.SqlLiteEntrenador;
import EquipoPokemon.EquipoPokemon;
import EquipoPokemon.SqlLiteEquipo;
import Pokemon.Pokemon;
import Pokemon.SqlLitePokemon;
import Region.Region;
import Region.SqlLiteRegion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Infante96
 */
public final class Vista extends javax.swing.JFrame {

        protected ArrayList<Entrenador> arrayEntrenador;
        protected ArrayList<EquipoPokemon> arrayEquipo;
        protected ArrayList<Pokemon> arrayPokemon;
        protected ArrayList<Region> arrayRegion;
        protected  DefaultTableModel modelo;
        
    /**
     * Creates new form Vista
     */
    public Vista(){
        
        initComponents();
        arrayEntrenador = new ArrayList();
        arrayEquipo = new ArrayList();
        arrayPokemon = new ArrayList();
        arrayRegion = new ArrayList();
        PonerCamposFalseRegion();
        PonerCamposFalsePokemon();
        PonerCamposFalseEntrenador();
        PonerCamposFalseEquipo();
 
        SqlLiteRegion.recogerDatos(arrayRegion);
        SqlLiteEquipo.recogerDatos(arrayEquipo);        
        SqlLiteEntrenador.recogerDatos(arrayEntrenador);
        SqlLitePokemon.recogerDatos(arrayPokemon);
        
        MostrarListaRegion(arrayRegion); 
        MostrarListaEquipo(arrayEquipo); 
        MostrarListaEntrenador(arrayEntrenador);
        MostrarListaPokemon(arrayPokemon);
        bloquearComboBox1();
        bloquearComboBox2();
        bloquearComboBox3();
        ponerSaveDeleteFalse();
        ponerSaveDeleteFalse1();
        ponerSaveDeleteFalse2();
        ponerSaveDeleteFalse3();
    
    }
    public void VaciarComboBox1 (){
    
        jComboBox1.removeAllItems();
    
    }
    public void VaciarComboBox2 (){
       jComboBox2.removeAllItems();
    }
    public void VaciarComboBox3 (){
       jComboBox3.removeAllItems();
    }
    public void ActualizarComboBox1 (){
    
        for(int i = 0;i < arrayRegion.size();i++)
            jComboBox1.addItem(arrayRegion.get(i).getNombre());
    
    }
    public void ActualizarComboBox2 (){
        for(int i = 0;i < arrayEquipo.size();i++)
            jComboBox2.addItem(arrayEquipo.get(i).getNombre_Equipo());
    
    }
    public void ActualizarComboBox3 (){
        for(int i = 0;i < arrayEntrenador.size();i++)
            jComboBox3.addItem(arrayEntrenador.get(i).getNombre());

    }
    public void EntrenadorLeerXML() throws SAXException, IOException{
    
        XMLReader  pxml = XMLReaderFactory.createXMLReader();
	GestionContenido eC;
        eC = new GestionContenido();
        eC.setArrayEntrenador(arrayEntrenador);
	pxml.setContentHandler(eC);
 	InputSource fileXML = new InputSource("Entrenador.xml");	    
        pxml.parse(fileXML);

    }
    void MostrarListaPokemon(ArrayList<Pokemon> p){
        
        String matriz[][] = new String [p.size()][6];
        for(int i = 0; i < p.size();i++){
            matriz[i][0] = p.get(i).getNombre();
            matriz[i][1] = p.get(i).getTipo();
            matriz[i][2] = p.get(i).getAtaque();
            matriz[i][3] = Integer.toString(p.get(i).getHurt());
            matriz[i][4] = Double.toString(p.get(i).getPeso());
            matriz[i][5] = p.get(i).getEntrenador();
            
        }
        
        jTable4.setModel(new javax.swing.table.DefaultTableModel(      
                matriz,
                new String [] {
                    "Nombre","Tipo","Ataque","Hurt","Peso","Entrenador"
                }
        )
        );   
    }
    void MostrarListaEquipo(ArrayList<EquipoPokemon> p){
        
        String matriz[][] = new String [p.size()][5];
        for(int i = 0; i < p.size();i++){
            matriz[i][0] = p.get(i).getNombre_Equipo();
            matriz[i][1] = Integer.toString(p.get(i).getMiembrosEquipo());
            matriz[i][2] = p.get(i).getColor_Equipo();
            matriz[i][3] = p.get(i).getFechaCreacion();
            matriz[i][4] = p.get(i).getRegion();
        }
        
        jTable2.setModel(new javax.swing.table.DefaultTableModel(      
                matriz,
                new String [] {
                     "Nombre","Miembros","Color","Fecha","Region"
                }
        )
        );   
    }
    void MostrarListaEntrenador(ArrayList<Entrenador> p){
         

        String matriz[][] = new String [p.size()][5];
        for(int i = 0; i < p.size();i++){
            matriz[i][0] = p.get(i).getNombre();
            matriz[i][1] = Integer.toString(p.get(i).getEdad());
            matriz[i][2] = p.get(i).getCiudad();
            matriz[i][3] = Integer.toString(p.get(i).getPokemon_Capturados());
            matriz[i][4] = p.get(i).getEquipo();
        }
        
        jTable3.setModel(new javax.swing.table.DefaultTableModel(      
                matriz,
                new String [] {
                    "Nombre","Edad","Ciudad","Pokemon cap","Equipo"
                }
        )
        );   
    }
    void MostrarListaRegion(ArrayList<Region> p){
        
        String matriz[][] = new String [p.size()][5];
        for(int i = 0; i < p.size();i++){
            matriz[i][0] = p.get(i).getNombre();
            matriz[i][1] = Integer.toString(p.get(i).getPokemon_Registrados_Total());
            matriz[i][2] = p.get(i).getPiedras_Region();
            matriz[i][3] = p.get(i).getGimnasio_Liga();
         
        }
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(      
                matriz,
                new String [] {
                    "Nombre","Total","Piedras","Gimnasio"
                }
        )
        );   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textField1 = new java.awt.TextField();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        jButton21 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        textField5 = new java.awt.TextField();
        textField8 = new java.awt.TextField();
        textField6 = new java.awt.TextField();
        textField7 = new java.awt.TextField();
        jPanel3 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        textField9 = new java.awt.TextField();
        textField10 = new java.awt.TextField();
        textField11 = new java.awt.TextField();
        textField12 = new java.awt.TextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        textField13 = new java.awt.TextField();
        textField17 = new java.awt.TextField();
        textField14 = new java.awt.TextField();
        textField15 = new java.awt.TextField();
        textField16 = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre : ");

        jLabel2.setText("Total de Pokemon :");

        jLabel3.setText("Piedras :");

        jLabel4.setText("Gimnasio : ");

        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Total de Pokemon", "Piedras", "Gimansio"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });

        textField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField3ActionPerformed(evt);
            }
        });

        textField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField4ActionPerformed(evt);
            }
        });

        jButton21.setText("Exit");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton21)))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton21))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(98, 98, 98))))
        );

        jTabbedPane1.addTab("Region", jPanel1);

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Update");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Save");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Cancel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre : ");

        jLabel6.setText("Miembros : ");

        jLabel7.setText("Color : ");

        jLabel8.setText("Fecha Creacion");

        jTable2 = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Miembros", "Color", "Fecha Creacion", "Region "
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(68, 68, 68)
                                        .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(26, 26, 26)
                                        .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(jButton9)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8)
                                    .addComponent(jButton7))))
                        .addComponent(jButton10)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(97, 97, 97))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton6)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7))
                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("Equipo", jPanel2);

        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        jLabel9.setText("Nombre :");

        jLabel10.setText("Edad :");

        jLabel11.setText("Ciudad :");

        jLabel12.setText("Pokemon cap :");

        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Save");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Cancel");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTable3 = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "Ciudad", "Pokemon Cap", "Equipo"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        textField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField9ActionPerformed(evt);
            }
        });

        textField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField10ActionPerformed(evt);
            }
        });

        textField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField11ActionPerformed(evt);
            }
        });

        textField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addGap(48, 48, 48)
                        .addComponent(jButton15)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11)
                            .addComponent(jButton12)
                            .addComponent(jButton13))
                        .addGap(46, 46, 46))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton11)
                        .addGap(59, 59, 59)
                        .addComponent(jButton12)
                        .addGap(59, 59, 59)
                        .addComponent(jButton13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(textField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(textField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jButton14)
                        .addComponent(jButton15))
                    .addComponent(textField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Entrenador", jPanel3);

        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
        });

        jLabel13.setText("Nombre");

        jLabel14.setText("Tipo ");

        jLabel15.setText("Hurt : ");

        jLabel16.setText("Peso");

        jLabel17.setText("Ataque");

        jButton16.setText("Add");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Eliminar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("Save");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("Cancel");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jTable4 = new javax.swing.JTable(){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo", "Ataque", "Hurt", "Peso", "Entrenador"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19)
                                .addGap(41, 41, 41)
                                .addComponent(jButton20))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(247, 247, 247)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton17)
                                            .addComponent(jButton18)
                                            .addComponent(jButton16))))
                                .addGap(0, 31, Short.MAX_VALUE)))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField15, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textField14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(48, 48, 48)
                                    .addComponent(textField13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton16)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(textField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(textField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jButton19)
                        .addComponent(jButton20))
                    .addComponent(textField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Pokemon", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try{
            int i = jTable2.getSelectedRow();
            
            boolean existe = false;
            existe = ComprobarEquipoEntrenador(arrayEquipo.get(i).getNombre_Equipo());
            
            if(existe == false){
                PonerCamposEquipoVacio();
                SqlLiteEquipo.deleteEquipo(arrayEquipo.get(i));
                arrayEquipo.remove(arrayEquipo.get(i));
                
                modelo = (DefaultTableModel)this.jTable2.getModel();
                modelo.removeRow(i);
                PonerCamposTrueEquipo();
                jComboBox2.removeItemAt(i);
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jButton8ActionPerformed
        private boolean ComprobarEquipoEntrenador(String n){
    
        boolean valido = false;
    
        for(int i = 0;i < arrayEntrenador.size();i++){
            
            if(n.equals(this.arrayEntrenador.get(i).getEquipo())){
                
                valido = true;
            }
            
        }
        return valido;
    }
    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField2ActionPerformed

    private void textField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField3ActionPerformed

    private void textField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField4ActionPerformed

    private void textField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField9ActionPerformed

    private void textField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField10ActionPerformed

    private void textField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField11ActionPerformed

    private void textField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        VaciarComboBox3();
        PonerCamposPokemonVacio();
        PonerCamposTruePokemon();
        jButton17.setEnabled(false);
        jButton18.setEnabled(false);
        desbloquearComboBox3();
        ActualizarComboBox3();
        ponerSaveDeleteTrue3();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        PonerCamposRegionVacios();
        PonerCamposTrueRegion();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        ponerSaveDeleteTrue();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PonerCamposTrueRegion();
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);
        ponerSaveDeleteTrue();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        VaciarComboBox2();
        PonerCamposEntrenadorVacio();
        PonerCamposTrueEntrenador();
        jButton13.setEnabled(false);
        jButton12.setEnabled(false);
        desbloquearComboBox2();
        ActualizarComboBox2();
        ponerSaveDeleteTrue2();
 
    }//GEN-LAST:event_jButton11ActionPerformed
    private boolean ComprobarEntrenadorPokemon(String n){
    
        boolean valido = false;
    
        for(int i = 0;i < arrayPokemon.size();i++){
            
            if(n.equals(this.arrayPokemon.get(i).getEntrenador())){
                
                valido = true;
            }
            
        }
        return valido;
    }   
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try{
            int i = jTable3.getSelectedRow();
            boolean existe = false;
            existe = ComprobarEntrenadorPokemon(arrayEntrenador.get(i).getNombre());
            if(existe == false){
                
                PonerCamposEntrenadorVacio();
                SqlLiteEntrenador.deleteEntrenador(arrayEntrenador.get(i));
                arrayEntrenador.remove(arrayEntrenador.get(i));

                modelo = (DefaultTableModel)this.jTable3.getModel();
                modelo.removeRow(i);
                PonerCamposTrueEntrenador();
                jComboBox3.removeItemAt(i);
            }
        }catch(Exception e){}
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
           VaciarComboBox2();
        PonerCamposTrueEntrenador();
        jButton11.setEnabled(false);
        jButton13.setEnabled(false);
        desbloquearComboBox2();
        ActualizarComboBox2();
        ponerSaveDeleteTrue2();
        
    }//GEN-LAST:event_jButton12ActionPerformed
    private boolean comprobarRegionesEquipos(String n){
    
        boolean valido = false;
    
        for(int i = 0;i < arrayEquipo.size();i++){
            
            if(n.equals(this.arrayEquipo.get(i).getRegion())){
                
                valido = true;
            }
            
        }
        return valido;
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            int i = jTable1.getSelectedRow();

            boolean valido = false;
            valido = comprobarRegionesEquipos(arrayRegion.get(i).getNombre());
            if(valido == false){
             //   RegionControler.NuevoFicheroRegionPokemon(arrayRegion);
                PonerCamposRegionVacios();
                
                SqlLiteRegion.deleteRegion(arrayRegion.get(i));
                arrayRegion.remove(arrayRegion.get(i));
                modelo = (DefaultTableModel)this.jTable1.getModel();
                modelo.removeRow(i);
                PonerCamposRegionVacios();
                jComboBox1.removeItemAt(i);
                PonerCamposFalseRegion();
            }
        }catch(Exception e){}
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        jButton16.setEnabled(true);
        jButton17.setEnabled(true);
        jButton18.setEnabled(true);
        PonerCamposPokemonVacio();
        PonerCamposFalsePokemon();
        bloquearComboBox3();
        VaciarComboBox3();
        ponerSaveDeleteFalse3();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton1.setBackground(null);
        jButton2.setBackground(null);
        jButton3.setBackground(null);
        PonerCamposRegionVacios();
        PonerCamposFalseRegion();
        ponerSaveDeleteFalse();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        PonerCamposRegionVacios();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        textField1.setText(arrayRegion.get(i).getNombre());
        textField2.setText(String.valueOf(arrayRegion.get(i).getPokemon_Registrados_Total()));
        textField3.setText(arrayRegion.get(i).getPiedras_Region());
        textField4.setText(arrayRegion.get(i).getGimnasio_Liga());
            
    }//GEN-LAST:event_jTable1MouseClicked
    private boolean ComprobarRegionNombre(String n){
       
        boolean existe = false;
        
        for(int i =0; i < this.arrayRegion.size();i++) { 
           
            if(n.equals(this.arrayRegion.get(i).getNombre())){
                existe = true;
            }
        }
        
       return existe; 
    
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         int i = jTable1.getSelectedRow();
          SqlLiteRegion rs = new SqlLiteRegion();
         boolean existe = false;
        
        existe = ComprobarRegionNombre(textField1.getText());
        
        if(jButton1.isEnabled() == true){
            
            if(existe == false){
                 Region r = new Region();
                if(textField1.getText().equals("")
                   || textField2.getText().equals("")
                   || textField3.getText().equals("")
                   || textField4.getText().equals("")){ 
    
                }else{
                        
                        r.setNombre(textField1.getText());
                        try{
                            r.setPokemon_Registrados_Total(Integer.parseInt(textField2.getText()));
                        }catch(NumberFormatException e){}
                        
                        r.setPiedras_Region(textField3.getText());
                        r.setGimnasio_Liga(textField4.getText());
                        r.setId_Region(arrayRegion.size());
                       arrayRegion.add(r);
                      
                       int id_Region = 0;
                     try {
                         id_Region = SqlLiteRegion.AddConsultaRegion(r.getNombre(),r.getPiedras_Region(),r.getPokemon_Registrados_Total(),r.getGimnasio_Liga(),rs);
                         r.setId_Region(id_Region);
                         // jComboBox1.addItem(r.getNombre());
                     } catch (SQLException ex) {
                         Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                     }
                }
            }
        }else{
            
             try { 
                 SqlLiteRegion.deleteRegion(arrayRegion.get(i));
             } catch (SQLException ex) {
                 Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
             }
           arrayRegion.get(i).setNombre(textField1.getText());
           
           try{
                arrayRegion.get(i).setPokemon_Registrados_Total(Integer.parseInt(textField2.getText()));
           }catch(NumberFormatException e){}
            arrayRegion.get(i).setPiedras_Region(textField3.getText());
           arrayRegion.get(i).setGimnasio_Liga(textField4.getText());
             try {
                 int id = 0;
                   
                
                   id = SqlLiteRegion.AddConsultaRegion(arrayRegion.get(i).getNombre(),arrayRegion.get(i).getPiedras_Region(),arrayRegion.get(i).getPokemon_Registrados_Total(),arrayRegion.get(i).getGimnasio_Liga(),rs);
                   arrayRegion.get(i).setId_Region(id);
                    
                   // jComboBox1.insertItemAt(arrayRegion.get(i).getNombre(),i);
                 //jComboBox1.removeItemAt(i+1);
               
             } catch (SQLException ex) {
                 Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
             }

        }
         MostrarListaRegion(arrayRegion);
         PonerCamposRegionVacios();
         PonerCamposFalseRegion();
         jButton1.setEnabled(true);
         jButton2.setEnabled(true);
         jButton3.setEnabled(true);
         ponerSaveDeleteFalse();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        VaciarComboBox1();
        PonerCamposEquipoVacio();
        PonerCamposTrueEquipo();
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        desbloquearComboBox1();
        ActualizarComboBox1();
        ponerSaveDeleteTrue1();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
           VaciarComboBox1();
         PonerCamposTrueEquipo();
        jButton6.setEnabled(false);
        jButton8.setEnabled(false);
        desbloquearComboBox1();
        ActualizarComboBox1();
        ponerSaveDeleteTrue1();
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        PonerCamposEquipoVacio();
        PonerCamposFalseEquipo();
        jButton1.setBackground(null);
        jButton2.setBackground(null);
        jButton3.setBackground(null);
        bloquearComboBox1();
        VaciarComboBox1();
        ponerSaveDeleteFalse1();
    }//GEN-LAST:event_jButton10ActionPerformed
     private boolean ComprobarEquipoNombre(String n){
       
        boolean existe = false;
        
        for(int i =0; i < this.arrayEquipo.size();i++) { 
           
            if(n.equals(this.arrayEquipo.get(i).getNombre_Equipo())){
                existe = true;
            }
        }
        
       return existe; 
    
    }
     private int DevolverPosicionArrayRegion(String nombre){
      int n = 0;
        
        for(int i =0; i < this.arrayEquipo.size();i++) { 
           
            if(nombre.equals(this.arrayEquipo.get(i).getNombre_Equipo())){
                n = i;
            }
        }
        
       return n; 
     
     
     }
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        int j = jComboBox1.getSelectedIndex();
        boolean existe = false;
        int id =0;
        SqlLiteEquipo rs = new SqlLiteEquipo();
        existe = ComprobarEquipoNombre(textField5.getText());

        if(jButton6.isEnabled() == true){
            
            if(existe == false){
                 EquipoPokemon r = new EquipoPokemon();
                 if(textField5.getText().equals("")
                   || textField6.getText().equals("")
                   || textField7.getText().equals("")
                   || textField8.getText().equals("")){ 
    
                }else{
                    r.setNombre_Equipo(textField5.getText());
                    try{
                        r.setMiembrosEquipo(Integer.parseInt(textField6.getText()));
                    }catch(NumberFormatException e){}
                    
                    r.setColor_Equipo(textField7.getText());
                    r.setFechaCreacion(textField8.getText());
                    r.setRegion(jComboBox1.getItemAt(j));
                   
                     try {
                         id = SqlLiteEquipo.AddConsultaEquipo(r.getRegion(),r.getNombre_Equipo(),r.getMiembrosEquipo(),r.getColor_Equipo(),r.getFechaCreacion());
                     } catch (SQLException ex) {
                         Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    r.setId_Equipo(id);
                    arrayEquipo.add(r);
                   //jComboBox2.addItem(r.getNombre_Equipo());
                }
            }
        }else{
              try { 
                 SqlLiteEquipo.deleteEquipo(arrayEquipo.get(i));
             } catch (SQLException ex) {
                 Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
             }
           try{
            arrayEquipo.get(i).setNombre_Equipo(textField5.getText());
            arrayEquipo.get(i).setMiembrosEquipo(Integer.parseInt(textField6.getText()));
            arrayEquipo.get(i).setColor_Equipo(textField7.getText());
            arrayEquipo.get(i).setFechaCreacion(textField8.getText());
            arrayEquipo.get(i).setRegion(jComboBox1.getItemAt(j));
         
            id = SqlLiteEquipo.AddConsultaEquipo(arrayEquipo.get(i).getNombre_Equipo(),arrayEquipo.get(i).getNombre_Equipo(),arrayEquipo.get(i).getMiembrosEquipo(),arrayEquipo.get(i).getColor_Equipo(),arrayEquipo.get(i).getFechaCreacion());
            arrayEquipo.get(i).setId_Equipo(id);
          // jComboBox2.insertItemAt(arrayEquipo.get(i).getNombre_Equipo(),i);
           //jComboBox2.removeItemAt(i+1);
           }catch(Exception e){}

        }
         MostrarListaEquipo(arrayEquipo);
         PonerCamposEquipoVacio();
         PonerCamposFalseEquipo();
         jButton6.setEnabled(true);
         jButton7.setEnabled(true);
         jButton8.setEnabled(true);
         bloquearComboBox1();
         VaciarComboBox1();
         ponerSaveDeleteFalse1();
    }//GEN-LAST:event_jButton9ActionPerformed
    public void anadirComboBox1(EquipoPokemon p){
    
        jComboBox1.addItem(p.getRegion());
    }
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         int i = jTable2.getSelectedRow();
        //System.out.println("Entra "+jButton6.isEnabled() + jButton7.isEnabled() + jButton8.isEnabled());
        if(jButton6.isEnabled() == true && jButton7.isEnabled() == true && jButton8.isEnabled() == true){
                   try{
                        VaciarComboBox1();
                        textField5.setText(arrayEquipo.get(i).getNombre_Equipo());
                        textField6.setText(String.valueOf(arrayEquipo.get(i).getMiembrosEquipo()));
                        textField7.setText(arrayEquipo.get(i).getColor_Equipo());
                        textField8.setText(arrayEquipo.get(i).getFechaCreacion());
                        anadirComboBox1(arrayEquipo.get(i));
                    }catch(Exception e){}
        }else{
            textField5.setText(arrayEquipo.get(i).getNombre_Equipo());
            textField6.setText(String.valueOf(arrayEquipo.get(i).getMiembrosEquipo()));
            textField7.setText(arrayEquipo.get(i).getColor_Equipo());
            textField8.setText(arrayEquipo.get(i).getFechaCreacion()); 
        }
    }//GEN-LAST:event_jTable2MouseClicked
    public void anadirComboBox2(Entrenador p){
    
        jComboBox2.addItem(p.getEquipo());
    }
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
        int i = jTable3.getSelectedRow();
        if(jButton11.isEnabled() == true && jButton12.isEnabled() == true && jButton13.isEnabled() == true){
            try{
                  VaciarComboBox2();
                textField9.setText(arrayEntrenador.get(i).getNombre());
                textField10.setText(String.valueOf(arrayEntrenador.get(i).getEdad()));
                textField11.setText(arrayEntrenador.get(i).getCiudad());
                textField12.setText(String.valueOf(arrayEntrenador.get(i).getPokemon_Capturados()));
                anadirComboBox2(arrayEntrenador.get(i));
            }catch(Exception e){} 
        }else{
            try{
                textField9.setText(arrayEntrenador.get(i).getNombre());
                textField10.setText(String.valueOf(arrayEntrenador.get(i).getEdad()));
                textField11.setText(arrayEntrenador.get(i).getCiudad());
                textField12.setText(String.valueOf(arrayEntrenador.get(i).getPokemon_Capturados()));
            }catch(Exception e){}
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        jButton12.setEnabled(true);
        jButton13.setEnabled(true);
        jButton11.setEnabled(true);
        PonerCamposEntrenadorVacio();
        PonerCamposFalseEntrenador();
        bloquearComboBox2();
        VaciarComboBox2();
        ponerSaveDeleteFalse2();
        
    }//GEN-LAST:event_jButton15ActionPerformed
    private boolean ComprobarEntrenador(String n){
       
        boolean existe = false;
        
        for(int i =0; i < this.arrayEntrenador.size();i++) { 
           
            if(n.equals(this.arrayEntrenador.get(i).getNombre())){
                existe = true;
            }
        }
        
       return existe; 
    
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
           int id =0;
        SqlLiteEntrenador rs = new SqlLiteEntrenador();
        
         int i = jTable3.getSelectedRow();
         int j = jComboBox2.getSelectedIndex();
         boolean existe = false;
        //ESTE ERA EL FALLO AHORA DEBERIA DE FUNCIONAR
        existe = ComprobarEntrenador(textField9.getText());

        if(jButton11.isEnabled() == true){
            
            if(existe == false){
                 Entrenador r = new Entrenador();
                 if(textField9.getText().equals("") 
                   || textField10.getText().equals("")
                   || textField12.getText().equals("")
                   || textField11.getText().equals("")){ 
    
                }else{
                    r.setNombre(textField9.getText());
                    try{
                        r.setEdad(Integer.parseInt(textField10.getText()));
                     }catch(NumberFormatException e){}
                    r.setCiudad(textField11.getText());
                    try{
                        r.setPokemon_Capturados(Integer.parseInt(textField12.getText()));
                        r.setEquipo(jComboBox2.getItemAt(j));
                     }catch(NumberFormatException e){}
                   
                     try {
                        id = SqlLiteEntrenador.AddConsultaEntrenador(r.getNombre(),r.getEdad(),r.getPokemon_Capturados(),r.getCiudad(),r.getEquipo(),rs);
                     } catch (SQLException ex) {
                         Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    r.setId_Entrandor(id);
                   arrayEntrenador.add(r);
                 //  jComboBox3.addItem(r.getNombre());
                 }
            }
        }else{
            try { 
                 SqlLiteEntrenador.deleteEntrenador(arrayEntrenador.get(i));
             } catch (SQLException ex) {
                 Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
             }
           try{
                arrayEntrenador.get(i).setNombre(textField9.getText());
                arrayEntrenador.get(i).setEdad(Integer.parseInt(textField10.getText()));
                arrayEntrenador.get(i).setCiudad(textField11.getText());
                arrayEntrenador.get(i).setPokemon_Capturados(Integer.parseInt(textField12.getText()));
                
                arrayEntrenador.get(i).setEquipo(jComboBox2.getItemAt(j));
                id = SqlLiteEntrenador.AddConsultaEntrenador(arrayEntrenador.get(i).getNombre(),arrayEntrenador.get(i).getEdad(),arrayEntrenador.get(i).getPokemon_Capturados(),arrayEntrenador.get(i).getCiudad(),arrayEntrenador.get(i).getEquipo(),rs);
                arrayEquipo.get(i).setId_Equipo(id);
             //   jComboBox3.insertItemAt(arrayEntrenador.get(i).getNombre(),i);
               // jComboBox3.removeItemAt(i+1);
             }catch(Exception e){}

        }
         bloquearComboBox2();
         MostrarListaEntrenador(arrayEntrenador);
         PonerCamposEntrenadorVacio();
         PonerCamposFalseEntrenador();
         jButton11.setEnabled(true);
         jButton12.setEnabled(true);
         jButton13.setEnabled(true);
         VaciarComboBox2();
         ponerSaveDeleteFalse2();
    }//GEN-LAST:event_jButton14ActionPerformed
    public void anadirComboBox3(Pokemon p){
    
        jComboBox3.addItem(p.getEntrenador());
    }
    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        
        int i = jTable4.getSelectedRow();
         if(jButton16.isEnabled() == true && jButton17.isEnabled() == true && jButton18.isEnabled() == true){
            VaciarComboBox3();
           
            textField13.setText(arrayPokemon.get(i).getNombre());
            textField14.setText(arrayPokemon.get(i).getTipo());
            textField15.setText(arrayPokemon.get(i).getAtaque());
            textField16.setText(String.valueOf(arrayPokemon.get(i).getHurt()));
            textField17.setText(String.valueOf(arrayPokemon.get(i).getPeso()));
            anadirComboBox3(arrayPokemon.get(i));
         }else{
         
            textField13.setText(arrayPokemon.get(i).getNombre());
            textField14.setText(arrayPokemon.get(i).getTipo());
            textField15.setText(arrayPokemon.get(i).getAtaque());
            textField16.setText(String.valueOf(arrayPokemon.get(i).getHurt()));
            textField17.setText(String.valueOf(arrayPokemon.get(i).getPeso()));
         
         }
    }//GEN-LAST:event_jTable4MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
           VaciarComboBox3();
        PonerCamposTruePokemon();
        jButton16.setEnabled(false);
        jButton18.setEnabled(false);
        desbloquearComboBox3();
        ActualizarComboBox3();
        ponerSaveDeleteTrue3();
    }//GEN-LAST:event_jButton17ActionPerformed
    private boolean ComprobarPokemon(String n){
       
        boolean existe = false;
        
        for(int i =0; i < this.arrayPokemon.size();i++) { 
           
            if(n.equals(this.arrayPokemon.get(i).getNombre())){
                existe = true;
            }
        }
        
       return existe; 
    
    }
    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

            try{

            int i = jTable4.getSelectedRow();
            boolean existe = false;

            existe = ComprobarPokemon(arrayPokemon.get(i).getNombre());

            if(existe == true){
                
                PonerCamposEntrenadorVacio();
                SqlLitePokemon.deletePokemon(arrayPokemon.get(i));
                System.out.println("Sale");
                arrayPokemon.remove(arrayPokemon.get(i));

                modelo = (DefaultTableModel)this.jTable4.getModel();
                modelo.removeRow(i);
                PonerCamposTruePokemon();
                PonerCamposPokemonVacio();
            }
        }catch(Exception e){}
     
    }//GEN-LAST:event_jButton18ActionPerformed
    private boolean ComprobarPokemonNombre1(String n){
       
        boolean existe = false;
        
        for(int i =0; i < arrayPokemon.size();i++) { 
           
            if(n.equals(arrayPokemon.get(i).getNombre())){
                existe = true;
            }
        }
        
       return existe; 
    
    }
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int id =0;
        SqlLitePokemon rs = new SqlLitePokemon();
        int i = jTable4.getSelectedRow();
        int j = jComboBox3.getSelectedIndex();
        
         boolean existe = false;
         
        existe = ComprobarPokemonNombre1(textField13.getText());

        if(jButton16.isEnabled() == true){
            
            if(existe == false){
                 Pokemon r = new Pokemon();
                 if(textField13.getText().equals("") 
                   || textField14.getText().equals("")
                   || textField15.getText().equals("")
                   || textField16.getText().equals("")
                   || textField17.getText().equals("")){ 
    
                }else{
                    r.setNombre(textField13.getText());
                    r.setTipo(textField14.getText());
                    r.setAtaque(textField15.getText());
                    r.setHurt(Integer.parseInt(textField16.getText()));
                    r.setPeso(Double.parseDouble(textField17.getText()));
                    r.setEntrenador(jComboBox3.getItemAt(j));
                    try {
                    id = SqlLitePokemon.AddConsultaPokemon(r.getNombre(),r.getEntrenador(),r.getTipo(),r.getAtaque(),r.getHurt(),r.getPeso());
                     } catch (SQLException ex) {
                         Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    r.setId_registro(id);
                    arrayPokemon.add(r);
                }
            }
        }else{
            try { 
                 SqlLitePokemon.deletePokemon(arrayPokemon.get(i));
             } catch (SQLException ex) {
             }
           try{
                arrayPokemon.get(i).setNombre(textField13.getText());
                arrayPokemon.get(i).setTipo(textField14.getText());
                arrayPokemon.get(i).setAtaque(textField15.getText());
                arrayPokemon.get(i).setHurt(Integer.parseInt(textField16.getText()));
                arrayPokemon.get(i).setPeso(Double.parseDouble(textField17.getText()));
                arrayPokemon.get(i).setEntrenador(jComboBox3.getItemAt(j));
                id = SqlLitePokemon.AddConsultaPokemon(arrayPokemon.get(i).getNombre(),arrayPokemon.get(i).getEntrenador(),arrayPokemon.get(i).getTipo(),arrayPokemon.get(i).getAtaque(),arrayPokemon.get(i).getHurt(),arrayPokemon.get(i).getPeso());
                arrayEquipo.get(i).setId_Equipo(id);
           }catch(Exception e){}
        }
         MostrarListaPokemon(arrayPokemon);
         PonerCamposPokemonVacio();
         PonerCamposFalsePokemon();
         jButton16.setEnabled(true);
         jButton17.setEnabled(true);
         jButton18.setEnabled(true);
         bloquearComboBox3();
         VaciarComboBox3();
         ponerSaveDeleteFalse3();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
            try {
                // TODO add your handling code here:
                SqlLiteRegion.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // TODO add your handling code here:
                SqlLiteEquipo.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // TODO add your handling code here:
                SqlLiteEntrenador.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                // TODO add your handling code here:
                SqlLitePokemon.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.exit(0);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
        //int i = jComboBox1.getSelectedIndex();
        try{
            int pos = jTable2.getSelectedRow();
            arrayEquipo.get(pos).setRegion(arrayRegion.get(jComboBox1.getSelectedIndex()).getNombre());
            MostrarListaEquipo(arrayEquipo);
        }catch(Exception e){}
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        try{
            int pos = jTable3.getSelectedRow();
            arrayEntrenador.get(pos).setEquipo(arrayEquipo.get(jComboBox2.getSelectedIndex()).getNombre_Equipo());
            MostrarListaEntrenador(arrayEntrenador);
        }catch(Exception e){}
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
        // TODO add your handling code here:
         try{
            int pos = jTable4.getSelectedRow();
            arrayPokemon.get(pos).setEntrenador(arrayEntrenador.get(jComboBox3.getSelectedIndex()).getNombre());
            MostrarListaPokemon(arrayPokemon);
        }catch(Exception e){}
    }//GEN-LAST:event_jComboBox3MouseClicked
    
    public void bloquearComboBox1(){
        jComboBox1.setEnabled(false);   
    }
    public void bloquearComboBox2(){
        jComboBox2.setEnabled(false);   
    }
    public void bloquearComboBox3(){
        jComboBox3.setEnabled(false);   
    }
    public void desbloquearComboBox1(){
        jComboBox1.setEnabled(true);   
    }
    public void desbloquearComboBox2(){
        jComboBox2.setEnabled(true);   
    }
    public void desbloquearComboBox3(){
        jComboBox3.setEnabled(true);   
    }
    public void PonerCamposPokemonVacio(){
    
        textField13.setText("");
        textField17.setText("");
        textField14.setText("");
        textField15.setText("");
        textField16.setText("");
  }
      public void PonerCamposEntrenadorVacio(){
    
        textField10.setText("");
        textField11.setText("");
        textField12.setText("");
        textField9.setText("");
  }
    public void PonerCamposRegionVacios(){
    
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
  }
    public void PonerCamposEquipoVacio(){
    
        textField5.setText("");
        textField8.setText("");
        textField6.setText("");
        textField7.setText("");
  }
    public void ponerSaveDeleteFalse(){
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
    }
    public void ponerSaveDeleteTrue(){
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
    }
    
    public void ponerSaveDeleteFalse1(){
        jButton9.setEnabled(false);
        jButton10.setEnabled(false);
    }
    public void ponerSaveDeleteTrue1(){
        jButton9.setEnabled(true);
        jButton10.setEnabled(true);
    }
    public void ponerSaveDeleteFalse2(){
        jButton14.setEnabled(false);
        jButton15.setEnabled(false);
    }
    public void ponerSaveDeleteTrue2(){
        jButton14.setEnabled(true);
        jButton15.setEnabled(true);
    }
    public void ponerSaveDeleteFalse3(){
        jButton19.setEnabled(false);
        jButton20.setEnabled(false);
    }
    public void ponerSaveDeleteTrue3(){
        jButton19.setEnabled(true);
        jButton20.setEnabled(true);
    }
    //Poner campos a true 
    public void PonerCamposTruePokemon(){
    
        textField13.setEnabled(true);
        textField14.setEnabled(true);
        textField15.setEnabled(true);
        textField16.setEnabled(true);
        textField17.setEnabled(true);
    
    }
     public void PonerCamposTrueEntrenador(){
        
        textField9.setEnabled(true);
        textField10.setEnabled(true);
        textField11.setEnabled(true);
        textField12.setEnabled(true);
    
    }
      public void PonerCamposTrueEquipo(){
    
        textField5.setEnabled(true);
        textField8.setEnabled(true);
        textField6.setEnabled(true);
        textField7.setEnabled(true);
    
    }
       public void PonerCamposTrueRegion(){
    
        textField4.setEnabled(true);
        textField3.setEnabled(true);
        textField2.setEnabled(true);
        textField1.setEnabled(true);
    
    }
       
            //Poner camnpos a fasle 
    public void PonerCamposFalsePokemon(){
    
        textField17.setEnabled(false);
        textField16.setEnabled(false);
        textField15.setEnabled(false);
        textField14.setEnabled(false);
        textField13.setEnabled(false);
    
    }
     public void PonerCamposFalseEntrenador(){
    
        
        textField12.setEnabled(false);
        textField11.setEnabled(false);
        textField10.setEnabled(false);
        textField9.setEnabled(false);
    
    }
      public void PonerCamposFalseEquipo(){
    
        textField7.setEnabled(false);
        textField6.setEnabled(false);
        textField8.setEnabled(false);
        textField5.setEnabled(false);
    
    }
       public void PonerCamposFalseRegion(){
    
        textField4.setEnabled(false);
        textField3.setEnabled(false);
        textField2.setEnabled(false);
        textField1.setEnabled(false);
    
    }
       
    /**
     * @param args the command line arguments
     */
      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private java.awt.TextField textField1;
    private java.awt.TextField textField10;
    private java.awt.TextField textField11;
    private java.awt.TextField textField12;
    private java.awt.TextField textField13;
    private java.awt.TextField textField14;
    private java.awt.TextField textField15;
    private java.awt.TextField textField16;
    private java.awt.TextField textField17;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    private java.awt.TextField textField7;
    private java.awt.TextField textField8;
    private java.awt.TextField textField9;
    // End of variables declaration//GEN-END:variables

}
