package UI;

import BO.HeaderButtonsAction;
import BO.ObterNomeUsuarioBO;
import BO.ValidarUsuarioBO;
import Constants.UIConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class HeaderPanel extends JPanel{

    MainFrame mainFrame;
    JPanel loginBox;
    JPanel cadastroBox;
    JPanel informationBox;
    JPanel usuarioLogadoBox;
    JPanel buttonMenuBox;
    JButton loginButton;
    JButton botaoCadastrarMotorista;
    JButton botaoCadastrarVeiculo;
    JButton botaoCadastrarPeça;
    JButton botaoRelatorios;
    JTextField textFieldLogin;
    JPasswordField textFieldPassWord;
    JLabel informationLanbel;
    JLabel nomeUsuarioLabel;
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

    public JPanel getUsuarioLogadoBox() {
        return usuarioLogadoBox;
    }

    public void setUsuarioLogadoBox(JPanel usuarioLogadoBox) {
        this.usuarioLogadoBox = usuarioLogadoBox;
    }

    public JPanel getButtonMenuBox() {
        return buttonMenuBox;
    }

    public void setButtonMenuBox(JPanel buttonMenuBox) {
        this.buttonMenuBox = buttonMenuBox;
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

    public JPasswordField getTextFieldPassWord() {
        return textFieldPassWord;
    }

    public void setTextFieldPassWord(JPasswordField textFieldPassWord) {
        this.textFieldPassWord = textFieldPassWord;
    }

    public JLabel getNomeUsuarioLabel() {
        return nomeUsuarioLabel;
    }

    public void setNomeUsuarioLabel(JLabel nomeUsuarioLabel) {
        this.nomeUsuarioLabel = nomeUsuarioLabel;
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

    public HeaderButtonsAction getBotoes() {
        return botoes;
    }

    public void setBotoes(HeaderButtonsAction botoes) {
        this.botoes = botoes;
    }

    HeaderButtonsAction botoes;



    public HeaderPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        buildHederPanelPaginaInicial();
    }

    public void criarMenuInicial(String usuario){
        remove(loginBox);
        createUsuarioLogadoBox(usuario);
        createButtonMenuBox();
        repaint();
        revalidate();
    }

    public void createButtonMenuBox(){
        remove(informationBox);
        buttonMenuBox = new JPanel();
        GridBagConstraints constraints = new GridBagConstraints();
        criarBotoesMenu();
        add(buttonMenuBox, BorderLayout.WEST);
        repaint();
        revalidate();
    }

    public void criarBotoesMenu(){
        botaoCadastrarMotorista = new JButton();
        ImageIcon imagemBotaoCadastrarMotorista;
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.BOTAO_CADASTRAR_MOTORISTA));
            imagemBotaoCadastrarMotorista = new ImageIcon(image);
            botaoCadastrarMotorista.setIcon(imagemBotaoCadastrarMotorista);
            botaoCadastrarMotorista.setMargin(new Insets(0, 0, 0, 0));
            botaoCadastrarMotorista.setBorder(null);
            buttonMenuBox.add(botaoCadastrarMotorista);
        }catch(IOException e){ e.printStackTrace();}
        botaoCadastrarVeiculo = new JButton();
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.BOTAO_CADASTRAR_VEICULO));
            imagemBotaoCadastrarMotorista = new ImageIcon(image);
            botaoCadastrarVeiculo.setIcon(imagemBotaoCadastrarMotorista);
            botaoCadastrarVeiculo.setMargin(new Insets(0, 0, 0, 0));
            botaoCadastrarVeiculo.setBorder(null);
            buttonMenuBox.add(botaoCadastrarVeiculo);
        }catch(IOException e){ e.printStackTrace();}
        botaoCadastrarPeça = new JButton();
        botaoRelatorios = new JButton();
    }

    public void createUsuarioLogadoBox(String usuario){
        usuarioLogadoBox = new JPanel();
        usuarioLogadoBox.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        loginBox.setPreferredSize(new Dimension(UIConstants.LOGINBOX_PANEL_LARGURA,UIConstants.LOGINBOX_PANEL_ALTURA));
        ObterNomeUsuarioBO obterNomeUsuarioBO = new ObterNomeUsuarioBO();
        String nomeUsuario = obterNomeUsuarioBO.obterNomeUsuario(usuario);
        nomeUsuarioLabel = new JLabel();
        nomeUsuarioLabel.setText(UIConstants.NOME_USUARIO_LABEL + nomeUsuario);
        usuarioLogadoBox.add(nomeUsuarioLabel, constraints);
        add(usuarioLogadoBox, BorderLayout.EAST);
    }

    public void buildHederPanelPaginaInicial(){
        this.setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.HEADER_PANEL_LARGURA,UIConstants.HEADER_PANEL_ALTURA));
        creatInformationBox();
        //Interações do Cadastro
        createCadastroBox();
        //Interações do Login
        createLoginBox();
        botoes = new HeaderButtonsAction(mainFrame);
        botoes.botaoLoginAction(loginButton);
    }

    public void creatInformationBox(){
        informationBox = new JPanel();
        informationBox.setPreferredSize(new Dimension(UIConstants.INFORMATIONBOX_PANEL_LARGURA,UIConstants.INFORMATIONBOX_PANEL_ALTURA));
        informationBox.setLayout(null);
        informationLanbel = new JLabel();
        informationLanbel.setText(UIConstants.MENSAGEM_SOLICITANDO_LOGIN);
        informationLanbel.setBounds(10,8,300,20);
        informationBox.add(informationLanbel);
        add(informationBox,BorderLayout.WEST);
    }

    public void createCadastroBox(){
        cadastroBox = new JPanel();
        cadastroBox.setLayout(new BoxLayout(cadastroBox, BoxLayout.X_AXIS));
        cadastroBox.setPreferredSize(new Dimension(UIConstants.CADASTROBOX_PANEL_LARGURA, UIConstants.CADASTROBOX_PANEL_ALTURA));
        add(cadastroBox);
    }

    public void createLoginBox(){
        loginBox = new JPanel();
        loginBox.setPreferredSize(new Dimension(UIConstants.LOGINBOX_PANEL_LARGURA,UIConstants.LOGINBOX_PANEL_ALTURA));
        textFieldLogin = new JTextField(UIConstants.DEFFAULT_USUARIO_TEXTBOX);
        textFieldLogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldLogin.setText("");
            }
        });
        textFieldLogin.setPreferredSize(new Dimension(100,25));
        textFieldPassWord = new JPasswordField(UIConstants.DEFFAULT_SENHA_TEXTBOX);
        textFieldPassWord.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldPassWord.setText("");
            }
        });
        textFieldPassWord.setPreferredSize(new Dimension(100,25));
        loginButton = new JButton(UIConstants.BOTAO_LOGIN_TEXT);
        loginBox.add(textFieldLogin);
        loginBox.add(textFieldPassWord);
        loginBox.add(loginButton);

        add(loginBox, BorderLayout.EAST);
    }

    public void abrirPopup(String mensagem){
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
}
