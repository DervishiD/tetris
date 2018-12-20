package main

import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JFrame.MAXIMIZED_BOTH
import javax.swing.JFrame
import manager.ScreenManager

public val mainFrame : JFrame = JFrame();

public fun main(args : Array<String>){
    init();
}

private fun init(){
    initMainFrame();
    launchProgram();
}

private fun initMainFrame(){
    mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    mainFrame.setResizable(false);
    mainFrame.setLayout(null);
    mainFrame.setExtendedState(MAXIMIZED_BOTH); 
    mainFrame.setUndecorated(true);
    mainFrame.getContentPane().setBackground(RED); // IF AN ERROR OCCURS. SHOULD REMOVE IT
    mainFrame.addKeyListener(GameKeyListener());
    mainFrame.setVisible(true);
    mainFrame.requestFocus();
}

private fun launchProgram(){
    ScreenManager.start();
    startTimer();
}





