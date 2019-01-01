package display.screen

import display.*
import main.Key
import main.Key.*

class PauseScreen(gameScreen : GameScreen) : Screen() {

    init{
        previousScreen = gameScreen
        addButton(resumeButton)
        addButton(saveAndQuitButton)
        resumeButton.focus()
        this.add(pauseLabel)
    }

    public override fun reactTo(key: Key) {
        when(key){
            LEFT, UP -> previousButton()
            RIGHT, DOWN -> nextButton()
            ENTER -> currentButton().click()
            ESCAPE -> RESUME_ACTION.invoke()
        }
    }

    public override fun save() {
        resetList()
    }

}