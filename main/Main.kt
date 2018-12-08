package main

import javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JFrame;

public val mainFrame : MainFrame = MainFrame();

public fun main(args : Array<String>){
    println("Hello World!");
    
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    mainFrame.setSize(1800, 900);
    mainFrame.setLayout(null);
    mainFrame.getContentPane().setBackground(java.awt.Color(255, 0, 0));
    mainFrame.setVisible(true);
    
    startTimer();
    
}

public class MainFrame : JFrame(){
    
}





