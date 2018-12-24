package screen

import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*

public class NewGameScreen : Screen(){

    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null

        previousScreen = startMenu

        addButton(backButton)

    }

    public override fun reactTo(key : Key){
        when(key){
            ESCAPE ->
                BACK_ACTION.invoke()
            //TODO -- EVERYTHING ELSE
        }
    }

    override public fun save(){

    }

}




