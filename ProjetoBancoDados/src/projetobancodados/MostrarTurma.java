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
public class MostrarTurma extends javax.swing.JFrame {

    String idTurma;
    String idCom;
    String matricula;
    Connection con;
    ResultSet rs;
    public MostrarTurma() {
        initComponents();
    }
    
    /**
     * Inicia a tela com argumentos fornecidos anteriormente e são feitas queries
     * para preencher a tela com dados da primeira avaliação feita da turma
     * selecionado na tela anterior
     */
    public MostrarTurma(String ID,String Matricula) {
        initComponents();
        ComTA.setEditable(false);
        idTurma=ID;
        matricula=Matricula;
        btDen.setEnabled(false);
        
         try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Turma where idTurma = ?");
            ps.setString(1, idTurma);
            rs = ps.executeQuery();
            if(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                ps2.setString(1, rs.getString(9));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                lbDiscl.setText(rs2.getString(1));
                lbNum.setText(rs.getString(2));
                lbProf.setText(rs.getString(8));
                lbHor.setText(rs.getString(4));
                lbLocal.setText(rs.getString(7));
                lbPerio.setText(rs.getString(3));
                lbVagas.setText(rs.getString(5) + "/" + rs.getString(6));
            }
            
            ps =con.prepareStatement("select * from Avaliacao where FKidturma = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, idTurma);
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

        jLabel1 = new javax.swing.JLabel();
        lbDiscl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNum = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbProf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComTA = new javax.swing.JTextArea();
        btDen = new javax.swing.JButton();
        btAnt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbNota = new javax.swing.JLabel();
        btAvaliar = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbPerio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbHor = new javax.swing.JLabel();
        lbLocal = new javax.swing.JLabel();
        lbVagas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Disciplina:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, -1, -1));

        lbDiscl.setText("jLabel2");
        getContentPane().add(lbDiscl, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 16, -1, -1));

        jLabel3.setText("Número da Turma:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, -1, -1));

        lbNum.setText("jLabel4");
        getContentPane().add(lbNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 44, -1, -1));

        jLabel2.setText("Professor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, -1, -1));

        lbProf.setText("jLabel4");
        getContentPane().add(lbProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 66, -1, -1));

        ComTA.setColumns(20);
        ComTA.setRows(5);
        ComTA.setText("SEM AVALIACÔES");
        jScrollPane1.setViewportView(ComTA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 237, 400, 140));

        btDen.setText("Denunciar Avaliação");
        btDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDenActionPerformed(evt);
            }
        });
        getContentPane().add(btDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 389, -1, -1));

        btAnt.setText("Anterior");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });
        getContentPane().add(btAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 389, -1, -1));

        jLabel4.setText("Nota:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 357, 30, 20));

        lbNota.setText("Sem nota");
        getContentPane().add(lbNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 359, -1, -1));

        btAvaliar.setText("Avaliar Turma");
        btAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAvaliarActionPerformed(evt);
            }
        });
        getContentPane().add(btAvaliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 77, -1, -1));

        btProx.setText("Proxima");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });
        getContentPane().add(btProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 389, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Avaliações");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 194, -1, -1));

        lbPerio.setText("jLabel6");
        getContentPane().add(lbPerio, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 94, -1, -1));

        jLabel6.setText("Periodo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 94, -1, -1));

        jLabel7.setText("Horario:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 116, -1, -1));

        jLabel8.setText("Local:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 138, -1, -1));

        jLabel9.setText("Vagas:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 160, -1, -1));

        lbHor.setText("jLabel10");
        getContentPane().add(lbHor, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 116, -1, -1));

        lbLocal.setText("jLabel11");
        getContentPane().add(lbLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 138, -1, -1));

        lbVagas.setText("jLabel12");
        getContentPane().add(lbVagas, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 160, -1, -1));

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
     * Checa se existir uma avaliação anterior dessa turma e caso sim muda
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
     * Abre uma tela para ser feita uma avaliação sobre a turma atual que foi
     * selecionado na tela anterior e fecha a tela atual
     */
    
    private void btAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAvaliarActionPerformed
        new AvaliarTurma(idTurma,matricula).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btAvaliarActionPerformed
    
    /**
     * Checa se existe uma proxima avaliação sobre a turma, e sim muda a 
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
            java.util.logging.Logger.getLogger(MostrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComTA;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btAvaliar;
    private javax.swing.JButton btDen;
    private javax.swing.JButton btProx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiscl;
    private javax.swing.JLabel lbHor;
    private javax.swing.JLabel lbLocal;
    private javax.swing.JLabel lbNota;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbPerio;
    private javax.swing.JLabel lbProf;
    private javax.swing.JLabel lbVagas;
    // End of variables declaration//GEN-END:variables
}
