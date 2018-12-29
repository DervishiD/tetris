package screen

import javax.swing.JPanel
import main.backgroundColor
import main.FRAMEX
import main.FRAMEY
import main.Key
import java.awt.Component
import java.awt.Graphics

public abstract class Screen : JPanel(){
    private var buttons : ArrayList<Button> = ArrayList<Button>()
    private var currentButtonIndex : Int = 0

    protected lateinit var previousScreen : Screen

    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY)
        this.layout = null
        this.background = backgroundColor
    }

    public fun addButton(b : Button){
        buttons.add(b) //As abstract object in the list
        this.add(b)    //As JLabel on a JPanel
    }

    protected fun currentButton() : Button{
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

    protected fun resetList(){
        currentButtonIndex = 0
        buttons.forEach{button : Button -> button.unfocus()}
        currentButton().focus()
    }

    public fun previousScreen() : Screen{
        return previousScreen
    }

    public abstract fun reactTo(key : Key)
    public abstract fun save()

    public override fun paintComponent(g: Graphics?) {
        g!!.color = backgroundColor
        g!!.fillRect(0, 0, FRAMEX, FRAMEY)
        for(c : Component in this.components){
            c.repaint()
        }
    }

}












