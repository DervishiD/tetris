package screen

import javax.swing.JLabel
import main.Action

class Button(a : Action) : JLabel(){
    
    private var action : Action? = null
    	set(a : Action?){
            this.action = a;
        };
    
    init{
        this.action = a;
    }
    
    public fun click(){
        action!!.act();
    }
    
}