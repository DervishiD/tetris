package game

import main.randomVisibleColor
import java.awt.Color
import kotlin.random.Random

class NMino(n : Int, startX : Int){

    companion object {
        @JvmStatic public fun randomBlocks(n : Int, color : Color) : ArrayList<Block>{
            var result : ArrayList<Block> = ArrayList<Block>()
            result.add(Block(0, 0, color))
            for(i in 1 until n){
                var available : HashSet<Block> = Block.surroundings(result)
                result.add(available.elementAt(Random.nextInt(0, available.size - 1)))
            }
            return result
        }
    }

    private var n : Int = n
    private var color : Color = randomVisibleColor()
    private var blocks : ArrayList<Block> = randomBlocks(n, color)

    init{
        while(blocks[0].j < startX){
            moveRight()
        }
        var mustGoDown : Boolean = false
        do{
            for(b : Block in blocks){
                if(b.i < 0){
                    mustGoDown = true
                    break
                }
            }
            if(mustGoDown){
                moveDown()
            }
        }while(mustGoDown)
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

    private fun isValidPosition() : Boolean{
        for(b : Block in blocks){
            if(!b.isValidPosition()){
                return false
            }
        }
        return true
    }

}