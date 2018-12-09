package main

import javax.swing.JFrame.EXIT_ON_CLOSE
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
    mainFrame.setSize(FRAMEX, FRAMEY);
    mainFrame.setResizable(false);
    mainFrame.setLayout(null);
    mainFrame.getContentPane().setBackground(java.awt.Color(255, 0, 0));
    mainFrame.setVisible(true);
}

private fun launchProgram(){
    ScreenManager.start();
    startTimer();
}

public class MainFrame : JFrame(){}





