package main

import javax.swing.JFrame.EXIT_ON_CLOSE;

public val mainFrame : MainFrame = MainFrame();

public fun main(args : Array<String>){
    println("Hello World!");
    
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    mainFrame.setSize(1800, 900);
    mainFrame.setLayout(null);
    mainFrame.setVisible(true);
    
    startTimer();
    
}



