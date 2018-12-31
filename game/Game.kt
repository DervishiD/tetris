package game

public class Game(n : Int){

    companion object {
        @JvmStatic private val STARTING_TICK = 750
        @JvmStatic private val SCORE_PER_TICK = 500
        @JvmStatic private val DELTA_TICK = 25
        @JvmStatic public var currentGame : Game? = null
    }

    private var n : Int = n
    public var score : Int = 0
    public var grid : Grid = Grid(n)
    public var nmino : NMino? = null

    public fun tick() : Int{
        return STARTING_TICK - score / SCORE_PER_TICK * DELTA_TICK
    }

    public fun start(){
        nmino = NMino(n, grid.width / 2)
        //TODO -- START A TIMER AND STUFF
    }



}








