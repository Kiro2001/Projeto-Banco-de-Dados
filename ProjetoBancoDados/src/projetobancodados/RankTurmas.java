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
public class RankTurmas extends javax.swing.JFrame {

    String matricula;
    Connection con;
    
    public RankTurmas() {
        initComponents();
    }
    
     /**
     * Inicia tela ,faz a conexão com o banco e chama o metodo de carregar a
     * tabela com o ranking
     */
    
    public RankTurmas(String Matricula) {
        initComponents();
        matricula=Matricula;
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
        } catch (SQLException ex) {
            Logger.getLogger(RankTurmas.class.getName()).log(Level.SEVERE, null, ex);
        }
        carregarTabela();
    }
    
    /**
     * Faz queries para preencher a tabela com o o id,disciplina,num das turmas 
     *avaliadas e a media das notas dadas nas avaliações feitas sobre elas
     */
    
    public void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Id","Disciplina","Nº da turma","Media da nota"},0){
            @Override
            public boolean isCellEditable(int row, int column){return false;}};
        try {
            PreparedStatement ps =con.prepareStatement("select FKidTurma,cast(avg(nota) as decimal(3, 2)) as media from avaliacao where Alvo = 'Turma' group by FKidturma order by media DESC;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()==true){
                PreparedStatement ps2 = con.prepareStatement("select * from Turma where idTurma = ?");
                ps2.setString(1,rs.getString(1));
                ResultSet rs2 = ps2.executeQuery();
                
                if(rs2.next()==true){
                    PreparedStatement ps3 =con.prepareStatement("select nome from Disciplina where cod = ?");
                    ps3.setString(1, rs2.getString(9));
                    ResultSet rs3 = ps3.executeQuery();
                    rs3.next();
                    Object linha[] = {rs.getString(1),rs3.getString(1),rs2.getString(2),rs.getString(2)};
                    modelo.addRow(linha);
                }
            
                
            }
            rankTurma.setModel(modelo);
            
        }catch (SQLException ex) {
            Logger.getLogger(SelecionarTurma.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
    /**
     * Codigo do construtor que não deve ser modificado ou removido
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rankTurma = new javax.swing.JTable();
        btSairTela = new javax.swing.JButton();
        btVerTurma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rankTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Disciplina", "Num  da Turma", "Media da Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rankTurma);

        btSairTela.setText("Sair");
        btSairTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairTelaActionPerformed(evt);
            }
        });

        btVerTurma.setText("Ver Turma");
        btVerTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerTurmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btSairTela)
                .addGap(62, 62, 62)
                .addComponent(btVerTurma)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSairTela)
                    .addComponent(btVerTurma)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sai da tela atual
     */
    
    private void btSairTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairTelaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairTelaActionPerformed
    
    /**
     * Abre a tela que mostra a turma selecionado na tabela e fecha a tela atual
     */
    
    private void btVerTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerTurmaActionPerformed
        if(rankTurma.getSelectedRow()!=-1){
            String ID = rankTurma.getValueAt(rankTurma.getSelectedRow(),0).toString();
            new MostrarTurma(ID,matricula).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btVerTurmaActionPerformed

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
            java.util.logging.Logger.getLogger(RankTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankTurmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankTurmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSairTela;
    private javax.swing.JButton btVerTurma;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rankTurma;
    // End of variables declaration//GEN-END:variables
}
