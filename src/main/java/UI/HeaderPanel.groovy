package UI

import BO.ValidarUsuarioBO
import Constants.UIConstants
import DAO.ValidarUsuarioDAO

import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class HeaderPanel extends JPanel{

    JPanel loginBox
    JPanel cadastroBox
    JPanel informationBox
    JButton loginButton
    JButton cadastroButton
    JTextField textFieldLogin
    JTextField textFieldPassWord
    JLabel informationLanbel
    ValidarUsuarioBO validausuario
    GridBagConstraints constraints

    HeaderPanel(){
        setLayout(new BorderLayout())
        setPreferredSize(new Dimension(UIConstants.HEADER_PANEL_LARGURA,UIConstants.HEADER_PANEL_ALTURA))

        creatInformationBox()
        //Interações do Cadastro
        createCadastroBox()
        //Interações do Login
        createLoginBox()
        botaoLoginAction()


    }

    void creatInformationBox(){
        informationBox = new JPanel()
        informationBox.setPreferredSize(new Dimension(UIConstants.INFORMATIONBOX_PANEL_LARGURA,UIConstants.INFORMATIONBOX_PANEL_ALTURA))
        informationBox.setLayout(null)
        informationLanbel = new JLabel()
        informationLanbel.setText("SCF - Favor efetuar login para iniciar o sistema")
        informationLanbel.setBounds(10,8,300,20)
        informationBox.add(informationLanbel)
        add(informationBox,BorderLayout.WEST)
    }

    void createCadastroBox(){
        cadastroBox = new JPanel()
        cadastroBox.setLayout(new BoxLayout(cadastroBox, BoxLayout.X_AXIS))
        cadastroBox.setPreferredSize(new Dimension(UIConstants.CADASTROBOX_PANEL_LARGURA, UIConstants.CADASTROBOX_PANEL_ALTURA))
//        cadastroButton = new JButton("Cadastrar")
//        cadastroButton.setAlignmentX(CENTER_ALIGNMENT)
//        cadastroBox.add(cadastroButton)
        add(cadastroBox)
    }

    void createLoginBox(){
        loginBox = new JPanel()
        loginBox.setPreferredSize(new Dimension(UIConstants.LOGINBOX_PANEL_LARGURA,UIConstants.LOGINBOX_PANEL_ALTURA))
        textFieldLogin = new JTextField(UIConstants.DEFFAULT_USUARIO_TEXTBOX)
        textFieldLogin.setPreferredSize(new Dimension(100,25))
        textFieldPassWord = new JTextField(UIConstants.DEFFAULT_SENHA_TEXTBOX)
        textFieldPassWord.setPreferredSize(new Dimension(100,25))
        loginButton = new JButton(UIConstants.BOTAO_LOGIN_TEXT)
        loginBox.add(textFieldLogin)
        loginBox.add(textFieldPassWord)
        loginBox.add(loginButton)

        add(loginBox, BorderLayout.EAST)
    }

    void abrirPopup(String mensagem){
        //Popup de aviso de login
        JFrame popUp = new JFrame()
        popUp.setTitle(UIConstants.POPUP_FRAME_TITULO)
        popUp.setPreferredSize(new Dimension(300,150))
        popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        popUp.setVisible(true)
        popUp.setLocationRelativeTo()
        JPanel painelAviso = new JPanel(new GridBagLayout())
        painelAviso.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), UIConstants.POPUP_PANEL_TITULO))
        JLabel aviso = new JLabel()
        aviso.setText(mensagem)
        painelAviso.add(aviso)
        popUp.add(painelAviso, BorderLayout.CENTER)
        popUp.pack()
    }

    void botaoLoginAction(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                String usuario = textFieldLogin.getText()
                String senha = textFieldPassWord.getText()
                if(usuario.isEmpty() || usuario.equalsIgnoreCase(UIConstants.DEFFAULT_USUARIO_TEXTBOX)){
                    abrirPopup(UIConstants.AVISO_USUARIO_NAO_INFORMADO)
                }else if(senha.isEmpty() || senha.equalsIgnoreCase(UIConstants.DEFFAULT_SENHA_TEXTBOX)){
                    abrirPopup(UIConstants.AVISO_SENHA_NAO_INFORMADO)
                }else {
                    validausuario = new ValidarUsuarioBO()
                    String result = validausuario.validarUsuario(usuario, senha)
                    if (validausuario.getValidado()) {
                        abrirPopup(result)
                    } else {
                        abrirPopup(result)
                    }
                }
            }
        })
    }
}
