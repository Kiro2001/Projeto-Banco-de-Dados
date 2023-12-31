/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jplim
 */
public class MinhasAvaliacoes extends javax.swing.JFrame {

    String matricula;
    Connection con;
    ResultSet rs;
    ResultSet rs2;
    ResultSet rs3;
    
    public MinhasAvaliacoes() {
        initComponents();
    }
    
    /**
     * Inicia a tela com o argumento fornecido e faz queries para preencher os
     * elementos da tela com dados da primeira avaliação que foi feita por
     * alguem utilizando da matricula atual,se existir
     */
    public MinhasAvaliacoes(String Matricula) {
        initComponents();
        matricula=Matricula;
        btConAlt.setVisible(false);
        ComAvl.setEditable(false);
        spNota.setEnabled(false);
        btAlt.setEnabled(false);
        btExc.setEnabled(false);
        
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps = con.prepareStatement("select * from Avaliacao where FKmatricula = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, Matricula);
            rs = ps.executeQuery();
            if(rs.next()==true){
                if(rs.getString(7).equals("Turma")){
                    ps =con.prepareStatement("select * from Turma where idTurma = ?");
                    ps.setString(1, rs.getString(5));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                        ps2.setString(1, rs2.getString(9));
                        ResultSet rs3 = ps2.executeQuery();
                        rs3.next();
                        lbDisc.setText("Disciplina:" + rs3.getString(1));
                        lbNumT.setText("Número da Turma:" + rs2.getString(2));
                        lbNomProf.setText("Professor:" + rs2.getString(8));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                   
                }
                else{
                    ps =con.prepareStatement("select * from Professor where nome = ?");
                    ps.setString(1, rs.getString(6));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        lbDisc.setText("Disciplina:Irrelevante" );
                        lbNumT.setText("Número da Turma:NaN");
                        lbNomProf.setText("Professor:" + rs2.getString(1));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                }
                ComAvl.setText(rs.getString(2));
                spNota.setValue(rs.getInt(3));
                
            }
            
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MinhasAvaliacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Codigo do construtor de telas que não ser modificado ou removido
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDisc = new javax.swing.JLabel();
        lbNumT = new javax.swing.JLabel();
        lbNomProf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComAvl = new javax.swing.JTextArea();
        spNota = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btProx = new javax.swing.JButton();
        btAlt = new javax.swing.JButton();
        btAnt = new javax.swing.JButton();
        btExc = new javax.swing.JButton();
        btConAlt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbDisc.setText("Disciplina:");
        getContentPane().add(lbDisc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lbNumT.setText("Número da Turma:");
        getContentPane().add(lbNumT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        lbNomProf.setText("Professor:");
        getContentPane().add(lbNomProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        ComAvl.setColumns(20);
        ComAvl.setRows(5);
        ComAvl.setText("SEM AVALIAÇÂO");
        jScrollPane1.setViewportView(ComAvl);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 210, 400, 120));

        spNota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spNotaStateChanged(evt);
            }
        });
        getContentPane().add(spNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel4.setText("Nota:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 30, 20));

        btProx.setText("Proxima");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });
        getContentPane().add(btProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        btAlt.setText("Alterar Avaliação");
        btAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltActionPerformed(evt);
            }
        });
        getContentPane().add(btAlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 169, -1, -1));

        btAnt.setText("Anterior");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });
        getContentPane().add(btAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        btExc.setText("Excluir Avaliação");
        btExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcActionPerformed(evt);
            }
        });
        getContentPane().add(btExc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 64, -1, -1));

        btConAlt.setText("Confirmar Alteração");
        btConAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConAltActionPerformed(evt);
            }
        });
        getContentPane().add(btConAlt, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 169, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Manter o range da nota da avaliação atual entre 1 e 5
     */
    private void spNotaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spNotaStateChanged
        int notaI = Integer.parseInt(spNota.getValue().toString());
        if(notaI < 1){
            spNota.setValue(1);
        }
        else if (notaI > 5){
            spNota.setValue(5);
        }
    }//GEN-LAST:event_spNotaStateChanged
    
    /**
     * Checa se existe uma outra proxima avaliação no query feita ao iniciar a tela
     * e se sim muda os dados da tela para dessa proxima avaliação
     */
    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            if(rs.next()==true){
                ComAvl.setText(rs.getString(2));
                spNota.setValue(rs.getInt(3));
                
                if(rs.getString(7).equals("Turma")){
                    PreparedStatement ps =con.prepareStatement("select * from Turma where idTurma = ?");
                    ps.setString(1, rs.getString(5));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                        ps2.setString(1, rs2.getString(9));
                        ResultSet rs3 = ps2.executeQuery();
                        rs3.next();
                        lbDisc.setText("Disciplina:" + rs3.getString(1));
                        lbNumT.setText("Número da Turma:" + rs2.getString(2));
                        lbNomProf.setText("Professor:" + rs2.getString(8));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                }
                else{
                    ComAvl.setText(rs.getString(2));
                    spNota.setValue(rs.getInt(3));
                    PreparedStatement ps =con.prepareStatement("select * from Professor where nome = ?");
                    ps.setString(1, rs.getString(6));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        lbDisc.setText("Disciplina:Irrelevante" );
                        lbNumT.setText("Número da Turma:NaN");
                        lbNomProf.setText("Professor:" + rs2.getString(1));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Não existe Proxima Avaliação");
                rs.previous();
            }

        }catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btProxActionPerformed
    
    /**
     * Ativa os elementos de modificação da avaliação atual
     */
    private void btAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltActionPerformed
        btConAlt.setVisible(true);
        ComAvl.setEditable(true);
        spNota.setEnabled(true);
        
    }//GEN-LAST:event_btAltActionPerformed
    
    
    /**
     * Checa se existe uma outra avaliação anterior no query feita ao iniciar a tela
     * e se sim muda os dados da tela para dessa avaliação anterior
     */
    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            if(rs.previous()==true){
                if(rs.getString(7).equals("Turma")){
                    ComAvl.setText(rs.getString(2));
                    spNota.setValue(rs.getInt(3));
                    PreparedStatement ps =con.prepareStatement("select * from Turma where idTurma = ?");
                    ps.setString(1, rs.getString(5));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                        ps2.setString(1, rs2.getString(9));
                        ResultSet rs3 = ps2.executeQuery();
                        rs3.next();
                        lbDisc.setText("Disciplina:" + rs3.getString(1));
                        lbNumT.setText("Número da Turma:" + rs2.getString(2));
                        lbNomProf.setText("Professor:" + rs2.getString(8));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                }
                else{
                    ComAvl.setText(rs.getString(2));
                    spNota.setValue(rs.getInt(3));
                    PreparedStatement ps =con.prepareStatement("select * from Professor where nome = ?");
                    ps.setString(1, rs.getString(6));
                    rs2 = ps.executeQuery();
                    if(rs2.next()==true){
                        lbDisc.setText("Disciplina:Irrelevante" );
                        lbNumT.setText("Número da Turma:NaN");
                        lbNomProf.setText("Professor:" + rs2.getString(1));
                        btAlt.setEnabled(true);
                        btExc.setEnabled(true);
                    }
                }
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Não existe Avaliação Anterior");
                rs.next();
            }

        }catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAntActionPerformed
    
    /**
     * Da update no banco,com qualquer mudança feita nos dados da avaliação atual que
     * são mostrados na tela
     */
    private void btConAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConAltActionPerformed
        try {
            PreparedStatement ps =con.prepareStatement("update Avaliacao set comentario = ? , nota = ? where idAval = ?");
            ps.setString(1, ComAvl.getText());
            ps.setString(2,spNota.getValue().toString());
            ps.setString(3, rs.getString(1));
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConAltActionPerformed
    
    
    /**
     * Exclui a avaliação atual e fecha a tela para evitar problemas
     */
    private void btExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcActionPerformed
        try {
            PreparedStatement ps =con.prepareStatement("delete from Avaliacao where idAval = ?");
            ps.setString(1, rs.getString(1));
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExcActionPerformed

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
            java.util.logging.Logger.getLogger(MinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhasAvaliacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhasAvaliacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComAvl;
    private javax.swing.JButton btAlt;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btConAlt;
    private javax.swing.JButton btExc;
    private javax.swing.JButton btProx;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDisc;
    private javax.swing.JLabel lbNomProf;
    private javax.swing.JLabel lbNumT;
    private javax.swing.JSpinner spNota;
    // End of variables declaration//GEN-END:variables
}
