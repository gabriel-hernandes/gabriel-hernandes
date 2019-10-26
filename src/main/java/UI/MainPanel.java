package UI;

import Constants.UIConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class MainPanel extends JPanel {
    MainFrame mainframe;
    GridBagConstraints constraints = null;

    public MainFrame getMainframe() {
        return mainframe;
    }

    public void setMainframe(MainFrame mainframe) {
        this.mainframe = mainframe;
    }

    public GridBagConstraints getConstraints() {
        return constraints;
    }

    public void setConstraints(GridBagConstraints constraints) {
        this.constraints = constraints;
    }

    public ImageIcon getImagemBotao() {
        return imagemBotao;
    }

    public void setImagemBotao(ImageIcon imagemBotao) {
        this.imagemBotao = imagemBotao;
    }

    ImageIcon imagemBotao;

    MainPanel(MainFrame mainFrame, GridBagLayout layoutManager){
        super(layoutManager);
        this.mainframe = mainFrame;
        constraints = new GridBagConstraints();
        setPreferredSize(new Dimension(UIConstants.MAIN_PANEL_LARGURA,UIConstants.MAIN_PANEL_ALTURA));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEtchedBorder());
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(UIConstants.LOGOTIPO_SISTEMA));
            imagemBotao = new ImageIcon(image);
        }catch(IOException e){ e.printStackTrace();}
        JLabel label = new JLabel(imagemBotao);
        this.add(label);

    }
}
