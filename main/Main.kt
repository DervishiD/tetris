package main

import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JFrame.MAXIMIZED_BOTH
import javax.swing.JFrame
import display.ScreenManager

public val mainFrame : JFrame = JFrame()

public fun main(args : Array<String>){
    init()
}

private fun init(){
    initMainFrame()
    launchProgram()
}

private fun initMainFrame(){
    mainFrame.defaultCloseOperation = EXIT_ON_CLOSE
    mainFrame.isResizable = false
    mainFrame.layout = null
    mainFrame.extendedState = MAXIMIZED_BOTH
    mainFrame.isUndecorated = true
    mainFrame.addKeyListener(GameKeyListener())
    mainFrame.isVisible = true
    mainFrame.requestFocus()
}

private fun launchProgram(){
    ScreenManager.start()
    startTimer()
}





