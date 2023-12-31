/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author jplim
 */
public class AlterarDadosAluno extends javax.swing.JFrame {

    String matricula;
    Connection con;
    String path;
    TelaInicialAluno Tela;
    public AlterarDadosAluno() {
        initComponents();
    }
    
    /**
      Inicia a tela pegando como atributo uma string com a matricula do usuario,tem uma string vazia que pode servir
      * de path para escolher uma img do pc e um array de bits para pegar a foto de perfil no banco de dados se existir
      * Utilizando a matricula e feito uma query que pega os dados do aluno do Banco de dados e colocar nos itens 
      * necessarios da tela
     */
    public AlterarDadosAluno(String Matricula) {
        initComponents();
        matricula=Matricula;
        path="";
        byte[] imageB = null;
        
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
            PreparedStatement ps = con.prepareStatement("select * from Aluno where matricula = ?");
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();
            if(rs.next()==true){
                emailTf.setText(rs.getString(2));
                nomeTF.setText(rs.getString(3));
                senhaTF.setText(rs.getString(4));
                cursoTF.setText(rs.getString(5));
                
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
        EmailLB = new java.awt.Label();
        nomeLB = new java.awt.Label();
        senhaLB = new java.awt.Label();
        emailTf = new javax.swing.JTextField();
        nomeTF = new javax.swing.JTextField();
        senhaTF = new javax.swing.JPasswordField();
        btEsclImg = new javax.swing.JButton();
        jImagem = new javax.swing.JLabel();
        confBT = new javax.swing.JButton();
        canTB = new javax.swing.JButton();
        jCurso = new javax.swing.JLabel();
        cursoTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Alterar Dados");

        EmailLB.setText("Email:");

        nomeLB.setText("Nome:");

        senhaLB.setText("Senha:");

        btEsclImg.setText("Escolher foto de perfil");
        btEsclImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEsclImgActionPerformed(evt);
            }
        });

        confBT.setText("Confimar");
        confBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confBTActionPerformed(evt);
            }
        });

        canTB.setText("Cancelar");
        canTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canTBActionPerformed(evt);
            }
        });

        jCurso.setForeground(new java.awt.Color(0, 0, 0));
        jCurso.setText("Curso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senhaLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeTF)
                            .addComponent(senhaTF)
                            .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCurso)
                        .addGap(18, 18, 18)
                        .addComponent(cursoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEsclImg))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(canTB)
                        .addGap(69, 69, 69)
                        .addComponent(confBT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senhaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCurso)
                            .addComponent(cursoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEsclImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(canTB)
                    .addComponent(confBT))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Metodo para o usuario escolher uma nova imagem de perfil ao apertar o botão,ele guarda o path da imagem e coloca
     * a imagem escolhida no local adequado da tela
     */
    private void btEsclImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEsclImgActionPerformed
        JFileChooser Ifile = new JFileChooser();
        Ifile.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.Image","jpeg","png","jpg");
        Ifile.addChoosableFileFilter(filtro);

        int result = Ifile.showSaveDialog(null);
        File selectFile = Ifile.getSelectedFile();
        String filename = selectFile.getName();

        if(filename.endsWith("jpeg")||filename.endsWith("JPEG")||filename.endsWith("png")||filename.endsWith("PNG")||filename.endsWith("jpg")||filename.endsWith("JPG")){
            if(result==JFileChooser.APPROVE_OPTION){
                path = selectFile.getAbsolutePath();

                ImageIcon myImage= new ImageIcon(path);
                Image img = myImage.getImage();
                Image newImage = img.getScaledInstance(jImagem.getWidth(),jImagem.getHeight(),Image.SCALE_SMOOTH);

                ImageIcon image = new ImageIcon(newImage);
                jImagem.setIcon(image);

            };
        }
        else{
            JOptionPane.showMessageDialog(this,"Formato invalido","Tente Novamente",1);
        };
    }//GEN-LAST:event_btEsclImgActionPerformed
    
    /**
     * botão de cancelamento,apenas fecha a tela atual
     */
    private void canTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canTBActionPerformed
        this.dispose();
    }//GEN-LAST:event_canTBActionPerformed
    
    /**
     * Ao apertar o botão ,os dados são pegos da tela,e usados para dar update no banco de dados
     */
    private void confBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confBTActionPerformed
        String Email = emailTf.getText();
        String Nome = nomeTF.getText();
        String Senha = senhaTF.getText();
        String Curso = cursoTF.getText();
        
        try {
            if(!path.equals("")){
                FileInputStream fis= new FileInputStream(path);
                PreparedStatement ps =con.prepareStatement("update Aluno set email = ? ,nome= ? ,senha = ? ,curso = ? ,foto_perfil = ? where Aluno.matricula=?");
                ps.setString(1, Email);
                ps.setString(2, Nome);
                ps.setString(3, Senha);
                ps.setString(4, Curso);
                ps.setBinaryStream(5, fis);
                ps.setString(6, matricula);
                ps.executeUpdate();
            }
            else{
                PreparedStatement ps =con.prepareStatement("update Aluno set email = ? , nome= ? ,senha = ? , curso = ? where Aluno.matricula=?");
                ps.setString(1, Email);
                ps.setString(2, Nome);
                ps.setString(3, Senha);
                ps.setString(4, Curso);
                ps.setString(5, matricula);
                ps.executeUpdate();
            }
            
            this.dispose();
            
            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confBTActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarDadosAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarDadosAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarDadosAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarDadosAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarDadosAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label EmailLB;
    private javax.swing.JButton btEsclImg;
    private javax.swing.JButton canTB;
    private javax.swing.JButton confBT;
    private javax.swing.JTextField cursoTF;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel jCurso;
    private javax.swing.JLabel jImagem;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label nomeLB;
    private javax.swing.JTextField nomeTF;
    private java.awt.Label senhaLB;
    private javax.swing.JPasswordField senhaTF;
    // End of variables declaration//GEN-END:variables
}
