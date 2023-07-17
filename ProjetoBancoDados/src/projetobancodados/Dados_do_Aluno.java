/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jplim
 */
public class Dados_do_Aluno extends javax.swing.JFrame {

    String matricula;
    Connection con;
    TelaInicialAluno Tela;
    public Dados_do_Aluno() {
        initComponents();
    }
    
    /**
     * Cria a tela com os argumentos dados na tela anterior e faz a conexão com o banco, para executar queries
     * para preencher elementos da tela com os Dados do usuario atual
     */
    public Dados_do_Aluno(String Matricula,TelaInicialAluno tela) {
        initComponents();
        matricula=Matricula;
        Tela=tela;
        byte[] imageB = null;
        
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Aluno where Aluno.matricula= ?");
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            if (rs.getBytes(7) != null){
                imageB=rs.getBytes(7);
                Image img = Toolkit.getDefaultToolkit().createImage(imageB);
                Image newImage = img.getScaledInstance(jImagem.getWidth(),jImagem.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImage);
                jImagem.setIcon(image);
            }
            else{
                ImageIcon myImage = new ImageIcon(getClass().getResource("/projetobancodados/user.png"));
                Image img = myImage.getImage();
                Image newImage = img.getScaledInstance(jImagem.getWidth(),jImagem.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImage);
                jImagem.setIcon(image);
            }
            
            jMatricula.setText(Matricula);
            jNome.setText(rs.getString(3));
            jEmail.setText(rs.getString(2));
            jCurso.setText(rs.getString(5));
            
            if(rs.getString(6).equals("1")){
              jCargo.setText("Aluno administrador");
            }
            else{
                jCargo.setText("Aluno");
            };
            
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

        jImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jNome = new javax.swing.JLabel();
        jEmail = new javax.swing.JLabel();
        jCargo = new javax.swing.JLabel();
        jAlterar = new javax.swing.JButton();
        jExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMatricula = new javax.swing.JLabel();
        jlabel0 = new javax.swing.JLabel();
        jCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 0, 120, 140));

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, -1, -1));

        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 81, -1, -1));

        jLabel3.setText("Cargo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 145, -1, -1));

        jNome.setText("jLabel4");
        getContentPane().add(jNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 53, -1, -1));

        jEmail.setText("jLabel5");
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 81, -1, -1));

        jCargo.setText("jLabel6");
        getContentPane().add(jCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 145, -1, -1));

        jAlterar.setText("Alterar Dados");
        jAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(jAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 257, -1, -1));

        jExcluir.setText("Excluir Conta");
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 257, -1, -1));

        jLabel4.setText("Matricula:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 25, -1, -1));

        jMatricula.setText("jLabel5");
        getContentPane().add(jMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 25, -1, -1));

        jlabel0.setText("Curso:");
        getContentPane().add(jlabel0, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 115, -1, -1));

        jCurso.setText("jLabel5");
        getContentPane().add(jCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 115, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Ao apertar o botão de excluir , e feito uma ultima pergunta para confirmar se o usuario tem certeza,
     * se sim o usuario e apagado do banco, a tela e fechada e uma nova tela Inicial é aberta
     */
    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        Object[] options = { "Sim", "Não" };
        int result = JOptionPane.showOptionDialog(null,"Tem certeza disso ?","Confirmação",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,options,options[0]);
        if (result ==0){
            try {
            PreparedStatement ps =con.prepareStatement("delete from Aluno where Aluno.matricula= ?");
            ps.setString(1,matricula);
            ps.executeUpdate();
            Tela.dispose();
            new TelaInicial().setVisible(true);
            this.dispose();
            

        } catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_jExcluirActionPerformed
    
    /**
     * Ao aperta o botão de alterar dados é aberto uma nova tela  para alterar os dados e a tela atual
     * é fechada
     */
    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed
        new AlterarDadosAluno(matricula).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(Dados_do_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dados_do_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dados_do_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dados_do_Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dados_do_Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JLabel jCargo;
    private javax.swing.JLabel jCurso;
    private javax.swing.JLabel jEmail;
    private javax.swing.JButton jExcluir;
    private javax.swing.JLabel jImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jMatricula;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jlabel0;
    // End of variables declaration//GEN-END:variables
}
