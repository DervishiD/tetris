package display.screen

import display.BACK_ACTION
import display.QUESTION_FONT
import display.backToMainMenuButton
import display.startMenu
import game.Game
import main.*
import main.Key.ENTER
import main.Key.ESCAPE

import java.awt.Graphics

class EndGameScreen(game : Game) : Screen() {

    private val game : Game = game

    init{
        previousScreen = startMenu
        addButton(backToMainMenuButton)
        backToMainMenuButton.focus()
    }

    public override fun reactTo(key: Key) {
        if(key == ENTER){
            currentButton().click()
        }else if(key == ESCAPE){
            BACK_ACTION.invoke()
        }
    }

    public override fun save() {
        //NOTHING
    }

    public override fun paintComponent(g: Graphics?) {
        fillBackground(g!!)
        drawInfos(g)
    }

    private fun fillBackground(g : Graphics){
        g.color = backgroundColor
        g.fillRect(0, 0, FRAMEX, FRAMEY)
    }

    private fun drawInfos(g : Graphics){
        g.color = textColor
        g.font = QUESTION_FONT
        g.drawString("Score : " + game.score.toString(), FRAMEX / 4, FRAMEY / 4)
        g.drawString("Tick : " + game.tick().toString(), FRAMEX / 4, FRAMEY / 2)
    }

}



