package game

public class Game {
    private var n : Int
        get() = this.n
        set(value : Int){
            this.n = value;
        };
    
    private var grid : Grid? = null
    	set(value : Grid?){
            this.grid = value;
        };
    
    public constructor(n : Int){
        this.n = n;
        this.grid = Grid(n);
    }
}








