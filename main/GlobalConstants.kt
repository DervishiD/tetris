package main

import java.awt.Color
import java.awt.Color.BLACK
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.Toolkit
import display.ScreenManager

public val FRAMEX : Int = (Toolkit.getDefaultToolkit().screenSize.getWidth()).toInt()
public val FRAMEY : Int = (Toolkit.getDefaultToolkit().screenSize.getHeight()).toInt()

public var nightMode : Boolean = true

public val NIGHT_BACKGROUND : Color = BLACK
public val NIGHT_TEXT : Color = Color(75, 75, 75)
public val NIGHT_FOCUS : Color = Color(150, 150, 150)

public var backgroundColor : Color = NIGHT_BACKGROUND
public var textColor : Color = NIGHT_TEXT
public var focusColor : Color = NIGHT_FOCUS

public class GameKeyListener : KeyListener{
    
    override public fun keyTyped(e : KeyEvent) {}

    override public fun keyPressed(e : KeyEvent) {}

    override public fun keyReleased(e : KeyEvent) {
        ScreenManager.reactToKey(e.keyCode)
    }
    
}