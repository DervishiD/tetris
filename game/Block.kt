package game

import java.awt.Color

class Block(i : Int, j : Int, c : Color) {

    companion object {
        @JvmStatic public fun surroundings(blocks : ArrayList<Block>) : HashSet<Block>{
            var result : HashSet<Block> = HashSet<Block>()
            for(b : Block in blocks){
                result.add(Block(b.i - 1, b.j, b.color))
                result.add(Block(b.i, b.j - 1, b.color))
                result.add(Block(b.i + 1, b.j, b.color))
                result.add(Block(b.i, b.j + 1, b.color))
            }
            for(b : Block in blocks){
                result.remove(b)
            }
            return result
        }
    }

    public var i : Int = i
    public var j : Int = j
    public val color : Color = c

    public fun moveLeft(){
        --j
    }

    public fun moveRight(){
        ++j
    }

    public fun moveDown(){
        ++i
    }

    public fun moveUp(){
        --i
    }

    public fun rotateAround(b : Block){
        val di : Int = this.i - b.i
        val dj : Int = this.j - b.j
        i = b.i - dj
        j = b.j + di
    }

    public fun isValidPosition() : Boolean{
        return i >= 0 &&
               j >= 0 &&
               i < Game.currentGame!!.grid.height &&
               j < Game.currentGame!!.grid.width &&
               Game.currentGame!!.grid.grid[i][j].isEmpty()
    }

}