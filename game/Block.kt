package game

import java.awt.Color

class Block(i : Int, j : Int, c : Color) {

    private var i : Int = i
    private var j : Int = j
    public val color : Color = c

    constructor() : this(0, 0, Color.BLACK)

}