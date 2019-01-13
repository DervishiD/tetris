package display.screen

import display.*
import display.button.Selector
import main.Key
import main.Key.*

public class NewGameScreen : Screen(){

    private var focusedSelector : Selector? = null

    init{
        previousScreen = startMenu

        addButton(nSelector)
        addButton(startButton)
        addButton(backButton)
        this.add(nQuestion)
        nSelector.focus()

    }

    public override fun reactTo(key : Key){
        when(key){
            ESCAPE ->
                if(focusedSelector == null){
                    BACK_ACTION.invoke()
                }else{
                    focusedSelector!!.unfocus()
                    focusedSelector!!.deactivate()
                    focusedSelector = null
                }
            ENTER ->
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
            UP ->
                if(focusedSelector == null){
                    previousButton()
                }
            DOWN ->
                if(focusedSelector == null){
                    nextButton()
                }
            LEFT ->
                if(focusedSelector != null){
                    focusedSelector!!.previous()
                }else{
                    previousButton()
                }
            RIGHT ->
                if(focusedSelector != null){
                    focusedSelector!!.next()
                }else{
                    nextButton()
                }
        }
    }

    public override fun save(){
        nSelector.reset()
        resetList()
    }

}




