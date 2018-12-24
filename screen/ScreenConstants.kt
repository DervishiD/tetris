package screen

import java.awt.Color
import java.awt.Color.BLACK
import java.awt.Color.RED
import java.awt.Color.WHITE
import java.awt.Font
import java.awt.Font.BOLD
import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import main.Action
import main.FRAMEX
import main.FRAMEY
import main.HALF_FRAMEX
import main.mainFrame

public const val START_BUTTON_HEIGHT : Int = 60
public val START_BUTTON_Y : Int = FRAMEY * 2 / 3 - START_BUTTON_HEIGHT / 2

public const val NEW_GAME_BUTTON_WIDTH : Int = 200
public const val NEW_GAME_BUTTON_HEIGHT : Int = START_BUTTON_HEIGHT
public val NEW_GAME_BUTTON_X : Int = HALF_FRAMEX - NEW_GAME_BUTTON_WIDTH
public val NEW_GAME_BUTTON_Y : Int = START_BUTTON_Y

public const val LOAD_GAME_BUTTON_WIDTH : Int = 200
public const val LOAD_GAME_BUTTON_HEIGHT : Int = START_BUTTON_HEIGHT
public val LOAD_GAME_BUTTON_X : Int = HALF_FRAMEX
public val LOAD_GAME_BUTTON_Y : Int = START_BUTTON_Y

public const val EXIT_BUTTON_WIDTH : Int = 60
public const val EXIT_BUTTON_HEIGHT : Int = 60
public val EXIT_BUTTON_X : Int = FRAMEX - EXIT_BUTTON_WIDTH
public const val EXIT_BUTTON_Y : Int = 0

public const val OPTIONS_BUTTON_WIDTH : Int = 200
public const val OPTIONS_BUTTON_HEIGHT : Int = 60
public val OPTIONS_BUTTON_X : Int = HALF_FRAMEX - OPTIONS_BUTTON_WIDTH / 2
public val OPTIONS_BUTTON_Y : Int = START_BUTTON_Y + START_BUTTON_HEIGHT

public const val STATS_BUTTON_WIDTH : Int = 200
public const val STATS_BUTTON_HEIGHT : Int = 60
public val STATS_BUTTON_X : Int = HALF_FRAMEX - STATS_BUTTON_WIDTH / 2
public val STATS_BUTTON_Y : Int = OPTIONS_BUTTON_Y + OPTIONS_BUTTON_HEIGHT

public const val BACK_BUTTON_WIDTH : Int = 60
public const val BACK_BUTTON_HEIGHT : Int = 60
public val BACK_BUTTON_X : Int = FRAMEX - BACK_BUTTON_WIDTH
public const val BACK_BUTTON_Y : Int = 0

public const val TITLE_WIDTH : Int = 150
public const val TITLE_HEIGHT : Int = 100
public val TITLE_X : Int = HALF_FRAMEX - TITLE_WIDTH / 2
public val TITLE_Y : Int = FRAMEY / 3 - TITLE_HEIGHT / 2

public val EXIT_WIDTH : Int = FRAMEX
public const val EXIT_HEIGHT : Int = 100
public const val EXIT_X : Int = 0
public val EXIT_Y : Int = FRAMEY / 5

public const val CONFIRM_EXIT_BUTTON_WIDTH : Int = 200
public const val CONFIRM_EXIT_BUTTON_HEIGHT : Int = 60
public val CONFIRM_EXIT_BUTTON_X : Int = FRAMEX / 4 - CONFIRM_EXIT_BUTTON_WIDTH
public val CONFIRM_EXIT_BUTTON_Y : Int = FRAMEY / 2 - CONFIRM_EXIT_BUTTON_HEIGHT

public const val DISMISS_EXIT_BUTTON_WIDTH : Int = 200
public const val DISMISS_EXIT_BUTTON_HEIGHT : Int = 60
public val DISMISS_EXIT_BUTTON_X : Int = 3 * FRAMEX / 4 - DISMISS_EXIT_BUTTON_WIDTH / 2
public val DISMISS_EXIT_BUTTON_Y : Int = FRAMEY / 2 - DISMISS_EXIT_BUTTON_HEIGHT / 2

public val DEFAULT_BUTTON_FONT : Font = Font("Monospaced", BOLD, 16)
public val DEFAULT_BUTTON_COLOR : Color = WHITE
public val UNFOCUS_BUTTON_TEXT_COLOR : Color = BLACK
public val FOCUS_BUTTON_TEXT_COLOR : Color = RED

public val TITLE_FONT : Font = Font("Monospaced", BOLD, 40)
public val TITLE_COLOR : Color = Color.BLACK

public val EXIT_FONT : Font = Font("Monospaced", BOLD, 24)
public val EXIT_COLOR : Color = Color.BLACK

public val ALLOCATED_GRID_WIDTH = FRAMEX * 3 / 4
public val ALLOCATED_GRID_HEIGHT = FRAMEY * 5 / 6

public val EXIT_ACTION : Action = {
    ScreenManager.setScreen(exitScreen)
};

public val NEW_GAME_ACTION : Action = {
    ScreenManager.setScreen(newGameScreen)
}

public val LOAD_GAME_ACTION : Action = {
    //TODO
    println("TODO -- LOAD GAME ACTION")
}

public val OPTIONS_ACTION : Action = {
    //TODO
    println("TODO : WRITE OPTIONS ACTION")
}

public val STATS_ACTION : Action = {
    //TODO
    println("TODO : WRITE STATS ACTION")
}

public val BACK_ACTION : Action = {
    ScreenManager.toPreviousScreen()
}

public val CONFIRM_EXIT_ACTION : Action = {
    mainFrame.isVisible = false
    mainFrame.dispatchEvent(WindowEvent(mainFrame, WINDOW_CLOSING))
}




