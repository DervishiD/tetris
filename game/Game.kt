package game

import display.ScreenManager
import display.screen.EndGameScreen
import main.gameTick

public class Game(n : Int){

    companion object {
        @JvmStatic private val STARTING_TICK : Long = 750
        @JvmStatic private val SCORE_FOR_TICK_CHANGE : Long = 1000
        @JvmStatic private val SCORE_FOR_NMINO : Long = 15
        @JvmStatic private val DELTA_TICK : Long = 50
        @JvmStatic private val SCORE_FOR_LINE : Long = 100
        @JvmStatic public var currentGame : Game? = null
    }

    private var n : Int = n
    public var score : Long = 0
    public var grid : Grid = Grid(n)
    public var nmino : NMino = NMino(0, null)
    private var running : Boolean = true

    public fun tick() : Long{
        return STARTING_TICK - (score / SCORE_FOR_TICK_CHANGE) * DELTA_TICK
    }

    public fun start(){
        nmino = NMino(n, grid.width / 2)
        gameTick(tick())
    }

    public fun end(){
        pause()
        ScreenManager.setScreen(EndGameScreen(this))
        println("TODO -- SAVE SCORE IN GAME.END")
    }

    public fun act(){
        if(running){
            if(!nmino.moveDown()){
                writeNMino()
                val clearedLines = grid.clearLines()
                score += clearedLines * SCORE_FOR_LINE
                nmino = NMino(n, grid.width / 2)
                if(nmino.isValidPosition()){
                    score += SCORE_FOR_NMINO
                    gameTick(tick())
                }else{
                    end()
                }
            }else gameTick(tick())
        }
    }

    private fun writeNMino(){
        for(b : Block in nmino.blocks){
            grid.grid[b.i][b.j].set(b)
        }
    }

    public fun pause(){
        running = false
    }

    public fun resume(){
        running = true
        gameTick(tick())
    }

}








