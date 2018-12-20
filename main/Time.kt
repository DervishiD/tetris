package main

import java.util.Timer;
import java.util.TimerTask

private const val DELAY = 30;

private val STANDARD : Action = {
    mainFrame.repaint();
    //TODO -- REACT TO KEY INPUT
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







