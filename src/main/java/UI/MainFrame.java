package UI;

import Constants.UIConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFrame extends JFrame {

    //Paineis Utilizados
    public MainPanel mainPanel = null;
    public HeaderPanel headerPanel = null;
    public RodapePanel rodapePanel = null;
    public ImageIcon logoicon = null;

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public RodapePanel getRodapePanel() {
        return rodapePanel;
    }

    public void setRodapePanel(RodapePanel rodapePanel) {
        this.rodapePanel = rodapePanel;
    }

    public ImageIcon getLogoicon() {
        return logoicon;
    }

    public void setLogoicon(ImageIcon logoicon) {
        this.logoicon = logoicon;
    }

    public MainFrame() {
        //Inicia o frame principal com o nome do sistema
        setTitle(UIConstants.TITULO_SISTEMA_DE_CONTROLE);
        //Indicando tamanho do Frame
        setPreferredSize(new Dimension(UIConstants.FRAME_LARGURA, UIConstants.FRAME_ALTURA));
        //Instanciando dump de memoria ao fechar o programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.LOGOTIPO_SISTEMA_ICONE));
            logoicon = new ImageIcon(image);
            this.setIconImage(logoicon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Iniciando tela de Login
        telaDeLogin(this);
        //Configurações de vizualização
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void telaDeLogin(MainFrame mainFrame) {
        //Implementação de tela de Login
        headerPanel = new HeaderPanel(mainFrame);
        getContentPane().add(headerPanel, BorderLayout.NORTH);
        mainPanel = new MainPanel(mainFrame, new GridBagLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        rodapePanel = new RodapePanel(mainFrame);
        getContentPane().add(rodapePanel, BorderLayout.SOUTH);
    }
}
