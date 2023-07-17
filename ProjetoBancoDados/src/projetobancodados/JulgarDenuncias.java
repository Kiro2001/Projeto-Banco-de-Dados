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
import javax.swing.JOptionPane;

/**
 *
 * @author jplim
 */
public class JulgarDenuncias extends javax.swing.JFrame {

    String matriculaInf;
    String id;
    Connection con;
    ResultSet rs;
    ResultSet rs2;
    SelecionarDenuncia selden;
    
    public JulgarDenuncias() {
        initComponents();
    }
    
    /**
     * Inicia a tela com argumentos fornecidos na tela anterior e faz queries
     * para preencher elementos da tela
     */
    public JulgarDenuncias(String ID,SelecionarDenuncia Selden) {
        initComponents();
        selden=Selden;
        id=ID;
        ComDen.setEditable(false);
        ComDel.setEditable(false);
        Opcoes.setEnabled(false);
        Opcoes.addItem("Palavras de baixo calão");
        Opcoes.addItem("Falou alguma mentira");
        Opcoes.addItem("Outro");
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Denuncia where idDen=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()==true){
                PreparedStatement ps2 =con.prepareStatement("select * from Avaliacao where idAval = ?");
                ps2.setString(1, rs.getString(4));
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                ComDen.setText(rs2.getString(2));
                matriculaInf = rs2.getString(4);
                ComDel.setText(rs.getString(3));
                Opcoes.select(rs.getString(2));
                
                if(rs2.getString(7).equals("Turma")){
                    ComDen.setText(rs2.getString(2));
                    lbAlvo.setText("Turma de ID:" + rs2.getString(5));
                }
                else{
                    ComDen.setText(rs2.getString(2));
                    lbAlvo.setText("Professor:" + rs2.getString(6));
                }
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
        ComDen = new javax.swing.JTextArea();
        btExcAl = new javax.swing.JButton();
        btCan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ComDel = new javax.swing.JTextArea();
        Opcoes = new java.awt.Choice();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btExDen = new javax.swing.JButton();
        lbAlvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComDen.setColumns(20);
        ComDen.setRows(5);
        ComDen.setText("SEM DENUNCIAS");
        jScrollPane1.setViewportView(ComDen);

        btExcAl.setText("Excluir Aluno");
        btExcAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcAlActionPerformed(evt);
            }
        });

        btCan.setText("Cancelar");
        btCan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Denuncias");

        ComDel.setColumns(20);
        ComDel.setRows(5);
        ComDel.setText("SEM DENUNCIAS");
        jScrollPane2.setViewportView(ComDel);

        jLabel1.setText("Comentario Possivelmente Inflator");

        jLabel2.setText("Comentario do Aluno que Denunciou");

        btExDen.setText("Excluir Denuncia");
        btExDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExDenActionPerformed(evt);
            }
        });

        lbAlvo.setText("SEM DADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCan)
                                .addGap(57, 57, 57)
                                .addComponent(btExDen)
                                .addGap(53, 53, 53)
                                .addComponent(btExcAl))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(150, 150, 150))))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAlvo)
                    .addComponent(jLabel1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbAlvo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcAl)
                    .addComponent(btCan)
                    .addComponent(btExDen))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Exclui o Aluno ,que fez a avaliação infratora, do Banco de Dados.
     */
    private void btExcAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcAlActionPerformed

        try {
            PreparedStatement ps =con.prepareStatement("delete from Aluno where matricula = ?");
            ps.setString(1,matriculaInf);
            ps.executeUpdate();
            selden.carregarTabelaTotal();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btExcAlActionPerformed

    
    /**
     * Fecha a tela atual ao pressionar o botão
     */
    private void btCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCanActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCanActionPerformed

    
    /**
     * Exclui a denuncia do banco de dados ao ser pressionado o botão 
     */
    private void btExDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExDenActionPerformed
        try {
            PreparedStatement ps =con.prepareStatement("delete from Denuncia where idDen = ?");
            ps.setString(1,id);
            ps.executeUpdate();
            selden.carregarTabelaTotal();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btExDenActionPerformed

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
            java.util.logging.Logger.getLogger(JulgarDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JulgarDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JulgarDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JulgarDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JulgarDenuncias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComDel;
    private javax.swing.JTextArea ComDen;
    private java.awt.Choice Opcoes;
    private javax.swing.JButton btCan;
    private javax.swing.JButton btExDen;
    private javax.swing.JButton btExcAl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAlvo;
    // End of variables declaration//GEN-END:variables
}
