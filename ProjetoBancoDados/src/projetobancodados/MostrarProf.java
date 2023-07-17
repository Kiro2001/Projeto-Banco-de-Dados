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
public class MostrarProf extends javax.swing.JFrame {

    String matricula;
    String nomeProf;
    String idCom;
    Connection con;
    ResultSet rs;
    public MostrarProf() {
        initComponents();
    }
    
    /**
     * Inicia a tela com argumentos fornecidos anteriormente e são feitas queries
     * para preencher a tela com dados da primeira avaliação feita no professor
     * selecionado na tela anterior
     */
    
    public MostrarProf(String Matricula,String nome) {
        initComponents();
        nomeProf=nome;
        ComTA.setEditable(false);
        matricula=Matricula;
        btDen.setEnabled(false);
        
         try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Professor where nome = ?");
            ps.setString(1, nomeProf);
            rs = ps.executeQuery();
            if(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select nome from Departamento where cod = ?");
                ps2.setString(1, rs.getString(2));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                lbProf.setText("Professor:" + rs.getString(1));
                lbDep.setText("Departamento:" + rs2.getString(1));
                
            }
            
            ps =con.prepareStatement("select * from Avaliacao where FKnomeProf = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, nomeProf);
            rs = ps.executeQuery();
            
            if(rs.next()==true){
                ComTA.setText(rs.getString(2));
                lbNota.setText(rs.getString(3)+"/5");
                btDen.setEnabled(true);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /**
     * Codigo do construtor de telas que não ser modificado ou removido
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ComTA = new javax.swing.JTextArea();
        btDen = new javax.swing.JButton();
        btAnt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbNota = new javax.swing.JLabel();
        btProx = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbProf = new javax.swing.JLabel();
        lbDep = new javax.swing.JLabel();
        btAvalProf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComTA.setColumns(20);
        ComTA.setRows(5);
        ComTA.setText("SEM AVALIACÔES");
        jScrollPane1.setViewportView(ComTA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 204, 400, 140));

        btDen.setText("Denunciar Avaliação");
        btDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDenActionPerformed(evt);
            }
        });
        getContentPane().add(btDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 356, -1, -1));

        btAnt.setText("Anterior");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });
        getContentPane().add(btAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 356, -1, -1));

        jLabel4.setText("Nota:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 324, 30, 20));

        lbNota.setText("Sem nota");
        getContentPane().add(lbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 326, -1, -1));

        btProx.setText("Proxima");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });
        getContentPane().add(btProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 356, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Avaliações");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 161, -1, -1));

        lbProf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbProf.setText("jLabel1");
        getContentPane().add(lbProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 28, -1, -1));

        lbDep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDep.setText("jLabel2");
        getContentPane().add(lbDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, -1, -1));

        btAvalProf.setText("Avaliar");
        btAvalProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvalProfActionPerformed(evt);
            }
        });
        getContentPane().add(btAvalProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre a tela para denuncia a avaliação sendo mostrada atualmente e fecha
     * a tela atual
     */
    
    private void btDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDenActionPerformed
        try {
            idCom = rs.getString(1);
            new DenunciaAvaliacao(idCom,matricula).setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btDenActionPerformed
    
    /**
     * Checa se existir uma avaliação anterior desse professor e caso sim muda
     * os dados da avaliação sendo mostrada atualmente para essa avaliação anterior
     */
    
    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            if(rs.previous()==true){
                ComTA.setText(rs.getString(2));
                lbNota.setText(rs.getString(3)+"/5");
                idCom=rs.getString(1);
                btDen.setEnabled(true);
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
     * Checa se existe uma proxima avaliação sobre o professor, e sim muda a 
     * avaliação sendo mostrada atualmente para essa proxima avaliação
     */
    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            if(rs.next()==true){
                ComTA.setText(rs.getString(2));
                lbNota.setText(rs.getString(3)+"/5");
                idCom=rs.getString(1);
                btDen.setEnabled(true);
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
     * Abre uma tela para ser feita uma avaliação sobre o professor atual que foi
     * selecionado na tela anterior e fecha a tela atual
     */
    private void btAvalProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvalProfActionPerformed
        new AvaliarProf(matricula,nomeProf).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAvalProfActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComTA;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btAvalProf;
    private javax.swing.JButton btDen;
    private javax.swing.JButton btProx;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDep;
    private javax.swing.JLabel lbNota;
    private javax.swing.JLabel lbProf;
    // End of variables declaration//GEN-END:variables
}
