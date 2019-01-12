package display.screen

import display.*
import display.button.GameSelector
import display.button.Selector
import main.Key

class LoadGameScreen : Screen() {

    private var focusedSelector : Selector? = null
    private val gameSelector : GameSelector

    init{
        previousScreen = startMenu
        gameSelector = GameSelector(GAME_SELECTOR_X, GAME_SELECTOR_Y)
        addButton(gameSelector)
        addButton(loadButton)
        addButton(backButton)
        this.add(loadGameLabel)
        gameSelector.focus()
        gameSelector.activate()
        focusedSelector = gameSelector
    }

    public fun selectedGame() : String{
        return gameSelector.selectedOption()
    }

    public override fun reactTo(key: Key) {
        when(key){
            Key.ESCAPE ->
                if(focusedSelector == null){
                    BACK_ACTION.invoke()
                }else{
                    focusedSelector!!.deactivate()
                    focusedSelector = null
                }
            Key.ENTER ->
                if(currentButton() is Selector){
                    if(focusedSelector == null){
                        focusedSelector = currentButton() as Selector
                        focusedSelector!!.activate()
                    }else{
                        focusedSelector!!.deactivate()
                        focusedSelector = null
                    }
                }else{
                    clickButton()
                    focusedSelector?.unfocus()
                    focusedSelector = null
                }
            Key.UP ->
                if(focusedSelector == null){
                    previousButton()
                }
            Key.DOWN ->
                if(focusedSelector == null){
                    nextButton()
                }
            Key.LEFT ->
                if(focusedSelector != null){
                    focusedSelector!!.previous()
                }else{
                    previousButton()
                }
            Key.RIGHT ->
                if(focusedSelector != null){
                    focusedSelector!!.next()
                }else{
                    nextButton()
                }
        }
    }

    public override fun save() {
        gameSelector.reset()
        resetList()
    }

}