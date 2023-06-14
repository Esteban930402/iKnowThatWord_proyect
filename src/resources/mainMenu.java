package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used for ...
 * @autor Esteban Andres Espinosa Aragon (espinosa.esteban@correounivalle.edu.co
 *        Valentina Sanchez Rosero (valentina.sanchez.rosero@correounivalle.edu.co
 * @version v.1.0.0 date:13/0/2023
 */
public class mainMenu extends JFrame {
    private JPanel principalPanel,buttonPanel,counterPanel,backgroundPanel,inGameBackgroundPanel;
    private Image backgroundTest,backgroundTest2;
    public mainMenu(){
        initGUI();
        setIconImage(new ImageIcon(getClass().getResource("/resources/Imagen1.jpg")).getImage());
        //Default JFrame configuration
        this.setTitle("I Know That Word");
        this.setSize(1020,720);
        this.getContentPane();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initGUI(){
        backgroundPanel = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(backgroundTest!=null){
                    //int x = (getWidth()-backgroundTest.getWidth(null))/2;
                    //int y = (getHeight()-backgroundTest.getHeight(null))/2;
                    g.drawImage(backgroundTest,0,0,getWidth(),getHeight(),null);
                }

            }
        };
        backgroundPanel.setPreferredSize(new Dimension(1400,1080));

        //Creacion de hilo

        Thread hilo= new Thread(){
            @Override
            public void run(){
                try {
                    backgroundTest= ImageIO.read(getClass().getResource("/resources/12.jpg"));
                    backgroundPanel.repaint();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();

    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            mainMenu miProjectGUI = new mainMenu();
        });
    }
}