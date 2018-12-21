package main

import java.awt.event.KeyEvent.VK_A
import java.awt.event.KeyEvent.VK_D
import java.awt.event.KeyEvent.VK_DOWN
import java.awt.event.KeyEvent.VK_ENTER
import java.awt.event.KeyEvent.VK_ESCAPE
import java.awt.event.KeyEvent.VK_LEFT
import java.awt.event.KeyEvent.VK_RIGHT
import java.awt.event.KeyEvent.VK_S
import java.awt.event.KeyEvent.VK_SPACE
import java.awt.event.KeyEvent.VK_TAB
import java.awt.event.KeyEvent.VK_UP
import java.awt.event.KeyEvent.VK_W

enum class Key(vararg codes : Int){
    
    LEFT(VK_A, VK_LEFT),
    RIGHT(VK_D, VK_RIGHT),
    UP(VK_W, VK_UP),
    DOWN(VK_S, VK_DOWN),
    ENTER(VK_ENTER),
    ESCAPE(VK_ESCAPE),
    TAB(VK_TAB),
    SPACE(VK_SPACE);
    
    private var codes : IntArray = IntArray(0);
    
    init{
        this.codes = codes;
    }
    
    public fun correspondsTo(code : Int) : Boolean{
        for(i : Int in codes){
            if(i == code){
                return true;
            }
        }
        return false;
    }
    
}




