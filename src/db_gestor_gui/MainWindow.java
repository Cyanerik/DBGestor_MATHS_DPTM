package db_gestor_gui;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    
    private JPanel mainPanel;
    private JPanel functionPanel;
    
    
    
    private void createMainWindow()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        Long mehH = (Math.round(d.height * 0.85));
        Long mehW = Math.round(d.width * 0.85);
        
        int nHEIGHT = mehH.intValue();
        int nWIDTH = mehW.intValue();
        
        Long dHEIGHT = Math.round((d.height * 0.15) / 2);
        Long dWIDTH = Math.round((d.width * 0.15) / 2);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.setBounds(dWIDTH.intValue(), dHEIGHT.intValue(), nWIDTH, nHEIGHT);
        
        functionPanel = new JPanel(new BorderLayout());
        functionPanel.setPreferredSize(new Dimension(nWIDTH/5, nHEIGHT));
        functionPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        functionPanel.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
        functionPanel.setBackground(Color.WHITE);
        this.add(functionPanel, BorderLayout.LINE_END);
        
        
        
        JPanel fs = new JPanel();
        JLabel ft = new JLabel ("<html><u>Functions</u></html>");
        fs.add(ft, BorderLayout.LINE_END);
        fs.setBackground(Color.WHITE);
        functionPanel.add(fs);
    }
    
    
    public MainWindow()
    {
        this.createMainWindow();
        this.setVisible(true);
    }
}
