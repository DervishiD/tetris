package screen

import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*
import main.mainFrame
import manager.ScreenManager

public abstract class Screen : JPanel(){
    private var buttons : ArrayList<Button> = ArrayList<Button>();
    private var currentButtonIndex : Int = 0;
    
    public fun addButton(b : Button){
        buttons.add(b); //As abstract object in the list
        this.add(b); //As JLabel on a JPanel    
    }
    
    protected fun currentButton() : Button{
        return buttons.get(currentButtonIndex)
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
    
    public abstract fun reactTo(key : Key);
    public abstract fun save();
    
}

public class GameLaunchingScreen : Screen(){
    
    init{
        initGameLaunchMenu();
    }
    
    private fun initGameLaunchMenu(){
        this.setBounds(0, 0, FRAMEX, FRAMEY);
        this.setLayout(null /*TO REVIEW*/);
    }
    
    override public fun reactTo(key : Key){
        //TODO -- REACTION TO KEYBOARD INPUTS
    }
    
    override public fun save(){
        //TODO -- SAVE ACTION
    }
    
}











