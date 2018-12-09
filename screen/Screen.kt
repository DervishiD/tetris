package screen

import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import javax.swing.JPanel
import javax.swing.JButton
import javax.swing.JLabel
import main.FRAMEX
import main.FRAMEY
import main.mainFrame

public val startMenu : JPanel = initStartMenu();

public fun initStartMenu() : JPanel{
    var result : JPanel = JPanel();
    result.setBounds(0, 0, FRAMEX, FRAMEY);
    result.setLayout(null);
    
    result.add(startButton());
    result.add(exitButton());
    result.add(optionsButton());
    result.add(statsButton());
    result.add(titleLabel());
    
    return result;
}

private fun startButton() : JButton{
    var result : JButton = JButton();
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Start");
    result.addActionListener{println("TODO : WRITE STARTBUTTON ACTIONLISTENER");};
    result.setBounds(START_BUTTON_X, START_BUTTON_Y, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
    return result;
}

private fun exitButton() : JButton{
    var result : JButton = JButton();
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("X");
    result.addActionListener{
        mainFrame.setVisible(false);
        mainFrame.dispatchEvent(WindowEvent(mainFrame, WINDOW_CLOSING));
    };
    result.setBounds(EXIT_BUTTON_X, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
    return result;
}

private fun optionsButton() : JButton{
    var result : JButton = JButton();
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Options");
    result.addActionListener{println("TODO : WRITE OPTIONSBUTTON ACTIONLISTENER");};
    result.setBounds(OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, OPTIONS_BUTTON_WIDTH, OPTIONS_BUTTON_HEIGHT);
    return result;
}

private fun statsButton() : JButton{
    var result : JButton = JButton();
    result.setFont(DEFAULT_BUTTON_FONT);
    result.setBackground(DEFAULT_BUTTON_COLOR);
    result.setText("Statistics");
    result.addActionListener{println("TODO : WRITE STATSBUTTON ACTIONLISTENER");};
    result.setBounds(STATS_BUTTON_X, STATS_BUTTON_Y, STATS_BUTTON_WIDTH, STATS_BUTTON_HEIGHT);
    return result;
}

private fun titleLabel() : JLabel{
    var result : JLabel = JLabel("TETRIS");
    result.setFont(TITLE_FONT);
    result.setForeground(TITLE_COLOR);
    result.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
    return result;
}









