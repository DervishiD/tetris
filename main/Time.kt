package main

import game.Game
import java.util.Timer
import java.util.TimerTask

private const val DELAY : Long = 30

private val STANDARD_ACTION : Action = {
    mainFrame.repaint()
}

private var timer : Timer = Timer(false)
private var standardTask : Task = Task(STANDARD_ACTION)

public fun startTimer(){
    timer.scheduleAtFixedRate(standardTask, 0, DELAY)
}

private class Task(action : Action) : TimerTask(){
    
    private var action : Action = {}
    
	init{
        this.action = action
    }
    
    override fun run(){
    	action.invoke()
    }
}

public fun startGameTimer(){
    Timer(false).schedule(Task{Game.currentGame!!.start()}, 2000)
}



