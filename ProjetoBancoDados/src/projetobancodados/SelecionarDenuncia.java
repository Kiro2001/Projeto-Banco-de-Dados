/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jplim
 */
public class SelecionarDenuncia extends javax.swing.JFrame {

    String id;
    String matricula;
    Connection con;
    ResultSet rs;
    
    public SelecionarDenuncia() {
        initComponents();
    }
    
    /**
     * Inicia a tela,faz a conexão com o banco, e chama o metodo que carrega
     * a tabela com todas denuncias do banco
     */
    
    public SelecionarDenuncia(String Matricula) {
        initComponents();
        matricula=Matricula;
        
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            carregarTabelaTotal();
            
        }catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * metodo que carrega a tabela utlizando dados pegos usando queries sobre as
     * denuncias e coisas associadas a essas denuncias
     */
    
    public void carregarTabelaTotal(){
        boolean propCom=false;
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id da Denuncia","Motivo"},0){
            @Override
            public boolean isCellEditable(int row, int column){return false;}};
        try {
            PreparedStatement ps =con.prepareStatement("select * from Denuncia");
            rs = ps.executeQuery();
            while(rs.next()==true){
                propCom=false;
                PreparedStatement ps2 =con.prepareStatement("select * from Avaliacao where FKmatricula = ?");
                ps2.setString(1, matricula);
                ResultSet rs2 = ps2.executeQuery();
                
                while(rs2.next()==true){
                    if(rs2.getString(1).equals(rs.getString(4))){
                        propCom=true;
                    }
                }
                
                if(propCom==false){
                    Object linha[] = {rs.getString(1),rs.getString(2)};
                    modelo.addRow(linha);
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SelecionarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tabDen.setModel(modelo);
     }
    

    /**
     * Codigo do construtor que não ser modificado ou removido
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        tabDen = new javax.swing.JTable();
        btConf = new javax.swing.JButton();
        btCan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabDen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id do Comentario", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollPane.setViewportView(tabDen);

        btConf.setText("Confirmar");
        btConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfActionPerformed(evt);
            }
        });

        btCan.setText("Cancelar");
        btCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCan)
                .addGap(78, 78, 78)
                .addComponent(btConf)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConf)
                    .addComponent(btCan))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Fecha a tela atual se o botão for pressionado
     */
    
    private void btCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCanActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCanActionPerformed
    
    /**
     * Abre a tela que mostra a denuncia selecionado na tabela se o botão for
     * pressionado
     */  
    private void btConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfActionPerformed
        if(tabDen.getSelectedRow() != -1){
            String id2 = tabDen.getValueAt(tabDen.getSelectedRow(),0).toString();
            new JulgarDenuncias(id2,this).setVisible(true);
            this.dispose();
        }
        
        
        
    }//GEN-LAST:event_btConfActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionarDenuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarDenuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarDenuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarDenuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionarDenuncia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton btCan;
    private javax.swing.JButton btConf;
    private javax.swing.JTable tabDen;
    // End of variables declaration//GEN-END:variables
}
