package game

public class Game {
    private var n : Int
    private var grid : Grid
    private var hasGravity : Boolean
    
    public constructor(n : Int, hasGravity : Boolean){
        this.n = n
        this.grid = Grid(n)
        this.hasGravity = hasGravity
    }
}








