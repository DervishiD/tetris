package game

import main.randomVisibleColor
import java.awt.Color
import kotlin.math.abs
import kotlin.random.Random

class NMino(n : Int, startX : Int?){

    companion object {
        @JvmStatic private fun randomBlocks(n : Int, color : Color) : ArrayList<Block>{
            var result : ArrayList<Block> = ArrayList<Block>()
            if(n > 0) {
                result.add(Block(0, 0, color))
                for (i in 2..n) {
                    val available: ArrayList<Block> = Block.surroundings(result)
                    result.add(available.elementAt(Random.nextInt(0, available.size - 1)))
                }
                result = fixatePivot(result)
            }
            return result
        }

        @JvmStatic private fun fixatePivot(result : ArrayList<Block>) : ArrayList<Block>{
            val n = result.size
            var meanI : Int = 0
            var meanJ : Int = 0
            for(b : Block in result){
                meanI += b.i
                meanJ += b.j
            }
            meanI /= n
            meanJ /= n

            var delta = n * n
            var pivotIndex = -1
            for(k : Int in 0 until n){
                val b : Block = result[k]
                val di : Int = abs(b.i - meanI)
                val dj : Int = abs(b.j - meanJ)
                val distance : Int = di * di + dj * dj
                if(distance < delta){
                    delta = distance
                    pivotIndex = k
                }
            }
            val pivot : Block = result[pivotIndex]
            result.remove(result[pivotIndex])
            result.add(0, pivot)

            return result

        }

    }

    private val n : Int = n
    public val color : Color = randomVisibleColor()
    public val blocks : ArrayList<Block> = randomBlocks(n, color)

    init{
        if(startX != null){
            for(i in 1..(Game.currentGame!!.grid.width / 2)){
                forceMoveRight()
            }
            var mustGoDown : Boolean
            do{
                mustGoDown = false
                for(b : Block in blocks){
                    if(b.i < 0){
                        mustGoDown = true
                        forceMoveDown()
                        break
                    }
                }
            }while(mustGoDown)
        }
    }

    public fun moveLeft() : Boolean{
        for(b : Block in blocks){
            b.moveLeft()
        }
        if(!isValidPosition()){
            for(b : Block in blocks){
                b.moveRight()
            }
            return false
        }
        return true
    }

    public fun moveRight() : Boolean{
        for(b : Block in blocks){
            b.moveRight()
        }
        if(!isValidPosition()){
            for(b : Block in blocks){
                b.moveLeft()
            }
            return false
        }
        return true
    }

    private fun forceMoveRight() {
        for(b : Block in blocks){
            b.moveRight()
        }
    }

    private fun forceMoveLeft() {
        for(b : Block in blocks){
            b.moveLeft()
        }
    }

    public fun moveDown() : Boolean{
        for(b : Block in blocks){
            b.moveDown()
        }
        if(!isValidPosition()){
            for(b : Block in blocks){
                b.moveUp()
            }
            return false
        }
        return true
    }

    private fun forceMoveDown() {
        for(b : Block in blocks){
            b.moveDown()
        }
    }

    public fun rotate() : Boolean{
        val previousPosition : ArrayList<Block> = ArrayList<Block>()
        for(i : Int in 0 until n){
            previousPosition.add(Block(blocks[i].i, blocks[i].j, blocks[i].color))
            blocks[i].rotateAround(pivot())
        }
        if(!isValidPosition()){
            var mustGoRight : Boolean = false
            var mustGoLeft : Boolean = false
            for(b : Block in blocks){
                if(b.j < 0){
                    mustGoRight = true
                    break
                }else if(b.j >= Game.currentGame!!.grid.width){
                    mustGoLeft = true
                    break
                }
            }
            if(mustGoRight || mustGoLeft){
                while(tooFar()){
                    if(mustGoLeft) forceMoveLeft() else forceMoveRight()
                }
                if(!isValidPosition()){
                    for(i in 0 until n){
                        blocks[i] = previousPosition[i]
                    }
                }
            }else{
                for(i in 0 until n){
                    blocks[i] = previousPosition[i]
                }
            }
            return false
        }
        return true
    }

    private fun pivot() : Block{
        return blocks[0]
    }

    private fun tooFar() : Boolean{
        for(b : Block in blocks){
            if(b.j < 0 || b.j >= Game.currentGame!!.grid.width){
                return true
            }
        }
        return false
    }

    public fun isValidPosition() : Boolean{
        for(b : Block in blocks){
            if(!b.isValidPosition()){
                return false
            }
        }
        return true
    }

}