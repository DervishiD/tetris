package screen

import java.awt.Color
import java.awt.Font
import java.awt.Font.BOLD
import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import main.Action
import main.FRAMEX
import main.FRAMEY
import main.HALF_FRAMEX
import main.HALF_FRAMEY
import main.mainFrame
import main.WHITE
import manager.ScreenManager



//TODO -- REPLACE BUTTONS WHEN NEEDED
//I.E. OPTIONS NIT NECESSARILY AT THE SAME PLACE IN PAUSE MENU
//AND IN START MENU FOR EXAMPLE
//I.E. ADD MORE CONSTANTS




public const val START_BUTTON_WIDTH : Int = 200;
public const val START_BUTTON_HEIGHT : Int = 60;
public val START_BUTTON_X : Int = HALF_FRAMEX - START_BUTTON_WIDTH / 2;
public val START_BUTTON_Y : Int = FRAMEY * 2 / 3 - START_BUTTON_HEIGHT / 2;

public const val EXIT_BUTTON_WIDTH : Int = 60;
public const val EXIT_BUTTON_HEIGHT : Int = 60;
public val EXIT_BUTTON_X : Int = FRAMEX - EXIT_BUTTON_WIDTH;
public val EXIT_BUTTON_Y : Int = 0;

public const val OPTIONS_BUTTON_WIDTH : Int = 200;
public const val OPTIONS_BUTTON_HEIGHT : Int = 60;
public val OPTIONS_BUTTON_X : Int = HALF_FRAMEX - OPTIONS_BUTTON_WIDTH / 2;
public val OPTIONS_BUTTON_Y : Int = START_BUTTON_Y + START_BUTTON_HEIGHT;

public const val STATS_BUTTON_WIDTH : Int = 200;
public const val STATS_BUTTON_HEIGHT : Int = 60;
public val STATS_BUTTON_X : Int = HALF_FRAMEX - STATS_BUTTON_WIDTH / 2;
public val STATS_BUTTON_Y : Int = OPTIONS_BUTTON_Y + OPTIONS_BUTTON_HEIGHT;

public const val TITLE_WIDTH : Int = 150;
public const val TITLE_HEIGHT : Int = 100;
public val TITLE_X : Int = HALF_FRAMEX - TITLE_WIDTH / 2;
public val TITLE_Y : Int = FRAMEY / 3 - TITLE_HEIGHT / 2;

public val DEFAULT_BUTTON_FONT : Font = Font("Monospaced", BOLD, 16);
public val DEFAULT_BUTTON_COLOR : Color = WHITE;

public val TITLE_FONT : Font = Font("Monospaced", BOLD, 40);
public val TITLE_COLOR : Color = Color.BLACK;

public val ALLOCATED_GRID_WIDTH = FRAMEX * 3 / 4;
public val ALLOCATED_GRID_HEIGHT = FRAMEY * 5 / 6;

public val EXIT_ACTION : Action = {
    println("YOU SHOULD REALLY CREATE SOME SORT OF EXIT MENU YOU KNOW. NOW, IT'S COARSE AND ROUGH.");
    mainFrame.setVisible(false);
    mainFrame.dispatchEvent(WindowEvent(mainFrame, WINDOW_CLOSING));
};

public val START_ACTION : Action = {
    ScreenManager.gameLaunchMenu();
};

public val OPTIONS_ACTION : Action = {
    //TODO
    println("TODO : WRITE OPTIONS ACTION");
};

public val STATS_ACTION : Action = {
    //TODO
    println("TODO : WRITE STATS ACTION");
};







