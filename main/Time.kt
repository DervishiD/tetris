package main

import java.util.Timer;
import java.util.TimerTask

private const val DELAY = 20;

private var timer : Timer = Timer(false);
private var task : Task = Task();

public fun startTimer(){
    timer.scheduleAtFixedRate(task, 0, DELAY.toLong());
}

private class Task : TimerTask(){
    override fun run(){
    	
    }
}




