package screen

import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*
import javax.swing.JLabel

class ExitScreen : Screen() {

    init{
        previousScreen = startMenu

        addButton(confirmExitButton)
        addButton(dismissExitButton)
        confirmExitButton.focus()

        this.add(exitQuestion)

    }

    public override fun reactTo(key : Key){
        when(key){
            ENTER ->
                clickButton()
            LEFT ->
                previousButton()
            RIGHT ->
                nextButton()
            ESCAPE ->
                BACK_ACTION.invoke()
        }
    }

    public override fun save(){
        resetList()
    }

}