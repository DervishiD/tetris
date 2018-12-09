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
            
            result.add(startButton());
            result.add(exitButton());
            result.add(optionsButton());
            result.add(statsButton());
            
            return result;
        }
        
        @JvmStatic
        private fun startButton() : JButton{
            var result : JButton = JButton();
            result.setFont(DEFAULT_BUTTON_FONT);
            result.setBackground(WHITE);
            result.setText("Start");
            result.addActionListener{println("TODO : WRITE STARTBUTTON ACTIONLISTENER");};
            result.setBounds(START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
            return result;
        }
        
        @JvmStatic
        private fun exitButton() : JButton{
            var result : JButton = JButton();
            result.setFont(DEFAULT_BUTTON_FONT);
            result.setBackground(WHITE);
            result.setText("X");
            result.addActionListener{println("TODO : WRITE EXITBUTTON ACTIONLISTENER");};
            result.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            return result;
        }
        
        @JvmStatic
        private fun optionsButton() : JButton{
            var result : JButton = JButton();
            result.setFont(DEFAULT_BUTTON_FONT);
            result.setBackground(WHITE);
            result.setText("Options");
            result.addActionListener{println("TODO : WRITE OPTIONSBUTTON ACTIONLISTENER");};
            result.setBounds(OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, OPTIONS_BUTTON_WIDTH, OPTIONS_BUTTON_HEIGHT);
            return result;
        }
        
        @JvmStatic
        private fun statsButton() : JButton{
            var result : JButton = JButton();
            result.setFont(DEFAULT_BUTTON_FONT);
            result.setBackground(WHITE);
            result.setText("Statistics");
            result.addActionListener{println("TODO : WRITE STATSBUTTON ACTIONLISTENER");};
            result.setBounds(STATS_BUTTON_X, STATS_BUTTON_Y, STATS_BUTTON_WIDTH, STATS_BUTTON_HEIGHT);
            return result;
        }
        
    }
}







