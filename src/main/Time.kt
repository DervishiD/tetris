package main

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

private const val DELAY = 20;

private val timer : Timer = Timer(DELAY, ActionListener() {
    fun actionPerformed(evt : ActionEvent) {
        println(1);
    }    
});

public fun startTimer(){
    timer.setInitialDelay(0);
    timer.setRepeats(true);
    timer.start();
}




