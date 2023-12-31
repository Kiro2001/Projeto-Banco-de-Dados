/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobancodados;

import java.awt.Image;
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
public class CadastrarAluno extends javax.swing.JFrame {

    Connection con;
    String path;
    
    /**
     * Cria a tela e inicia argumentos que serão usados depois
     */
    public CadastrarAluno() {
        initComponents();
        path="";
        try {
            con =DriverManager.getConnection("jdbc:mysql://localhost/avaliacao_turma","root","");
           
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

        emailTf = new javax.swing.JTextField();
        nomeTF = new javax.swing.JTextField();
        senhaTF = new javax.swing.JPasswordField();
        EmailLB = new java.awt.Label();
        nomeLB = new java.awt.Label();
        senhaLB = new java.awt.Label();
        confBT = new javax.swing.JButton();
        canTB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btEsclImg = new javax.swing.JButton();
        jImagem = new javax.swing.JLabel();
        MatriculaLB = new javax.swing.JLabel();
        matriculaTF = new javax.swing.JTextField();
        cursoLB = new javax.swing.JLabel();
        cursoTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        EmailLB.setText("Email:");

        nomeLB.setText("Nome:");

        senhaLB.setText("Senha:");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Cadastro");

        btEsclImg.setText("Escolher foto de perfil");
        btEsclImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEsclImgActionPerformed(evt);
            }
        });

        MatriculaLB.setForeground(new java.awt.Color(0, 0, 0));
        MatriculaLB.setText("Matricula:");

        cursoLB.setForeground(new java.awt.Color(0, 0, 0));
        cursoLB.setText("Curso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(canTB)
                .addGap(78, 78, 78)
                .addComponent(confBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MatriculaLB)
                            .addComponent(EmailLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cursoLB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeTF)
                            .addComponent(senhaTF)
                            .addComponent(emailTf, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(matriculaTF)
                            .addComponent(cursoTF))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEsclImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEsclImg))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MatriculaLB)
                            .addComponent(matriculaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senhaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaLB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cursoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cursoLB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confBT)
                    .addComponent(canTB))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Fecha a tela ao apertar o botão de cancelar
     */
    private void canTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canTBActionPerformed
        this.dispose();
    }//GEN-LAST:event_canTBActionPerformed
    
    
    /**
     * Cria e armazena no Banco de dados Dados sobre o Aluno usando os dados da tela, também tem um check se a 
     * matricula é constuida de números e tem exatamente 9 digitos,alem de checar se ela ja existe no banco 
     */
    private void confBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confBTActionPerformed
        String Matricula = matriculaTF.getText();
        String Email = emailTf.getText();
        String Nome = nomeTF.getText();
        String Senha = senhaTF.getText();
        String Curso = cursoTF.getText();
        String Admin="0";
        FileInputStream fis = null;
        boolean Unico=true;
        
        try {
            if(Matricula.matches("[0-9]+") && Matricula.length() == 9){
                PreparedStatement ps0 =con.prepareStatement("select matricula from Aluno");
                ResultSet rs0=ps0.executeQuery();
                
                while(rs0.next()==true){
                    if(rs0.getString(1).equals(Matricula)){
                        Unico=false;
                        break;
                    }
                }
                
                if(Unico==true){
                    if(!path.equals("")){
                    fis= new FileInputStream(path);
                    PreparedStatement ps =con.prepareStatement("insert into Aluno values (?,?,?,?,?,?,?) ");
                    ps.setString(1, Matricula);
                    ps.setString(2, Email);
                    ps.setString(3, Nome);
                    ps.setString(4, Senha);
                    ps.setString(5, Curso);
                    ps.setString(6, Admin);
                    ps.setBinaryStream(7, fis);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Inserido com Sucesso","Sucesso",1);
                    this.dispose();
                    }
                    else{
                        PreparedStatement ps =con.prepareStatement("insert into Aluno (matricula,email,nome,senha,curso,adminT) values (?,?,?,?,?,?) ");
                        ps.setString(1, Matricula);
                        ps.setString(2, Email);
                        ps.setString(3, Nome);
                        ps.setString(4, Senha);
                        ps.setString(5, Curso);
                        ps.setString(6, Admin);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Inserido com Sucesso","Sucesso",1);
                        this.dispose();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "Matricula já existe","Invalido",1);
                    matriculaTF.setText("");
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Matricula invalida,a matricula deve ser apenas numeros\n e ter o exato tamanho de 9 caracteres ","Invalido",1);
                matriculaTF.setText("");
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confBTActionPerformed
    
    /**
     * Ao apertar o botão ,o usuario pode escolher a imagem de perfil,então ela é colocada na parte certa da tela e 
     * seu path é guardado
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
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label EmailLB;
    private javax.swing.JLabel MatriculaLB;
    private javax.swing.JButton btEsclImg;
    private javax.swing.JButton canTB;
    private javax.swing.JButton confBT;
    private javax.swing.JLabel cursoLB;
    private javax.swing.JTextField cursoTF;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel jImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField matriculaTF;
    private java.awt.Label nomeLB;
    private javax.swing.JTextField nomeTF;
    private java.awt.Label senhaLB;
    private javax.swing.JPasswordField senhaTF;
    // End of variables declaration//GEN-END:variables
}
