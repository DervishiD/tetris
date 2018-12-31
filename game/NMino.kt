package game

import main.randomVisibleColor
import java.awt.Color
import kotlin.random.Random

class NMino(n : Int, startX : Int?){

    companion object {
        @JvmStatic public fun randomBlocks(n : Int, color : Color) : ArrayList<Block>{
            val result : ArrayList<Block> = ArrayList<Block>()
            if(n > 0){
                result.add(Block(0, 0, color))
                for(i in 2..n){
                    val available : ArrayList<Block> = Block.surroundings(result)
                    result.add(available.elementAt(Random.nextInt(0, available.size - 1)))
                }
            }
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
        for(i : Int in 1 until n){
            blocks[i].rotateAround(blocks[0])
        }
        if(!isValidPosition()){
            for(k : Int in 1..3){
                for(i : Int in 1 until n){
                    blocks[i].rotateAround(blocks[0])
                }
            }
            return false
        }
        return true
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