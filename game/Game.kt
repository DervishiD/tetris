package game

import main.gameTick

public class Game(n : Int){

    companion object {
        @JvmStatic private val STARTING_TICK : Long= 750
        @JvmStatic private val SCORE_PER_TICK : Long = 250
        @JvmStatic private val DELTA_TICK : Long = 50
        @JvmStatic private val DELTA_SCORE : Long = 100
        @JvmStatic public var currentGame : Game? = null
    }

    private var n : Int = n
    public var score : Long = 0
    public var grid : Grid = Grid(n)
    public var nmino : NMino = NMino(0, null)

    public fun tick() : Long{
        return STARTING_TICK - (score / SCORE_PER_TICK) * DELTA_TICK
    }

    public fun start(){
        nmino = NMino(n, grid.width / 2)
        gameTick(tick())
    }

    public fun end(){
        //TODO
    }

    public fun act(){
        if(!nmino.moveDown()){
            writeNMino()
            val clearedLines = grid.clearLines()
            score += clearedLines * DELTA_SCORE
            nmino = NMino(n, grid.width / 2)
            if(nmino.isValidPosition()){
                score += DELTA_SCORE / 10
                gameTick(tick())
            }else{
                end()
            }
        }else gameTick(tick())
    }

    private fun writeNMino(){
        for(b : Block in nmino.blocks){
            grid.grid[b.i][b.j].set(b)
        }
    }

}








