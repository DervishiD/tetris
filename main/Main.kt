package main

import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JFrame.MAXIMIZED_BOTH
import javax.swing.JFrame
import manager.ScreenManager

public val mainFrame : MainFrame = MainFrame();

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
    mainFrame.getContentPane().setBackground(RED);
    mainFrame.setVisible(true);
}

private fun launchProgram(){
    ScreenManager.start();
    startTimer();
}

public class MainFrame : JFrame(){}





