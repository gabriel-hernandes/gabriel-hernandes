package BO;

import Constants.UIConstants;
import UI.HeaderPanel;
import UI.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderButtonsAction {
    MainFrame mainFrame;

    public HeaderButtonsAction(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void botaoLoginAction(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = mainFrame.headerPanel.getTextFieldLogin().getText();
                String senha = mainFrame.headerPanel.getTextFieldPassWord().getText();
                if(usuario.isEmpty()|| usuario.equalsIgnoreCase(UIConstants.DEFFAULT_USUARIO_TEXTBOX)){
                    mainFrame.headerPanel.abrirPopup(UIConstants.AVISO_USUARIO_NAO_INFORMADO);
                }else if(senha.isEmpty() || senha.equalsIgnoreCase(UIConstants.DEFFAULT_SENHA_TEXTBOX)){
                    mainFrame.headerPanel.abrirPopup(UIConstants.AVISO_SENHA_NAO_INFORMADO);
                }else {
                    ValidarUsuarioBO validarUsuarioBO = new ValidarUsuarioBO();
                    String result = validarUsuarioBO.validarUsuario(usuario, senha);
                    if (validarUsuarioBO.isValidado()) {
                        mainFrame.headerPanel.abrirPopup(result);
                        mainFrame.headerPanel.criarMenuInicial(usuario);
                        mainFrame.mainPanel.criarMenuInicial();
                    } else {
                        mainFrame.headerPanel.abrirPopup(result);
                    }
                }
            }
        });
    }
}
