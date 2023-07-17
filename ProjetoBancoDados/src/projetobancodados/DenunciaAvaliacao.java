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
public class DenunciaAvaliacao extends javax.swing.JFrame {

    String id;
    String matricula;
    Connection con;
    
    public DenunciaAvaliacao() {
        initComponents();
    }
    
    /**
     * Cria a tela com os argumentos dados na tela anterior , e feito uma conexão com o banco e queries
     * são feitas para preencher dados sobre a avaliação que o usuario quer denunciar
     */
    public DenunciaAvaliacao(String IdComen,String Matricula) {
        initComponents();
        id=IdComen;
        matricula=Matricula;
        OutroMot.setEditable(false);
        ComDen.setEditable(false);
        Opcoes.addItem("Palavras de baixo calão");
        Opcoes.addItem("Falou alguma mentira");
        Opcoes.addItem("Outro");
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Avaliacao where idAval = ?");
            ps.setString(1, id);
            ResultSet rs2 = ps.executeQuery();
            if(rs2.next()==true){
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OutroMot = new javax.swing.JTextArea();
        Opcoes = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        btConf = new javax.swing.JButton();
        btCan = new javax.swing.JButton();
        lbAlvo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ComDen.setColumns(20);
        ComDen.setRows(5);
        jScrollPane1.setViewportView(ComDen);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Avaliação Denunciada");

        OutroMot.setColumns(20);
        OutroMot.setRows(5);
        jScrollPane2.setViewportView(OutroMot);

        Opcoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OpcoesItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Motivo da Denuncia");

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

        lbAlvo.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(Opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAlvo)
                            .addComponent(jLabel1))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btCan)
                .addGap(48, 48, 48)
                .addComponent(btConf)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbAlvo)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCan)
                    .addComponent(btConf))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Fecha a tela ao botão ser pressionado
     */
    private void btCanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCanActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCanActionPerformed
    
    /**
     * Ao ocorrer uma mudança no motivo selecionado para denuncia,checa se e 'Outro'
     * porque se for,o campo de texto tem que ser liberado para escrita do usuario
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
     * Cria e salva uma denuncia no banco de dados, com os dados que o usuario com dados da tela e da avaliação
     * escolhida para ser denunciada
     */
    private void btConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfActionPerformed
        if(!Opcoes.getSelectedItem().equals("")){
            try {
                PreparedStatement ps=con.prepareStatement("insert into Denuncia (motivo_den,outro_motivo,FKidAval,FKmatriculaDelator) values(?,?,?,?)");
                ps.setString(1,Opcoes.getSelectedItem());
                ps.setString(2,OutroMot.getText());
                ps.setString(3,id);
                ps.setString(4,matricula);
                ps.executeUpdate();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(DenunciaAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else{
          JOptionPane.showMessageDialog(this, "Selecione um motivo");
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
            java.util.logging.Logger.getLogger(DenunciaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DenunciaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DenunciaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DenunciaAvaliacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DenunciaAvaliacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComDen;
    private java.awt.Choice Opcoes;
    private javax.swing.JTextArea OutroMot;
    private javax.swing.JButton btCan;
    private javax.swing.JButton btConf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAlvo;
    // End of variables declaration//GEN-END:variables
}
