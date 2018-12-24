package screen

import main.FRAMEX
import main.FRAMEY
import main.Key

public class GameLaunchingScreen : Screen(){
    
    init{
        initGameLaunchMenu();
    }
    
    private fun initGameLaunchMenu(){
        this.setBounds(0, 0, FRAMEX, FRAMEY);
        this.setLayout(null /*TO REVIEW*/);
    }
    
    override public fun reactTo(key : Key){
        //TODO -- REACTION TO KEYBOARD INPUTS
    }
    
    override public fun save(){
        //TODO -- SAVE ACTION
    }
    
}




