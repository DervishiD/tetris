package screen

import java.awt.Color
import java.awt.Color.BLACK
import java.awt.Color.RED
import java.awt.Font
import java.awt.Font.BOLD
import java.awt.event.WindowEvent
import java.awt.event.WindowEvent.WINDOW_CLOSING
import main.Action
import main.FRAMEX
import main.FRAMEY
import main.mainFrame

public val NEW_GAME_BUTTON_X : Int = FRAMEX / 3
public val NEW_GAME_BUTTON_Y : Int = FRAMEY * 3 / 5

public val LOAD_GAME_BUTTON_X : Int = FRAMEX * 2 / 3
public val LOAD_GAME_BUTTON_Y : Int = NEW_GAME_BUTTON_Y

public val EXIT_BUTTON_X : Int = FRAMEX - 14 //HARDCODED
public const val EXIT_BUTTON_Y : Int = 14 //HARDCODED

public val OPTIONS_BUTTON_X : Int = NEW_GAME_BUTTON_X
public val OPTIONS_BUTTON_Y : Int = FRAMEY * 4 / 5

public val STATS_BUTTON_X : Int = LOAD_GAME_BUTTON_X
public val STATS_BUTTON_Y : Int = OPTIONS_BUTTON_Y

public val BACK_BUTTON_X : Int = FRAMEX - 20 //HARDCODED
public const val BACK_BUTTON_Y : Int = 14 //HARDCODED

public const val TITLE_WIDTH : Int = 150
public const val TITLE_HEIGHT : Int = 100                   //EVENTUALLY REWRITE THE TITLE ANYWAY
public val TITLE_X : Int = FRAMEX / 2 - TITLE_WIDTH / 2
public val TITLE_Y : Int = FRAMEY / 3 - TITLE_HEIGHT / 2

public val EXIT_WIDTH : Int = FRAMEX
public const val EXIT_HEIGHT : Int = 100                    //EVENTUALLY REWRITE THE QUESTION ANYWAY
public const val EXIT_X : Int = 0
public val EXIT_Y : Int = FRAMEY / 5

public val CONFIRM_EXIT_BUTTON_X : Int = FRAMEX / 4
public val CONFIRM_EXIT_BUTTON_Y : Int = FRAMEY * 3 / 5

public val DISMISS_EXIT_BUTTON_X : Int = FRAMEX * 3 / 4
public val DISMISS_EXIT_BUTTON_Y : Int = CONFIRM_EXIT_BUTTON_Y

public val DEFAULT_BUTTON_FONT : Font = Font("Monospaced", BOLD, 24)
public val UNFOCUS_BUTTON_TEXT_COLOR : Color = BLACK
public val FOCUS_BUTTON_TEXT_COLOR : Color = RED            //EVENTUALLY REWRITE THE COLORS ENTIRELY WITH DELTAS

public val TITLE_FONT : Font = Font("Monospaced", BOLD, 40)
public val TITLE_COLOR : Color = Color.BLACK                //EVENTUALLY REWRITE THE TITLE ANYWAY

public val QUESTION_FONT : Font = Font("Monospaced", BOLD, 24)
public val QUESTION_COLOR : Color = Color.BLACK                 //EVENTUALLY REWRITE THE QUESTIONS ANYWAY

public val N_QU_WIDTH : Int = FRAMEX
public const val N_QU_HEIGHT : Int = 100                    //EVENTUALLY REWRITE THE QUESTION ANYWAY
public const val N_QU_X : Int = 0
public val N_QU_Y : Int = FRAMEY / 4

public val N_SELECTOR_X : Int = FRAMEX / 2
public val N_SELECTOR_Y : Int = FRAMEY / 3

public val START_BUTTON_X : Int = N_SELECTOR_X
public val START_BUTTON_Y : Int = FRAMEY / 2

public val ALLOCATED_GRID_WIDTH = FRAMEX * 3 / 4
public val ALLOCATED_GRID_HEIGHT = FRAMEY * 5 / 6

public val EXIT_ACTION : Action = {
    ScreenManager.setScreen(exitScreen)
}

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

public val START_ACTION : Action = {println("TODO -- START BUTTON ACTION")}



