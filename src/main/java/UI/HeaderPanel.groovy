package UI

import BO.ValidarUsuarioBO
import Constants.UIConstants
import DAO.ValidarUsuarioDAO

import javax.swing.BorderFactory
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextArea
import javax.swing.JTextField
import java.awt.BorderLayout
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class HeaderPanel extends JPanel{

    JPanel loginBox
    JButton loginButton
    JTextField textFieldLogin
    JTextField textFieldPassWord
    ValidarUsuarioBO validausuario
    GridBagConstraints constraints

    HeaderPanel(){
        setLayout(new BorderLayout())
        setPreferredSize(new Dimension(UIConstants.HEADER_PANEL_LARGURA,UIConstants.HEADER_PANEL_ALTURA))

        //Interações do Login
        createLoginBox()
        botaoLoginAction()

        //Interações do Cadastro
        createCadastroBox()

    }

    void createCadastroBox(){

    }

    void createLoginBox(){
        loginBox = new JPanel()
        loginBox.setPreferredSize(new Dimension(UIConstants.LOGINBOX_PANEL_LARGURA,UIConstants.LOGINBOX_PANEL_ALTURA))
        loginBox.setBorder(BorderFactory.createEtchedBorder())
        textFieldLogin = new JTextField("Usuario")
        textFieldLogin.setPreferredSize(new Dimension(100,25))
        textFieldPassWord = new JTextField("Senha")
        textFieldPassWord.setPreferredSize(new Dimension(100,25))
        loginButton = new JButton("Login")
        loginBox.add(textFieldLogin)
        loginBox.add(textFieldPassWord)
        loginBox.add(loginButton)

        add(loginBox, BorderLayout.EAST)
    }

    void abrirPopup(String mensagem){
        //Popup de aviso de login
        JFrame popUp = new JFrame()
        popUp.setTitle("AVISO!")
        popUp.setPreferredSize(new Dimension(300,150))
        popUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE)
        popUp.setVisible(true)
        popUp.setLocationRelativeTo()
        JPanel painelAviso = new JPanel(new GridBagLayout())
        painelAviso.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login"))
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
                if(usuario == null){
                    abrirPopup("Favor Informar usuario!")
                }else if(senha == null){
                    abrirPopup("Favor Informar Senha!")
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
