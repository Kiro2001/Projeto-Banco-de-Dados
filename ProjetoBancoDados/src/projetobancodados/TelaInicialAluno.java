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
public class TelaInicialAluno extends javax.swing.JFrame {

    String matricula;
    Connection con;
    Boolean Admin;
    public TelaInicialAluno() {
        initComponents();
    }
    
     /**
     * Inicia a tela,faz a conexão com o banco, e utiliza queries para preencher
     * dados da tela
     */
    
    public TelaInicialAluno(String Matricula) {
        initComponents();
        matricula = Matricula;
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps =con.prepareStatement("select * from Aluno where Aluno.matricula= ?");
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()==true){
                Admin=rs.getBoolean(6);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

     /**
     Dados do construtor que não podem ser modificados ou removidos
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPerfil = new javax.swing.JMenu();
        jMenuMeusDados = new javax.swing.JMenuItem();
        jMenuMinAval = new javax.swing.JMenuItem();
        jMenuMinDen = new javax.swing.JMenuItem();
        jMenuTurma = new javax.swing.JMenu();
        jMenuAvaliaTurma = new javax.swing.JMenuItem();
        jMenuRankTurmas = new javax.swing.JMenuItem();
        jMenuProf = new javax.swing.JMenu();
        jMenuAvaliaProf = new javax.swing.JMenuItem();
        jMenuRankProf = new javax.swing.JMenuItem();
        jMenuAdmin = new javax.swing.JMenu();
        jMenuAvaliaDenun = new javax.swing.JMenuItem();
        criarAdmin = new javax.swing.JMenuItem();
        jMenuOpcoes = new javax.swing.JMenu();
        opcoesDeslogar = new javax.swing.JMenuItem();
        opcoesSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuPerfil.setText("Meu Perfil");

        jMenuMeusDados.setText("Meus Dados");
        jMenuMeusDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMeusDadosActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuMeusDados);

        jMenuMinAval.setText("Minhas Avaliacoes");
        jMenuMinAval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMinAvalActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuMinAval);

        jMenuMinDen.setText("Minhas Denuncias");
        jMenuMinDen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMinDenActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuMinDen);

        jMenuBar1.add(jMenuPerfil);

        jMenuTurma.setText("Turma");

        jMenuAvaliaTurma.setText("Avaliar Turmas");
        jMenuAvaliaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAvaliaTurmaActionPerformed(evt);
            }
        });
        jMenuTurma.add(jMenuAvaliaTurma);

        jMenuRankTurmas.setText("Ranking de Turmas");
        jMenuRankTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRankTurmasActionPerformed(evt);
            }
        });
        jMenuTurma.add(jMenuRankTurmas);

        jMenuBar1.add(jMenuTurma);

        jMenuProf.setText("Professsor");

        jMenuAvaliaProf.setText("Avaliar Professor");
        jMenuAvaliaProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAvaliaProfActionPerformed(evt);
            }
        });
        jMenuProf.add(jMenuAvaliaProf);

        jMenuRankProf.setText("Ranking de Professores");
        jMenuRankProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRankProfActionPerformed(evt);
            }
        });
        jMenuProf.add(jMenuRankProf);

        jMenuBar1.add(jMenuProf);

        jMenuAdmin.setText("Admin");

        jMenuAvaliaDenun.setText("Julgar Denuncias");
        jMenuAvaliaDenun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAvaliaDenunActionPerformed(evt);
            }
        });
        jMenuAdmin.add(jMenuAvaliaDenun);

        criarAdmin.setText("Criar Admins");
        criarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarAdminActionPerformed(evt);
            }
        });
        jMenuAdmin.add(criarAdmin);

        jMenuBar1.add(jMenuAdmin);

        jMenuOpcoes.setText("Opcoes");

        opcoesDeslogar.setText("Deslogar");
        opcoesDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoesDeslogarActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(opcoesDeslogar);

        opcoesSair.setText("Sair");
        opcoesSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcoesSairActionPerformed(evt);
            }
        });
        jMenuOpcoes.add(opcoesSair);

        jMenuBar1.add(jMenuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     /**
     * Abre a tela com os Dados do Usuario Atual
     */
    private void jMenuMeusDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMeusDadosActionPerformed
        new Dados_do_Aluno(this.matricula,this).setVisible(true);
    }//GEN-LAST:event_jMenuMeusDadosActionPerformed
    
    /**
     * Abre a tela para selecionar Turmas
     */
    
    private void jMenuAvaliaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAvaliaTurmaActionPerformed
        new SelecionarTurma(this.matricula).setVisible(true);
    }//GEN-LAST:event_jMenuAvaliaTurmaActionPerformed
    
    
    /**
     * checa se o usuario é administrador e se for abre a tela de selecionar
     * denuncias
     */
    
    private void jMenuAvaliaDenunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAvaliaDenunActionPerformed
        if(Admin==true){
            new SelecionarDenuncia(matricula).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Você não é administrador");
        }
    }//GEN-LAST:event_jMenuAvaliaDenunActionPerformed
    
    /**
     * Abre a tela com as avaliações feitas pelo Usuario Atual
     */
    
    private void jMenuMinAvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMinAvalActionPerformed
        new MinhasAvaliacoes(matricula).setVisible(true);
    }//GEN-LAST:event_jMenuMinAvalActionPerformed
    
    /**
     * Abre a tela com as denuncias feitas pelo Usuario Atual
     */
    
    private void jMenuMinDenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMinDenActionPerformed
        new MinhasDenuncias(matricula).setVisible(true);
    }//GEN-LAST:event_jMenuMinDenActionPerformed
    
     /**
     * abre a tela inicial novamente e fecha a tela atual
     */
    
    private void opcoesDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcoesDeslogarActionPerformed
        new TelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_opcoesDeslogarActionPerformed
    
     /**
     * Fecha o programa
     */
    
    private void opcoesSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcoesSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_opcoesSairActionPerformed
    
     /**
     * checa se o usuario é administrador e se for abre a tela de criar admins
     */
    
    private void criarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarAdminActionPerformed
        if(Admin==true){
            new CriarAdmin().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"Você não é administrador");
        }
    }//GEN-LAST:event_criarAdminActionPerformed
    
     /**
     * abre a tela de selecionar professores
     */
    
    private void jMenuAvaliaProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAvaliaProfActionPerformed
        new SelecionarProfessor(matricula).setVisible(true);
    }//GEN-LAST:event_jMenuAvaliaProfActionPerformed
    
    
     /**
     * abre a tela de ranking de turmas
     */
    
    private void jMenuRankTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRankTurmasActionPerformed
        new RankTurmas(matricula).setVisible(true);
    }//GEN-LAST:event_jMenuRankTurmasActionPerformed
    
    /**
     * abre a tela de ranking de Professores
     */
    
    private void jMenuRankProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRankProfActionPerformed
        new RankProf(matricula).setVisible(true);
    }//GEN-LAST:event_jMenuRankProfActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicialAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem criarAdmin;
    private javax.swing.JMenu jMenuAdmin;
    private javax.swing.JMenuItem jMenuAvaliaDenun;
    private javax.swing.JMenuItem jMenuAvaliaProf;
    private javax.swing.JMenuItem jMenuAvaliaTurma;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuMeusDados;
    private javax.swing.JMenuItem jMenuMinAval;
    private javax.swing.JMenuItem jMenuMinDen;
    private javax.swing.JMenu jMenuOpcoes;
    private javax.swing.JMenu jMenuPerfil;
    private javax.swing.JMenu jMenuProf;
    private javax.swing.JMenuItem jMenuRankProf;
    private javax.swing.JMenuItem jMenuRankTurmas;
    private javax.swing.JMenu jMenuTurma;
    private javax.swing.JMenuItem opcoesDeslogar;
    private javax.swing.JMenuItem opcoesSair;
    // End of variables declaration//GEN-END:variables
}
