package game

import screen.ALLOCATED_GRID_WIDTH
import screen.ALLOCATED_GRID_HEIGHT

public class Grid {
    
    private var width : Int
    	get() = width
    	set(value : Int){
            this.width = value;
        };
    
    private var height : Int
        get() = height
        set(value : Int){
            this.height = value;
        };
    
    private var squareSize : Int
        get() = squareSize
        set(value : Int){
            this.squareSize = value;
        };
    
    private var grid : Array<Array<Cell>>? = null;
        
    public constructor(blockSize : Int){
        this.width = blockSize * blockSize;
        this.squareSize = ALLOCATED_GRID_WIDTH / width;
        this.height = ALLOCATED_GRID_HEIGHT / squareSize;
        this.grid = Array(height, {Array(width, {Cell()})});
    }
    
}






