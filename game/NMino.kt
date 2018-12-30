package game

import main.randomVisibleColor
import java.awt.Color

class NMino(n : Int){

    companion object {
        @JvmStatic public fun randomBlocks(n : Int, color : Color) : Array<Block>{
            var result : Array<Block> = Array<Block>(n){Block()}
            for(i in 1 until n){
                //TODO
            }
            return result
        }
    }

    private var n : Int = n
    private var color : Color = randomVisibleColor()
    private var blocks : Array<Block> = randomBlocks(n, color)

}