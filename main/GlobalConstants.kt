package main

import java.awt.Toolkit
import java.awt.event.KeyListener
import java.awt.event.KeyEvent
import screen.ScreenManager

public val FRAMEX : Int = (Toolkit.getDefaultToolkit().screenSize.getWidth()).toInt()
public val FRAMEY : Int = (Toolkit.getDefaultToolkit().screenSize.getHeight()).toInt()
public val HALF_FRAMEX : Int = FRAMEX / 2
public val HALF_FRAMEY : Int = FRAMEY / 2

public class GameKeyListener : KeyListener{
    
    override public fun keyTyped(e : KeyEvent) {}

    override public fun keyPressed(e : KeyEvent) {}

    override public fun keyReleased(e : KeyEvent) {
        ScreenManager.reactToKey(e.keyCode)
    }
    
}




