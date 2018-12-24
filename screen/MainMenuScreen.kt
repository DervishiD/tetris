package screen

import javax.swing.JLabel
import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*

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
            LEFT, UP ->
                previousButton()
            DOWN, RIGHT, TAB ->
                nextButton()
            ESCAPE ->
                EXIT_ACTION.invoke()
            SPACE, ENTER ->
                clickButton()
        }
    }
    
    override public fun save(){
        //TODO -- SAVE ACTION
    }
    
}