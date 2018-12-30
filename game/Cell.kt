package game

import java.awt.Color

public class Cell {
    private var block : Block? = null

    public fun set(b : Block?){
        block = b
    }

    public fun color() : Color? {
        return block?.color
    }

    public fun isEmpty() : Boolean{
        return block == null
    }

}