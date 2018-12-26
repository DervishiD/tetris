package game

import screen.ALLOCATED_GRID_WIDTH
import screen.ALLOCATED_GRID_HEIGHT

public class Grid {
    
    private var width : Int
    
    private var height : Int
    
    private var squareSize : Int
    
    private var grid : Array<Array<Cell>>
        
    public constructor(blockSize : Int){
        this.width = blockSize * blockSize
        this.squareSize = ALLOCATED_GRID_WIDTH / width
        this.height = ALLOCATED_GRID_HEIGHT / squareSize
        this.grid = Array(height, {Array(width, {Cell()})})
    }
    
}






