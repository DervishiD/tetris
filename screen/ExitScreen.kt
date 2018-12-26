package screen

import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*
import javax.swing.JLabel

class ExitScreen : Screen() {

    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null
        previousScreen = startMenu

        addQuestion()
        addButton(confirmExitButton)
        addButton(dismissExitButton)
        confirmExitButton.focus()
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

    public override fun save(){/*NOTHING*/}

    private fun addQuestion(){
        var result : JLabel = JLabel("Are you sure you want to quit?")
        result.font = EXIT_FONT
        result.foreground = EXIT_COLOR
        result.horizontalAlignment = JLabel.CENTER
        result.verticalAlignment = JLabel.CENTER
        result.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT)
        this.add(result)
    }

}