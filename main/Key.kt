package main

import java.awt.event.KeyEvent

enum class Key(vararg codes : Int){
    
    LEFT(KeyEvent.VK_A, KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_D, KeyEvent.VK_RIGHT),
    UP(KeyEvent.VK_W, KeyEvent.VK_UP),
    DOWN(KeyEvent.VK_S, KeyEvent.VK_DOWN),
    ENTER(KeyEvent.VK_ENTER),
    ESCAPE(KeyEvent.VK_ESCAPE),
    TAB(KeyEvent.VK_TAB),
    SPACE(KeyEvent.VK_SPACE);
    
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




