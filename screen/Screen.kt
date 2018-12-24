package screen

import javax.swing.JPanel
import main.Key

public abstract class Screen : JPanel(){
    private var buttons : ArrayList<Button> = ArrayList<Button>()
    private var currentButtonIndex : Int = 0

    protected lateinit var previousScreen : Screen
    
    public fun addButton(b : Button){
        buttons.add(b) //As abstract object in the list
        this.add(b)    //As JLabel on a JPanel
    }
    
    private fun currentButton() : Button{
        return buttons[currentButtonIndex]
    }
    
    protected fun previousButton(){
        currentButton().unfocus()
        if(currentButtonIndex == 0){
            currentButtonIndex = buttons.size - 1
        }else{
            --currentButtonIndex
        }
        currentButton().focus()
    }
    
    protected fun nextButton(){
        currentButton().unfocus()
        if(currentButtonIndex == buttons.size - 1){
            currentButtonIndex = 0
        }else{
            ++currentButtonIndex
        }
        currentButton().focus()
    }
    
    protected fun clickButton(){
        currentButton().click()
    }

    public fun previousScreen() : Screen{
        return previousScreen
    }

    public abstract fun reactTo(key : Key)
    public abstract fun save()
    
}












