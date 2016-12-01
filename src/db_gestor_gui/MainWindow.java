package db_gestor_gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

import auxPackage.*;

public class MainWindow extends JFrame{
    
    private JPanel mainPanel;
        private JToolBar toolBar;
            private JComboBox tableSelect;
    
    private JPanel functionPanel;
    
    private int S_H, S_W; //SCREEN RESOLUTION
    private int W_H, W_W; //WINDOW RESOLUTION
    
    public void init()
    {   
        this.initPara();
        this.createMainWindow();
        this.createMainPanel();
        this.createFunctionsPanel();
        this.setVisible(true);
        
    }
    
    protected void initPara()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        W_H = Math.round(d.height * (float)0.85);
        W_W = Math.round(d.width * (float)0.85);
        
        S_H = Math.round(d.height);
        S_W = Math.round(d.width);
    }
    
    protected void createFunctionsPanel()
    {
        
        functionPanel = new JPanel(new BorderLayout());
        functionPanel.setPreferredSize(new Dimension(W_W/5, W_H));
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
    
    protected void createMainPanel()
    {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(((W_W/5)*4), W_H));
        mainPanel.setBackground(Color.red); //GETTING INFO ABOUT COMPOSITION
        this.createToolBar(Definitions.DBG_MAIN_PANEL);
        
        //TODO CREATE TABLE
        
        this.add(mainPanel, BorderLayout.LINE_START);
    }
    
    
    protected void createToolBar(int loc)
    {
        switch(loc)
        {
            case(Definitions.DBG_MAIN_PANEL):
            {
               toolBar = new JToolBar("Toolbar");
               toolBar.setFloatable(false);
               toolBar.setBackground(Color.orange); //GETTING INFO ABOUT THE COMPOSITION
               toolBar.setPreferredSize(new Dimension(mainPanel.getWidth(), 30));
               
               addButtons(toolBar, Definitions.DBG_MAIN_PANEL);
               
               mainPanel.add(toolBar, BorderLayout.PAGE_START);
               
            }break;
                
            default:break;
        }
    }
    
    protected void createMainWindow()
    {
        
        Long dHEIGHT = Math.round((S_H * 0.15) / 2);
        Long dWIDTH = Math.round((S_W * 0.15) / 2);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        this.setBounds(dWIDTH.intValue(), dHEIGHT.intValue(), W_W, W_H);
    }
    
    protected void addButtons(JToolBar toolB, int loc)
    {
       //////////////////COMBO BOX//////////////////////////
       String[] comboList = {"FAMILY DATA", "JOURNAL DATA"};
       tableSelect = new JComboBox(comboList);
       tableSelect.setSelectedIndex(0);
       tableSelect.setPreferredSize(new Dimension(mainPanel.getWidth() / 5, toolB.getHeight()));
       
       tableSelect.addActionListener(
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    tableSelect = (JComboBox)e.getSource();
                    String opt = (String)tableSelect.getSelectedItem();
                    switch(opt)
                    {
                        case("FAMILY DATA"):
                        {
                            //TODO FILL TABLE
                        }break;
                        
                        case("JOURNAL DATA"):
                        {
                            //TODO FILL TABLE
                        }break;
                        
                        default:break;
                    }
                    
                }
            }
        );
       
        toolB.add(tableSelect);
        //////////////COMBO BOX//////////////////////////////
        
        //////////////REFRESH BUTTON/////////////////////////
        
        JButton refresh = new JButton();
        
        ImageIcon image = createImageIcon("/assets/refresh.png");
        refresh.setIcon(image);
        
        //////////////REFRESH BUTTON/////////////////////////
        
        
        
        
    }
    
    protected ImageIcon createImageIcon(String path)
    {
        
        try{
            java.net.URL imgURL = getClass().getResource(path);
            if(imgURL != null)
            {
              return new ImageIcon(path);
            }
            throw new RuntimeException("Cannot find "+path);
        }catch(RuntimeException e)
        {
            path = ".." + path;
            java.net.URL imgURL = getClass().getResource("..\\../");
            System.err.println(imgURL.toString());
            if(imgURL != null)
            {
              return new ImageIcon(path);
            }
            throw new RuntimeException("Cannot find "+ path);
        }
    }
    public MainWindow(){}
}
