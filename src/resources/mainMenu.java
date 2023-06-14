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
    private Timer timer;
    private Timer wordTimer;
    private String name, database,file; //String name se usara para almacenar el nombre de usuario ingresado,
    //database almacenara la direccion del txt que sera utilizado para la base de dados
    //file, se almacenara la direccion del txt donde estan las palabras que se utilizaran en el programa
    private int level;
    private JButton initGame,rules,yesButton;
    private Image backgroundTest,backgroundTest2;

    private JPanel principalPanel,buttonPanel,textPanel,counterPanel,backgroundPanel,inGameBackgroundPanel;
    private JTextField playerUsername;
    private Escucha escucha;
    private int comparer=0;
    private JLabel textTimer;
    private List<String> wordsToMemorize;
    private List<String> theOtherWords;
    private List<String> selectdWords;
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
        file= new String();
        database = new String();
        name = new String();
        timer = new Timer(500, new ActionListener() {
            private int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter < wordsToMemorize.size()) {
                    String palabra = wordsToMemorize.get(counter);
                    textTimer.setText(palabra);
                    counter++;
                } else {
                    timer.stop();
                    showWordsAndValidate();
                }
            }
        });

        textTimer = new JLabel("I KNOW THAT WORD!!!");
        yesButton=new JButton("Yes");
        yesButton.setBackground(Color.green);
        yesButton.setOpaque(true);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wordTimer.isRunning()){
                    String validar = textTimer.getText();
                    if (wordsToMemorize.contains(validar)){
                        comparer++;
                        System.out.println(comparer);
                    }
                    selectdWords.add(validar);
                    System.out.println(selectdWords);
                }
            }
        });

        /*noButton=new JButton("No");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wordTimer.isRunning()){
                    System.out.println("Se presiono  No");
                }
            }
        });
        noButton.setBackground(Color.red);
        noButton.setOpaque(true);*/

        this.buttonPanel = new JPanel();
        this.textPanel = new JPanel();
        this.counterPanel= new JPanel();

        this.counterPanel.add(yesButton);

        imagePanel backgroundImage = new imagePanel("/resources/GuiFiles/mainMenuBackground.jpg");
        backgroundImage.setLayout(new BorderLayout());

        this.wordsToMemorize = new ArrayList<>();
        this.theOtherWords = new ArrayList<>();

        this.escucha = new Escucha();

        this.playerUsername = new JTextField(null,20);
        this.playerUsername.setHorizontalAlignment(JTextField.CENTER);

        this.principalPanel = new JPanel();

        this.initGame = new JButton("Iniciar Juego");
        this.initGame.addActionListener(escucha);

        this.rules = new JButton("Reglas");
        this.rules.addActionListener(escucha);

        this.buttonPanel.add(playerUsername);
        this.buttonPanel.add(initGame);
        this.buttonPanel.add(rules);

        this.backgroundPanel.setLayout(new BorderLayout());
        this.principalPanel.add(buttonPanel,BorderLayout.SOUTH);


        this.backgroundPanel.add(principalPanel,BorderLayout.SOUTH);
        getContentPane().add(backgroundPanel);

    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            mainMenu miProjectGUI = new mainMenu();
        });
    }
    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == initGame) {
                initGame();
            }
        }
    }
}