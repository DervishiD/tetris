package game

class Game {
    private var n : Int
        get() = this.n
        set(value : Int){
            this.n = value;
            this.gridSize = n * n;
        };
    private var gridSize : Int = 0
        get() = this.gridSize;
    
    constructor(n : Int){
        this.n = n;
    }
}








