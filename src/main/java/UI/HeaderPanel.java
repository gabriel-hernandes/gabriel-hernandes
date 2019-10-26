package UI;

import BO.ValidarUsuarioBO;
import Constants.UIConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class HeaderPanel extends JPanel{

    MainFrame mainFrame;
    JPanel loginBox;
    JPanel cadastroBox;
    JPanel informationBox;
    JButton loginButton;
    JTextField textFieldLogin;
    JTextField textFieldPassWord;
    JLabel informationLanbel;
    ValidarUsuarioBO validausuario;

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getLoginBox() {
        return loginBox;
    }

    public void setLoginBox(JPanel loginBox) {
        this.loginBox = loginBox;
    }

    public JPanel getCadastroBox() {
        return cadastroBox;
    }

    public void setCadastroBox(JPanel cadastroBox) {
        this.cadastroBox = cadastroBox;
    }

    public JPanel getInformationBox() {
        return informationBox;
    }

    public void setInformationBox(JPanel informationBox) {
        this.informationBox = informationBox;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getTextFieldLogin() {
        return textFieldLogin;
    }

    public void setTextFieldLogin(JTextField textFieldLogin) {
        this.textFieldLogin = textFieldLogin;
    }

    public JTextField getTextFieldPassWord() {
        return textFieldPassWord;
    }

    public void setTextFieldPassWord(JTextField textFieldPassWord) {
        this.textFieldPassWord = textFieldPassWord;
    }

    public JLabel getInformationLanbel() {
        return informationLanbel;
    }

    public void setInformationLanbel(JLabel informationLanbel) {
        this.informationLanbel = informationLanbel;
    }

    public ValidarUsuarioBO getValidausuario() {
        return validausuario;
    }

    public void setValidausuario(ValidarUsuarioBO validausuario) {
        this.validausuario = validausuario;
    }

    HeaderPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.HEADER_PANEL_LARGURA,UIConstants.HEADER_PANEL_ALTURA));
        creatInformationBox();
        //Interações do Cadastro
        createCadastroBox();
        //Interações do Login
        createLoginBox();
        botaoLoginAction();
    }

    void creatInformationBox(){
        informationBox = new JPanel();
        informationBox.setPreferredSize(new Dimension(UIConstants.INFORMATIONBOX_PANEL_LARGURA,UIConstants.INFORMATIONBOX_PANEL_ALTURA));
        informationBox.setLayout(null);
        informationLanbel = new JLabel();
        informationLanbel.setText(UIConstants.MENSAGEM_SOLICITANDO_LOGIN);
        informationLanbel.setBounds(10,8,300,20);
        informationBox.add(informationLanbel);
        add(informationBox,BorderLayout.WEST);
    }

    void createCadastroBox(){
        cadastroBox = new JPanel();
        cadastroBox.setLayout(new BoxLayout(cadastroBox, BoxLayout.X_AXIS));
        cadastroBox.setPreferredSize(new Dimension(UIConstants.CADASTROBOX_PANEL_LARGURA, UIConstants.CADASTROBOX_PANEL_ALTURA));
        add(cadastroBox);
    }

    void createLoginBox(){
        loginBox = new JPanel();
        loginBox.setPreferredSize(new Dimension(UIConstants.LOGINBOX_PANEL_LARGURA,UIConstants.LOGINBOX_PANEL_ALTURA));
        textFieldLogin = new JTextField(UIConstants.DEFFAULT_USUARIO_TEXTBOX);
        textFieldLogin.setPreferredSize(new Dimension(100,25));
        textFieldPassWord = new JTextField(UIConstants.DEFFAULT_SENHA_TEXTBOX);
        textFieldPassWord.setPreferredSize(new Dimension(100,25));
        loginButton = new JButton(UIConstants.BOTAO_LOGIN_TEXT);
        loginBox.add(textFieldLogin);
        loginBox.add(textFieldPassWord);
        loginBox.add(loginButton);

        add(loginBox, BorderLayout.EAST);
    }

    void abrirPopup(String mensagem){
        //Popup de aviso de login
        JFrame popUp = new JFrame();
        popUp.setTitle(UIConstants.POPUP_FRAME_TITULO);
        popUp.setPreferredSize(new Dimension(300,150));
        popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.LOGOTIPO_SISTEMA_ICONE));
            ImageIcon logoicon = new ImageIcon(image);
            popUp.setIconImage(logoicon.getImage());
        }catch(IOException e){ e.printStackTrace();}
        popUp.setVisible(true);
        popUp.setLocationRelativeTo(null);
        JPanel painelAviso = new JPanel(new GridBagLayout());
        painelAviso.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), UIConstants.POPUP_PANEL_TITULO));
        JLabel aviso = new JLabel();
        aviso.setText(mensagem);
        painelAviso.add(aviso);
        popUp.add(painelAviso, BorderLayout.CENTER);
        popUp.pack();
    }

    void botaoLoginAction(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldLogin.getText();
                String senha = textFieldPassWord.getText();
                if(usuario.isEmpty()|| usuario.equalsIgnoreCase(UIConstants.DEFFAULT_USUARIO_TEXTBOX)){
                    abrirPopup(UIConstants.AVISO_USUARIO_NAO_INFORMADO);
                }else if(senha.isEmpty() || senha.equalsIgnoreCase(UIConstants.DEFFAULT_SENHA_TEXTBOX)){
                    abrirPopup(UIConstants.AVISO_SENHA_NAO_INFORMADO);
                }else {
                    validausuario = new ValidarUsuarioBO();
                    String result = validausuario.validarUsuario(usuario, senha);
                    if (validausuario.getValidado()) {
                        abrirPopup(result);
                    } else {
                        abrirPopup(result);
                    }
                }
            }
        });
    }
}
