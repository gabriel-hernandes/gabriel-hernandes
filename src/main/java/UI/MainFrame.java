package UI;

import Constants.UIConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //Paineis Utilizados
    MainPanel mainPanel = null;
    HeaderPanel headerPanel = null;
    RodapePanel rodapePanel = null;

    MainFrame(){
        //Inicia o frame principal com o nome do sistema
        setTitle(UIConstants.TITULO_SISTEMA_DE_CONTROLE);
        //Indicando tamanho do Frame
        setPreferredSize(new Dimension(UIConstants.FRAME_LARGURA,UIConstants.FRAME_ALTURA));
        //Instanciando dump de memoria ao fechar o programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        headerPanel = new HeaderPanel();
        getContentPane().add(headerPanel, BorderLayout.NORTH);

        mainPanel = new MainPanel(new GridBagLayout());
        getContentPane().add(mainPanel,BorderLayout.CENTER);

        rodapePanel = new RodapePanel();
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);

        //Iniciando tela de Login
        telaDeLogin();

        //Configurações de vizualização
        pack();
        setLocationRelativeTo(null);
//        setResizable(false)
        setVisible(true);

    }

    void telaDeLogin(){
        //Implementação de tela de Login

    }
}