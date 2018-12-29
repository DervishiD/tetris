package main

import java.awt.event.KeyEvent.VK_A
import java.awt.event.KeyEvent.VK_D
import java.awt.event.KeyEvent.VK_DOWN
import java.awt.event.KeyEvent.VK_ENTER
import java.awt.event.KeyEvent.VK_ESCAPE
import java.awt.event.KeyEvent.VK_I
import java.awt.event.KeyEvent.VK_J
import java.awt.event.KeyEvent.VK_K
import java.awt.event.KeyEvent.VK_L
import java.awt.event.KeyEvent.VK_LEFT
import java.awt.event.KeyEvent.VK_RIGHT
import java.awt.event.KeyEvent.VK_S
import java.awt.event.KeyEvent.VK_SPACE
import java.awt.event.KeyEvent.VK_UP
import java.awt.event.KeyEvent.VK_W

enum class Key(vararg codes : Int){
    
    LEFT(VK_A, VK_LEFT, VK_J),
    RIGHT(VK_D, VK_RIGHT, VK_L),
    UP(VK_W, VK_UP, VK_I),
    DOWN(VK_S, VK_DOWN, VK_K),
    ENTER(VK_ENTER, VK_SPACE),
    ESCAPE(VK_ESCAPE);
    
    private var codes : IntArray = IntArray(0)
    
    init{
        this.codes = codes
    }
    
    public fun correspondsTo(code : Int) : Boolean{
        for(i : Int in codes){
            if(i == code){
                return true
            }
        }
        return false
    }
    
}




