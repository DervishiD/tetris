package game

import java.awt.Color

class Block(i : Int, j : Int, c : Color) {

    companion object {
        @JvmStatic public fun surroundings(blocks : ArrayList<Block>) : ArrayList<Block>{
            var result : ArrayList<Block> = ArrayList<Block>()
            for(b : Block in blocks){
                val up : Block = Block(b.i - 1, b.j, b.color)
                val down : Block = Block(b.i + 1, b.j, b.color)
                val left : Block = Block(b.i, b.j - 1, b.color)
                val right : Block = Block(b.i, b.j + 1, b.color)
                if(!(listHas(blocks, up) || listHas(result, up))){
                    result.add(up)
                }
                if(!(listHas(blocks, down) || listHas(result, down))){
                    result.add(down)
                }
                if(!(listHas(blocks, left) || listHas(result, left))){
                    result.add(left)
                }
                if(!(listHas(blocks, right) || listHas(result, right))){
                    result.add(right)
                }
            }
            return result
        }

        @JvmStatic private fun listHas(blocks : ArrayList<Block>, b : Block) : Boolean{
            for(a : Block in blocks){
                if(a.i == b.i && a.j == b.j){
                    return true
                }
            }
            return false
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