package game

import main.FRAMEX
import main.FRAMEY
import main.textColor
import java.lang.Exception
import kotlin.math.min

public class Grid(n : Int) {

    public val squareSize : Int = min(FRAMEY / (6 * n), FRAMEX / ((5 / 2) * n + n + 3))
    public val width : Int = n * 5 / 2
    public val height : Int = 6 * n
    public val grid : Array<Array<Cell>> = Array(height){Array(width){Cell()}}

    constructor(n : Int, iValues : ArrayList<Int>, jValues : ArrayList<Int>) : this(n){
        val size : Int = if(iValues.size == jValues.size) iValues.size else 0
        for(k : Int in 0 until size){
            grid[iValues[k]][jValues[k]].set(Block(iValues[k], jValues[k], textColor))
        }
    }

    public fun clearLines() : Int{
        for(i in (height - 1) downTo 0){
            if(fullLine(i)){
                clearLine(i)
                lowerAbove(i)
                return 1 + clearLines()
            }
        }
        return 0
    }

    private fun fullLine(i : Int) : Boolean{
        for(c : Cell in grid[i]){
            if(c.isEmpty()){
                return false
            }
        }
        return true
    }

    private fun clearLine(i : Int){
        for(j in 0 until width){
            grid[i][j] = Cell()
        }
    }

    private fun lowerAbove(i : Int){
        for(j : Int in (i - 1) downTo 0){
            lowerLine(j)
        }
        clearLine(0)
    }

    private fun lowerLine(i : Int){
        for(k in 0 until width){
            grid[i + 1][k] = grid[i][k]
            grid[i][k] = Cell()
        }
    }

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


