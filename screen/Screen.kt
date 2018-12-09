package screen

import javax.swing.JPanel
import javax.swing.JButton
import main.FRAMEX
import main.FRAMEY
import main.HALF_FRAMEX
import main.WHITE

public val startMenu : Screen = Screen.initStartMenu();

public class Screen : JPanel(){
    public companion object{
        @JvmStatic
        public fun initStartMenu() : Screen{
            var result : Screen = Screen();
            result.setBounds(0, 0, FRAMEX, FRAMEY);
            result.setLayout(null);
            
            var startButton : JButton = initStartButton();
            startButton.setBounds(HALF_FRAMEX - START_BUTTON_WIDTH, FRAMEY * 3 / 4 - START_BUTTON_HEIGHT,
            					  START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
            result.add(startButton);
            
            return result;
        }
        
        @JvmStatic
        private fun initStartButton() : JButton{
            var result : JButton = JButton();
            result.setFont(START_BUTTON_FONT);
            result.setBackground(WHITE);
            result.setText("Start");
            return result;
        }
        
    }
}