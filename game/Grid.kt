package game

class Grid {
    
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
    
    private var grid : Array<Array<Cell>> = Array(height, {Array(width, {Cell()})});
        
    constructor(){
        //TODO
    }
    
}



class Cell{
    
}




