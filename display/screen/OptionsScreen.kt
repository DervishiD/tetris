package display.screen

import display.*
import display.button.Slider
import main.*
import java.awt.Color
import main.Key.*

class OptionsScreen : Screen() {

    private var focusedSlider : Slider? = null

    init{
        this.add(optionsLabel)
        addButton(nightColorButton)
        this.add(rLabel)
        addButton(rSlider)
        this.add(gLabel)
        addButton(gSlider)
        this.add(bLabel)
        addButton(bSlider)
        addButton(backButton)
        nightColorButton.focus()
        previousScreen = startMenu
    }

    private fun updateColors(){
        nightMode = false
        val r : Int = rSlider.selectedOption().toInt()
        val g : Int = gSlider.selectedOption().toInt()
        val b : Int = bSlider.selectedOption().toInt()
        backgroundColor = Color(r, g, b)
        setTextColor()
        setFocusColor()
    }

    public override fun reactTo(key: Key) {
        when(key){
            ESCAPE ->
                if(focusedSlider == null){
                    BACK_ACTION.invoke()
                }else{
                    focusedSlider!!.unfocus()
                    focusedSlider = null
                }
            ENTER ->
                if(currentButton() is Slider){
                    if(focusedSlider == null){
                        focusedSlider = currentButton() as Slider
                        focusedSlider!!.activate()
                    }else{
                        focusedSlider!!.deactivate()
                        focusedSlider = null
                    }
                }else{
                    clickButton()
                    focusedSlider?.unfocus()
                    focusedSlider = null
                }
            UP ->
                if(focusedSlider == null){
                    previousButton()
                }
            DOWN ->
                if(focusedSlider == null){
                    nextButton()
                }
            LEFT ->
                if(focusedSlider != null){
                    focusedSlider!!.previous()
                    updateColors()
                }else{
                    previousButton()
                }
            RIGHT ->
                if(focusedSlider != null){
                    focusedSlider!!.next()
                    updateColors()
                }else{
                    nextButton()
                }
        }
    }

    public override fun save() {
        resetList()
    }

}