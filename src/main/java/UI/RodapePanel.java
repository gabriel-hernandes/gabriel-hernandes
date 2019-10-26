package UI;

import Constants.UIConstants;

import javax.swing.*;
import java.awt.*;

public class RodapePanel extends JPanel {

    JPanel releaseInformationbox;
    JLabel releaseInformationLabel;

    RodapePanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(UIConstants.RODAPE_PANEL_LARGURA,UIConstants.RODAPE_PANEL_ALTURA));
        createReleaseInformation();
    }

    void createReleaseInformation(){
        releaseInformationbox = new JPanel();
        releaseInformationbox.setPreferredSize(new Dimension(UIConstants.RELEASE_INFORMATION_LABEL_LARGURA,UIConstants.RELEASE_INFORMATION_LABEL_ALTURA));
        releaseInformationbox.setLayout(null);
        releaseInformationLabel = new JLabel();
        releaseInformationLabel.setText(UIConstants.VERSAO_SISTEMA_ATUAL);
        releaseInformationLabel.setBounds(10,8,300,20);
        releaseInformationbox.add(releaseInformationLabel);
        add(releaseInformationbox);
    }
}
