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

    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            mainMenu miProjectGUI = new mainMenu();
        });
    }
}