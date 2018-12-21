package screen

import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import main.FRAMEX
import main.FRAMEY
import main.Key
import main.mainFrame
import manager.ScreenManager

public abstract class Screen : JPanel(){
    private var buttons : ArrayList<Button> = ArrayList<Button>();
    private var currentButtonIndex : Int = 0;
    
    public fun addButton(b : Button){
        buttons.add(b); //As abstract object in the list
        this.add(b); //As JLabel on a JPanel    
    }
    
    public abstract fun reactTo(key : Key);
    public abstract fun save();
    
}

public class MainMenuScreen : Screen(){
    
    init{
        this.setBounds(0, 0, FRAMEX, FRAMEY);
        this.setLayout(null);
        
        this.addButton(startButton);
        this.addButton(optionsButton);
        this.addButton(statsButton);
        this.addButton(exitButton);
        
        this.add(titleLabel()); // For the sake of having a title
        
    }
    
	private fun titleLabel() : JLabel{
	    var result : JLabel = JLabel("TETRIS");
	    result.setFont(TITLE_FONT);
	    result.setForeground(TITLE_COLOR);
	    result.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
	    return result;
	}
    
    override public fun reactTo(key : Key){
        when(key){
            //TODO -- IT'S A SWITCH BUT OP
        }
    }
    
    override public fun save(){
        //TODO -- SAVE ACTION
    }
    
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











