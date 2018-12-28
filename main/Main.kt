package main

import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JFrame.MAXIMIZED_BOTH
import javax.swing.JFrame
import screen.ScreenManager

/**
 * The program's main frame.
 */
public val mainFrame : JFrame = JFrame()

/**
 * Runs the program.
 */
public fun main(args : Array<String>){
    init()
}

/**
 * Initiates the main frame and launches the program.
 */
private fun init(){
    initMainFrame()
    launchProgram()
}

/**
 * Creates the program's main frame.
 */
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

/**
 * Launches the program.
 */
private fun launchProgram(){
    ScreenManager.start()
    startTimer()
}





