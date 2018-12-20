package main

import java.awt.Color
import java.awt.Toolkit
import java.awt.event.KeyListener
import java.awt.event.KeyEvent

public val FRAMEX : Int = (Toolkit.getDefaultToolkit().getScreenSize().getWidth()).toInt();
public val FRAMEY : Int = (Toolkit.getDefaultToolkit().getScreenSize().getHeight()).toInt();
public val HALF_FRAMEX : Int = FRAMEX / 2;
public val HALF_FRAMEY : Int = FRAMEY / 2;

public val WHITE : Color = Color.WHITE;
public val RED : Color = Color.RED;

public val pressedKeys : ArrayList<Char> = ArrayList<Char>();

public class GameKeyListener : KeyListener{
    
    override public fun keyTyped(e : KeyEvent) {}

    override public fun keyPressed(e : KeyEvent) {
        pressedKeys.add(e.keyChar);
    }

    override public fun keyReleased(e : KeyEvent) {
        pressedKeys.remove(e.keyChar);
    }
    
}




