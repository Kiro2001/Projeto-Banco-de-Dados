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
public class AvaliarProf extends javax.swing.JFrame {

    String matricula;
    String nomeProf;
    Connection con;
    ResultSet rs;
    
    public AvaliarProf() {
        initComponents();
    }
    
    /**
     * Inicia a tela com os argumentos dados na tela que abriu essa e usa eles para fazer query,pegando dados que são
     * usados para preencher elementos da tela
     */
    public AvaliarProf(String Matricula,String nome) {
        initComponents();
        nomeProf=nome;
        spNota.setValue(1);
        matricula=Matricula;
        
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Professor where nome = ?");
            ps.setString(1,nomeProf);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select nome from Departamento where cod = ?");
                ps2.setString(1, rs.getString(2));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                lbProf.setText(rs.getString(1));
                lbDep.setText(rs2.getString(1));
            
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

        jLabel3 = new javax.swing.JLabel();
        lbDep = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbProf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComTA = new javax.swing.JTextArea();
        btConf = new javax.swing.JButton();
        btCan = new javax.swing.JButton();
        spNota = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Departamento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 47, -1, -1));

        lbDep.setText("jLabel4");
        getContentPane().add(lbDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 47, -1, -1));

        jLabel2.setText("Professor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 25, -1, -1));

        lbProf.setText("jLabel4");
        getContentPane().add(lbProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 25, -1, -1));

        ComTA.setColumns(20);
        ComTA.setRows(5);
        jScrollPane1.setViewportView(ComTA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 151, 400, 140));

        btConf.setText("Confirmar");
        btConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfActionPerformed(evt);
            }
        });
        getContentPane().add(btConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 326, -1, -1));

        btCan.setText("Cancelar");
        btCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCanActionPerformed(evt);
            }
        });
        getContentPane().add(btCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 326, -1, -1));

        spNota.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spNotaStateChanged(evt);
            }
        });
        getContentPane().add(spNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 116, -1, -1));

        jLabel4.setText("Nota:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 116, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    /**
     * Ao aperta o botão de confirmação os dados da tela são pegos e inseridos no banco de dados
     */
    private void btConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfActionPerformed
        String comen = ComTA.getText();
        String nota = spNota.getValue().toString();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into Avaliacao(comentario,nota,FKmatricula,FKnomeProf,alvo) values (?,?,?,?,?)");
            ps.setString(1,comen);
            ps.setString(2,nota);
            ps.setString(3,matricula);
            ps.setString(4,nomeProf);
            ps.setString(5,"Professor");
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btConfActionPerformed
    
    /**
     * Botão de cancelamento,apenas fecha tela
     */
    private void btCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCanActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCanActionPerformed
    
    
    /**
     *Mantem o range da nota entre 1 e 5
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
            java.util.logging.Logger.getLogger(AvaliarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvaliarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvaliarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvaliarProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvaliarProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComTA;
    private javax.swing.JButton btCan;
    private javax.swing.JButton btConf;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDep;
    private javax.swing.JLabel lbProf;
    private javax.swing.JSpinner spNota;
    // End of variables declaration//GEN-END:variables
}
