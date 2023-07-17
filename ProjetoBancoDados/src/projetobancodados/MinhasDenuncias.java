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
public class MinhasDenuncias extends javax.swing.JFrame {
    
    Connection con;
    ResultSet rs;
    ResultSet rs2;
    String matricula;
    public MinhasDenuncias() {
        initComponents();
    }
    
    /**
     * Tela é criada utilizando argumentos fornecidos na tela anterior e queries
     * que fornecem dados usados na tela sobre a primeira denuncia em uma query
     * de denuncias feitas pelo usuario 
     */
    public MinhasDenuncias(String Matricula) {
        initComponents();
        matricula=Matricula;
        btConfAlt.setVisible(false);
        Opcoes.setEnabled(false);
        ComDen.setEditable(false);
        Opcoes.addItem("Palavras de baixo calão");
        Opcoes.addItem("Falou alguma mentira");
        Opcoes.addItem("Outro");
        OutroMot.setEditable(false);
        btAlt.setEnabled(false);
        Excluir.setEnabled(false);
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Denuncia where FKmatriculaDelator = ?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, matricula);
            rs = ps.executeQuery();
            if(rs.next()==true){
                ps = con.prepareStatement("select * from Avaliacao where idAval = ?");
                ps.setString(1, rs.getString(4));
                rs2 = ps.executeQuery();
                if(rs2.next()==true){
                    ComDen.setText(rs2.getString(2));
                    Opcoes.select(rs.getString(2));
                    OutroMot.setText(rs.getString(3));
                    
                    if(rs2.getString(7).equals("Turma")){
                        lbAlvo.setText("Turma de ID:" + rs2.getString(5));
                    }
                    else{
                        lbAlvo.setText("Professor:" + rs2.getString(6));
                    }
                    
                    btAlt.setEnabled(true);
                    Excluir.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OutroMot = new javax.swing.JTextArea();
        Opcoes = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        btAnt = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComDen = new javax.swing.JTextArea();
        btAlt = new javax.swing.JButton();
        btConfAlt = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        lbAlvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Avaliação Denunciada");

        OutroMot.setColumns(20);
        OutroMot.setRows(5);
        OutroMot.setText("SEM DENUNCIA");
        jScrollPane2.setViewportView(OutroMot);

        Opcoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OpcoesItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Motivo da Denuncia");

        btAnt.setText("Anterior");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });

        btProx.setText("Proxima");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });

        ComDen.setColumns(20);
        ComDen.setRows(5);
        jScrollPane1.setViewportView(ComDen);

        btAlt.setText("Alterar");
        btAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltActionPerformed(evt);
            }
        });

        btConfAlt.setText("Confirmar Alterações");
        btConfAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfAltActionPerformed(evt);
            }
        });

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        lbAlvo.setText("SEM DADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel2)))
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAnt)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAlvo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAlt)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Excluir)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btConfAlt))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)
                                .addComponent(Opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btProx)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(lbAlvo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btProx, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAnt, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(133, 133, 133))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAlt)
                            .addComponent(btConfAlt))
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Checa se a mundaça feita na opcção de motivos e 'Outro' para poder liberar
     * o campo de texto
     */
    private void OpcoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OpcoesItemStateChanged
        if(Opcoes.getSelectedItem().equals("Outro")){
            OutroMot.setEditable(true);
        }
        else{
            OutroMot.setEditable(false);
        }
    }//GEN-LAST:event_OpcoesItemStateChanged
    
    /**
     * Checa e muda se existir para uma avaliação anterior na query feita ao iniciar
     * a tela.
     */
    
    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            if(rs.previous()==true){
                PreparedStatement ps = con.prepareStatement("select * from Avaliacao where idAval = ?");
                ps.setString(1, rs.getString(4));
                rs2 = ps.executeQuery();
                if(rs2.next()==true){
                    ComDen.setText(rs2.getString(2));
                    Opcoes.select(rs.getString(2));
                    OutroMot.setText(rs.getString(3));
                    
                    if(rs2.getString(7).equals("Turma")){
                        lbAlvo.setText("Turma de ID:" + rs2.getString(5));
                    }
                    else{
                        lbAlvo.setText("Professor:" + rs2.getString(6));
                    }
                    
                    btAlt.setEnabled(true);
                    Excluir.setEnabled(true);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Não existe Denuncia Posterior");
                rs.next();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinhasDenuncias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAntActionPerformed
    
    /**
     * Checa e muda se exitir para uma proxima denuncia na query feita ao
     * iniciar a tela
     */
    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            if(rs.next()==true){
                PreparedStatement ps = con.prepareStatement("select * from Avaliacao where idAval = ?");
                ps.setString(1, rs.getString(4));
                rs2 = ps.executeQuery();
                if(rs2.next()==true){
                    ComDen.setText(rs2.getString(2));
                    Opcoes.select(rs.getString(2));
                    OutroMot.setText(rs.getString(3));
                    
                    if(rs2.getString(7).equals("Turma")){
                        lbAlvo.setText("Turma de ID:" + rs2.getString(5));
                    }
                    else{
                        lbAlvo.setText("Professor:" + rs2.getString(6));
                    }
                    
                    btAlt.setEnabled(true);
                    Excluir.setEnabled(true);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Não existe Denuncia Posterior");
                rs.previous();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinhasDenuncias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btProxActionPerformed
    
    /**
     * Ativa os elementos de mudança na denuncia atual ao o botão ser apertado
     */
    
    private void btAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAltActionPerformed
        btConfAlt.setVisible(true);
        Opcoes.setEnabled(true);
        if(Opcoes.getSelectedItem().equals("Outro")){
            OutroMot.setEditable(true);
        }
    }//GEN-LAST:event_btAltActionPerformed
    
    /**
     * Confirma e da update no banco,sobre as alterações feitas na denuncia atual
     */
    private void btConfAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfAltActionPerformed
        try {
            PreparedStatement ps =con.prepareStatement("update Denuncia set motivo_den = ? , outro_motivo = ? where idDen = ?");
            ps.setString(1, Opcoes.getSelectedItem());
            ps.setString(2,OutroMot.getText());
            ps.setString(3, rs.getString(1));
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConfAltActionPerformed
    
    /**
     * Exclui a denuncia atual e fecha a tela para evitar problemas
     */
    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        try {
            PreparedStatement ps =con.prepareStatement("delete from Denuncia where idDen = ?");
            ps.setString(1, rs.getString(1));
            ps.executeUpdate();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(MostrarTurma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(MinhasDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhasDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhasDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhasDenuncias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhasDenuncias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComDen;
    private javax.swing.JButton Excluir;
    private java.awt.Choice Opcoes;
    private javax.swing.JTextArea OutroMot;
    private javax.swing.JButton btAlt;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btConfAlt;
    private javax.swing.JButton btProx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAlvo;
    // End of variables declaration//GEN-END:variables
}
