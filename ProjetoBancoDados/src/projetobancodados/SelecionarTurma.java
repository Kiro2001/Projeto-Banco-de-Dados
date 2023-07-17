/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jplim
 */
public class SelecionarTurma extends javax.swing.JFrame {

    String matricula;
    Connection con;
    public SelecionarTurma() {
        initComponents();
    }
    
     /**
     * Inicia a tela,faz a conexão com o banco, e chama o metodo que carrega
     * a tabela com as turmas do banco
     */
    
    public SelecionarTurma(String Matricula) {
        initComponents();
        matricula=Matricula;
        Dep.add("Todas");
        Discl.add("Todas");
        
                
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps = con.prepareStatement("select * from Departamento");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()==true){
                Dep.add(rs.getString(2));
            }
            
            carregarDisciplinas();
            carregarTabelaTotal();
            
            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * Carrega as opções de disciplinas para filtragem baseado na opção escolhida
     * sobre departamentos
     */
    
    public void carregarDisciplinas(){
        Discl.removeAll();
        Discl.add("Todas");
        try {
            if(Dep.getSelectedItem().equals("Todas")){
                PreparedStatement ps = con.prepareStatement("select * from Disciplina");
                ResultSet rs = ps.executeQuery();
            
                while(rs.next()==true){
                    Discl.add(rs.getString(2));
                }
                carregarTabelaTotal();
            }
            else{
                PreparedStatement ps = con.prepareStatement("select cod from Departamento where nome = ?");
                ps.setString(1,Dep.getSelectedItem());
                ResultSet rs = ps.executeQuery();
                rs.next();
                
                PreparedStatement ps2 = con.prepareStatement("select nome from Disciplina where FKDepartamento_cod = ?");
                ps2.setString(1,rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                
                while(rs2.next()==true){
                    Discl.add(rs2.getString(1));
                }
                carregarTabelaParcial();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SelecionarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     /**
     * Carrega a tabela baseado em nas opções escolhidas de filtragem 
     * em Departamento e Disciplinas
     */
    
    public void carregarTabelaParcial(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"id","Disciplina","Nº da turma"},0){
            @Override
            public boolean isCellEditable(int row, int column){return false;}};
        try {
            if(Discl.getSelectedItem()=="Todas"){
                PreparedStatement ps = con.prepareStatement("select cod from Departamento where nome = ?");
                ps.setString(1,Dep.getSelectedItem());
                ResultSet rs = ps.executeQuery();
                rs.next();
                PreparedStatement ps2 = con.prepareStatement("select * from Disciplina where FKDepartamento_cod = ?");
                ps2.setString(1,rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()==true){
                    PreparedStatement ps3 =con.prepareStatement("select * from Turma where FKcod_disciplina = ?");
                    ps3.setString(1,rs2.getString(1));
                    ResultSet rs3 = ps3.executeQuery();
                    while(rs3.next()==true){
                        Object linha[] = {rs3.getString(1),rs2.getString(2),rs3.getString(2)};
                        modelo.addRow(linha);
                    }
                }
            }
            else{
                PreparedStatement ps =con.prepareStatement("select cod from Disciplina where nome = ?");
                ps.setString(1,Discl.getSelectedItem());
                ResultSet rs = ps.executeQuery();
                rs.next();
                PreparedStatement ps2 =con.prepareStatement("select * from Turma where FKcod_disciplina = ?");
                ps2.setString(1,rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()==true){
                    Object linha[] = {rs2.getString(1),Discl.getSelectedItem(),rs2.getString(2)};
                    modelo.addRow(linha);
            }
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SelecionarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jtabTurma.setModel(modelo);
    
    }
    
     /**
     * Carrega a tabela com todas as turmas
     */
    
    public void carregarTabelaTotal(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"id","Disciplina","Nº da turma"},0){
            @Override
            public boolean isCellEditable(int row, int column){return false;}};
        try {
            PreparedStatement ps =con.prepareStatement("select * from Turma");
            ResultSet rs = ps.executeQuery();
            while(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                ps2.setString(1, rs.getString(9));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                Object linha[] = {rs.getString(1),rs2.getString(1),rs.getString(2)};
                modelo.addRow(linha);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SelecionarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        jtabTurma.setModel(modelo);
     }
     
    /**
     Codigo do construtor que não pode ser removido ou modificado
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Discl = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabTurma = new javax.swing.JTable();
        btConf = new javax.swing.JButton();
        Dep = new java.awt.Choice();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Discl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DisclItemStateChanged(evt);
            }
        });
        getContentPane().add(Discl, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 106, 260, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Escolha de Turma");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 6, -1, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DIsciplina:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 106, -1, -1));

        jtabTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Disciplina", "Número da Turma "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabTurma.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtabTurma);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 414, 211));

        btConf.setText("Confirmar");
        btConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfActionPerformed(evt);
            }
        });
        getContentPane().add(btConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 136, -1, -1));

        Dep.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DepItemStateChanged(evt);
            }
        });
        getContentPane().add(Dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 76, 260, -1));

        jLabel3.setText("Departamento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 76, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Abre a tela que mostra a turma selecionado na tabela 
     */
    
    private void btConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfActionPerformed
        if(jtabTurma.getSelectedRow() != -1){
            String id = jtabTurma.getValueAt(jtabTurma.getSelectedRow(),0).toString();
            new MostrarTurma(id,matricula).setVisible(true);
        } 
    }//GEN-LAST:event_btConfActionPerformed
    
     /**
     * Checa qualquer mudança na filtragem de disciplinas,para checar se carrega
     * a tabela parcialmente ou totalmente
     */
    private void DisclItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DisclItemStateChanged
        if (Discl.getSelectedItem()=="Todas" && Dep.getSelectedItem()=="Todas"){
            carregarTabelaTotal();
        }
        else{
            carregarTabelaParcial();
        }
    }//GEN-LAST:event_DisclItemStateChanged
    
     /**
     * Checa qualquer mudança na filtragem dos departamentos e chama a função
     * para modificar as opções de filtragem de disciplina
     */
    
    private void DepItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DepItemStateChanged
        carregarDisciplinas();
    }//GEN-LAST:event_DepItemStateChanged

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
            java.util.logging.Logger.getLogger(SelecionarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice Dep;
    private java.awt.Choice Discl;
    private javax.swing.JButton btConf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabTurma;
    // End of variables declaration//GEN-END:variables
}
