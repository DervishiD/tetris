package screen

import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*

public class NewGameScreen : Screen(){

    private var focusedSelector : Selector? = null

    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null

        previousScreen = startMenu

        addButton(backButton)

    }

    public override fun reactTo(key : Key){
        when(key){
            ESCAPE ->
                if(focusedSelector == null){
                    BACK_ACTION.invoke()
                }else{
                    focusedSelector!!.unfocus()
                    focusedSelector = null
                }
            ENTER ->
                if(currentButton() is Selector){
                    focusedSelector = currentButton() as Selector
                    focusedSelector!!.focus()
                }else{
                    clickButton()
                    focusedSelector?.unfocus()
                    focusedSelector = null
                }
            UP ->
                if(focusedSelector == null){
                    nextButton()
                }
            DOWN ->
                if(focusedSelector == null){
                    previousButton()
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

    override public fun save(){

    }

}




