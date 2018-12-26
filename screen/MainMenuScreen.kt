package screen

import javax.swing.JLabel
import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*

public class MainMenuScreen : Screen(){
    
    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null

        previousScreen = this

        this.addButton(newGameButton)
        this.addButton(loadGameButton)
        this.addButton(optionsButton)
        this.addButton(statsButton)
        this.addButton(exitButton)
        newGameButton.focus()

        this.add(titleLabel) // For the sake of having a title
    }

    public override fun reactTo(key : Key){
        when(key){
            LEFT, UP ->
                previousButton()
            DOWN, RIGHT ->
                nextButton()
            ESCAPE ->
                EXIT_ACTION.invoke()
            ENTER ->
                clickButton()
        }
    }
    
    public override fun save(){
        resetList()
    }
    
}