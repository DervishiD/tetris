package main

import java.util.Timer;
import java.util.TimerTask
import manager.ScreenManager

private const val DELAY = 30;

private val STANDARD : Action = {
    mainFrame.repaint();
    for(i : Int in pressedKeys){
        ScreenManager.reactToKey(i);
    }
};

private val IN_GAME : Action = {
    //TODO -- IN GAME TIMER ACTION
    //TODO -- REACT TO KEY INPUT
};

private var timer : Timer = Timer(false);
private var standardTask : Task = Task(STANDARD);
private var inGameTask : Task = Task(IN_GAME);

public fun startTimer(){
    timer.scheduleAtFixedRate(standardTask, 0, DELAY.toLong());
}

public fun switchToGame(){
    timer.cancel();
    timer.purge();
    timer.scheduleAtFixedRate(inGameTask, 0, DELAY.toLong());
}

public fun switchToStandard(){
    timer.cancel();
    timer.purge();
    timer.scheduleAtFixedRate(standardTask, 0, DELAY.toLong());
}

private class Task(action : Action) : TimerTask(){
    
    private var action : Action = {};
    
	init{
        this.action = action;
    }
    
    override fun run(){
    	action.invoke();
    }
}







