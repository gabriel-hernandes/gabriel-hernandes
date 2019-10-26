package UI;

import Constants.UIConstants;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    GridBagConstraints constraints = null;
    JButton bt1,bt2,bt3;
    ImageIcon imagemBotao;

    MainPanel(GridBagLayout layoutManager){
        super(layoutManager);
        constraints = new GridBagConstraints();
        setPreferredSize(new Dimension(UIConstants.MAIN_PANEL_LARGURA,UIConstants.MAIN_PANEL_ALTURA));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEtchedBorder());
        JLabel label = new JLabel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(label);
        bt2 = new JButton("TESTE2");
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(bt2, constraints);
        bt3 = new JButton("TESTE3");
        constraints.gridx = 2;
        constraints.gridy = 0;
        this.add(bt3, constraints);

    }
}
