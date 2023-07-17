/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
/**
 *
 * @author jplim
 */
public class AvaliarTurma extends javax.swing.JFrame {

    String id;
    String matricula;
    Connection con;
    public AvaliarTurma() {
        initComponents();
    }
    
    /**
     *Inicia a tela com os argumentos fornecidos e faz queries com eles para preencher elementos da tela com
     * dados da Turma selecionada
     */
    public AvaliarTurma(String ID,String Matricula) {
        initComponents();
        spNota.setValue(1);
        id=ID;
        matricula=Matricula;
        
         try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Turma where idTurma = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select nome from Disciplina where cod = ?");
                ps2.setString(1, rs.getString(9));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                lbDiscl.setText(rs2.getString(1));
                lbNum.setText(rs.getString(2));
                lbProf.setText(rs.getString(8));
            
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
        btConf = new javax.swing.JButton();
        btCan = new javax.swing.JButton();
        spNota = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(494, 361));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Disciplina:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 23, -1, -1));

        lbDiscl.setText("jLabel2");
        getContentPane().add(lbDiscl, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 23, -1, -1));

        jLabel3.setText("Número da Turma:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, -1, -1));

        lbNum.setText("jLabel4");
        getContentPane().add(lbNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 51, -1, -1));

        jLabel2.setText("Professor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, -1, -1));

        lbProf.setText("jLabel4");
        getContentPane().add(lbProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 79, -1, -1));

        ComTA.setColumns(20);
        ComTA.setRows(5);
        jScrollPane1.setViewportView(ComTA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 155, 400, 140));

        btConf.setText("Confirmar");
        btConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfActionPerformed(evt);
            }
        });
        getContentPane().add(btConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, -1));

        btCan.setText("Cancelar");
        btCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCanActionPerformed(evt);
            }
        });
        getContentPane().add(btCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        spNota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spNotaStateChanged(evt);
            }
        });
        getContentPane().add(spNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        jLabel4.setText("Nota:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Ao apertar o botão a tela atual e fechada
     */
    private void btCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCanActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCanActionPerformed

    
    /**
     * Ao apertar o botão de confirmação os dados na tela são usados para criar uma nova avaliação e inseri-la no 
     * Banco de Dados e a tela e fechada
     */
    private void btConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfActionPerformed
        String comen = ComTA.getText();
        String nota = spNota.getValue().toString();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Avaliacao(comentario,nota,FKmatricula,FKidturma,alvo) values (?,?,?,?,?)");
            ps.setString(1,comen);
            ps.setString(2,nota);
            ps.setString(3,matricula);
            ps.setString(4,id);
            ps.setString(5,"Turma");
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btConfActionPerformed
    
    
    /**
     * Mantem o range da nota selecionada entre 1 e 5
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
            java.util.logging.Logger.getLogger(AvaliarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvaliarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvaliarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvaliarTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvaliarTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComTA;
    private javax.swing.JButton btCan;
    private javax.swing.JButton btConf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiscl;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbProf;
    private javax.swing.JSpinner spNota;
    // End of variables declaration//GEN-END:variables
}
