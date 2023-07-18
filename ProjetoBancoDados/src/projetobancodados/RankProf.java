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
public class RankProf extends javax.swing.JFrame {

    String matricula;
    Connection con;
    
    public RankProf() {
        initComponents();
    }
    
    /**
     * Inicia tela ,faz a conexão com o banco e chama o metodo de carregar a
     * tabela com o ranking
     */
    public RankProf(String Matricula) {
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
     * Faz queries para preencher a tabela com o nome dos professores avaliados 
     * e a media das notas dados nas avaliações feitas sobre eles
     */
    
    public void carregarTabela(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Nome do Professor","Media da nota"},0){
            @Override
            public boolean isCellEditable(int row, int column){return false;}};
        try {
            PreparedStatement ps =con.prepareStatement("select FKnomeProf,cast(avg(nota) as decimal(3, 2)) as media from avaliacao where Alvo = 'Professor' group by FKnomeProf order by media DESC;");
            ResultSet rs = ps.executeQuery();
            while(rs.next()==true){
                Object linha[] = {rs.getString(1),rs.getString(2)};
                modelo.addRow(linha);
            }
            rankProf.setModel(modelo);
            
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
        rankProf = new javax.swing.JTable();
        btSairTela = new javax.swing.JButton();
        btVerProf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rankProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Professor", "Media da Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(rankProf);

        btSairTela.setText("Sair");
        btSairTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairTelaActionPerformed(evt);
            }
        });

        btVerProf.setText("Ver Professor");
        btVerProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerProfActionPerformed(evt);
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
                .addComponent(btVerProf)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSairTela)
                    .addComponent(btVerProf)))
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
     * Abre a tela que mostra o professor selecionado na tabela e fecha a tela 
     * atual
     */
    private void btVerProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerProfActionPerformed
        if(rankProf.getSelectedRow()!=-1){
            String nome = rankProf.getValueAt(rankProf.getSelectedRow(),0).toString();
            new MostrarProf(matricula,nome).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btVerProfActionPerformed

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
            java.util.logging.Logger.getLogger(RankProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RankProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RankProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RankProf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RankProf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSairTela;
    private javax.swing.JButton btVerProf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable rankProf;
    // End of variables declaration//GEN-END:variables
}
