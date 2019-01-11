package game

import display.ScreenManager
import display.screen.EndGameScreen
import ioManager.save
import main.gameTick
import java.lang.Math.pow

public class Game(n : Int){

    companion object {
        @JvmStatic private val STARTING_TICK : Int = 750
        @JvmStatic private val SCORE_FOR_TICK_CHANGE : Int = 1000
        @JvmStatic private val SCORE_FOR_NMINO : Int = 15
        @JvmStatic private val SCORE_FOR_LINE : Int = 100
        @JvmStatic private val GEOMETRIC_FACTOR : Double = 0.9
        @JvmStatic public var currentGame : Game? = null
    }

    public var n : Int = n
    public var score : Int = 0
    public var grid : Grid = Grid(n)
    public var nmino : NMino = NMino(0, null)
    private var running : Boolean = true

    public fun tick() : Long{
        return (STARTING_TICK * pow(GEOMETRIC_FACTOR, (score / SCORE_FOR_TICK_CHANGE).toDouble())).toLong()
    }

    public fun start(){
        nmino = NMino(n, grid.width / 2)
        gameTick(tick())
    }

    public fun end(){
        pause()
        ScreenManager.setScreen(EndGameScreen(this))
        save(score, n)
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








