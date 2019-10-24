package UI

import Constants.UIConstants

import javax.swing.JButton
import javax.swing.JPanel
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout

class RodapePanel extends JPanel{

    GridBagConstraints constraints = null

    RodapePanel(GridBagLayout layoutManager){
        super(layoutManager)
        constraints = new GridBagConstraints()
        setPreferredSize(new Dimension(UIConstants.RODAPE_PANEL_LARGURA,UIConstants.RODAPE_PANEL_ALTURA))
        JButton bt = new JButton("RODAPE")
        add(bt)
    }
}
