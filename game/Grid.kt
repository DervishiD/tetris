package game

import main.FRAMEX
import main.FRAMEY
import java.lang.Exception
import kotlin.math.min

public class Grid(n : Int) {

    public val squareSize : Int = min(FRAMEY / (6 * n), FRAMEX / ((5 / 2) * n + n + 3))
    public val width : Int = n * 5 / 2
    public val height : Int = 6 * n
    public val grid : Array<Array<Cell>> = Array(height){Array(width){Cell()}}

}

private val maxN : Int by lazy{
    val minSize = 20
    var n : Int = 3
    var size : Int
    do{
        ++n
        size = min(FRAMEY / (6 * n), FRAMEX / ((5 / 2) * n + n + 3))
    }while(size > minSize)
    if(n > 4){
        n - 1
    }else throw Exception("Screen too small.")
}

public fun possibleN() : ArrayList<String> {
    var result : ArrayList<String> = ArrayList<String>()
    for(i : Int in 4..maxN){
        result.add(i.toString())
    }
    return result
}


