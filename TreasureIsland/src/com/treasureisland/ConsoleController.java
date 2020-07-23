//package com.treasureisland;
//
//import com.treasureisland.player.Player;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ConsoleController {
//    Player player = Player.getInstance();
//    TreasureIslandGameplay treasureIslandGameplay = TreasureIslandGameplay.getInstance();
//
//        JFrame window;
//        Container container;
//        JPanel titleNamePanel, gamePanel, mainTextPanel;
//        JLabel titleLabel;
//        JTextArea mainTextArea;
//        Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);
//
//
//        TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
//        public ConsoleController() {
//            window = new JFrame();
//            window.setSize(1000, 600);
//            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            window.getContentPane().setBackground(Color.black);
//            window.setLayout(null);
////            window.setVisible(true);
////            container = window.getContentPane();
//
//            titleNamePanel = new JPanel();
//            titleNamePanel.setBounds(300, 50, 400, 150);
//            titleNamePanel.setBackground(Color.black);
//            titleLabel = new JLabel("Treasure Island");
//            titleLabel.setForeground(Color.white);
//            titleLabel.setFont(titleFont);
//            titleNamePanel.add(titleLabel);
//            window.add(titleNamePanel);
//            gamePanel = new JPanel();
//            gamePanel.setBounds(100, 200, 800, 300);
//            gamePanel.setBackground(Color.blue);
//            window.add(gamePanel);
//
//
//
//            window.setVisible(true);
//        }
//
//        public void createGameScreen(){
//            mainTextPanel = new JPanel();
//            mainTextPanel.setBounds(100, 100, 600, 250);
//            mainTextPanel.setBackground(Color.blue);
//            window.add(mainTextPanel);
//
//            mainTextArea = new JTextArea();
//            mainTextArea.setBounds(100, 100, 600, 250);
//            mainTextArea.setBackground(Color.black);
//            mainTextArea.setForeground(Color.white);
//            mainTextArea.setFont(titleFont);
//            mainTextArea.setLineWrap(true);
//            mainTextPanel.add(mainTextArea);
//        }
//
//        public class TitleScreenHandler implements ActionListener{
//            public void actionPerformed(ActionEvent event){
//
//            }
//        }
//
//
//
//}
