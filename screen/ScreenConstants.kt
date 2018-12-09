package screen

import java.awt.Font
import java.awt.Font.PLAIN
import main.HALF_FRAMEX
import main.FRAMEX
import main.FRAMEY

public const val START_BUTTON_WIDTH : Int = 200;
public const val START_BUTTON_HEIGHT : Int = 60;
public const val START_BUTTON_X : Int = HALF_FRAMEX - START_BUTTON_WIDTH / 2;
public const val START_BUTTON_Y : Int = FRAMEY * 2 / 3 - START_BUTTON_HEIGHT / 2;

public const val EXIT_BUTTON_WIDTH : Int = 60;
public const val EXIT_BUTTON_HEIGHT : Int = 60;
public const val EXIT_BUTTON_X : Int = FRAMEX - EXIT_BUTTON_WIDTH;
public const val EXIT_BUTTON_Y : Int = 0;

public const val OPTIONS_BUTTON_WIDTH : Int = 200;
public const val OPTIONS_BUTTON_HEIGHT : Int = 60;
public const val OPTIONS_BUTTON_X : Int = HALF_FRAMEX - OPTIONS_BUTTON_WIDTH / 2;
public const val OPTIONS_BUTTON_Y : Int = START_BUTTON_Y + START_BUTTON_HEIGHT;

public const val STATS_BUTTON_WIDTH : Int = 200;
public const val STATS_BUTTON_HEIGHT : Int = 60;
public const val STATS_BUTTON_X : Int = HALF_FRAMEX - STATS_BUTTON_WIDTH / 2;
public const val STATS_BUTTON_Y : Int = OPTIONS_BUTTON_Y + OPTIONS_BUTTON_HEIGHT;

public val DEFAULT_BUTTON_FONT : Font = Font("Arial", PLAIN, 16);






