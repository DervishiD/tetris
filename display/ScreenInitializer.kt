package display

import display.button.Button
import display.button.Selector
import display.button.Slider
import display.screen.*
import game.possibleN

//SCREENS-----------------------------------------

public val startMenu : MainMenuScreen by lazy{ MainMenuScreen() }
public val newGameScreen : NewGameScreen by lazy{ NewGameScreen() }
public val exitScreen : ExitScreen by lazy{ ExitScreen() }
public val optionsScreen : OptionsScreen by lazy{ OptionsScreen() }

//BUTTONS-----------------------------------------

public val exitButton : Button by lazy{ Button(EXIT_ACTION, EXIT_BUTTON_X, EXIT_BUTTON_Y, "X") }
public val backButton : Button by lazy{ Button(BACK_ACTION, BACK_BUTTON_X, BACK_BUTTON_Y, "<-") }

public val newGameButton : Button by lazy{ Button(NEW_GAME_ACTION, NEW_GAME_BUTTON_X, NEW_GAME_BUTTON_Y, "New Game") }
public val loadGameButton : Button by lazy{ Button(LOAD_GAME_ACTION, LOAD_GAME_BUTTON_X, LOAD_GAME_BUTTON_Y, "Load Game") }
public val optionsButton : Button by lazy{ Button(OPTIONS_ACTION, OPTIONS_BUTTON_X, OPTIONS_BUTTON_Y, "Options") }
public val statsButton : Button by lazy{ Button(STATS_ACTION, STATS_BUTTON_X, STATS_BUTTON_Y, "Stats") }

public val confirmExitButton : Button by lazy{ Button(CONFIRM_EXIT_ACTION, CONFIRM_EXIT_BUTTON_X, CONFIRM_EXIT_BUTTON_Y, "Confirm") }
public val dismissExitButton : Button by lazy{ Button(BACK_ACTION, DISMISS_EXIT_BUTTON_X, DISMISS_EXIT_BUTTON_Y, "Dismiss") }

public val startButton : Button by lazy{ Button(START_ACTION, START_BUTTON_X, START_BUTTON_Y, "Start new game") }

public val nightColorButton : Button by lazy{ Button(NIGHT_COLOR_ACTION, NIGHT_COLOR_X, NIGHT_COLOR_Y, "Night mode") }

public val resumeButton : Button by lazy{ Button(RESUME_ACTION, RESUME_BUTTON_X, RESUME_BUTTON_Y, "Resume") }
public val saveAndQuitButton : Button by lazy{ Button(SAVE_QUIT_ACTION, SAVE_QUIT_BUTTON_X, SAVE_QUIT_BUTTON_Y, "Save and quit") }

public val backToMainMenuButton : Button by lazy{Button(BACK_ACTION, BACK_TO_MAIN_MENU_X, BACK_TO_MAIN_MENU_Y, "Back to main menu")}

//SELECTORS-----------------------------------------

public val nSelector : Selector by lazy{ Selector(N_SELECTOR_X, N_SELECTOR_Y, possibleN()) } //TODO -- REFACTOR LIST

//SLIDERS ------------------------------------------

public val rSlider : Selector by lazy { Slider(R_SELECTOR_Y, COLOR_ARGUMENTS) }
public val gSlider : Selector by lazy { Slider(G_SELECTOR_Y, COLOR_ARGUMENTS) }
public val bSlider : Selector by lazy { Slider(B_SELECTOR_Y, COLOR_ARGUMENTS) }

//LABELS--------------------------------------------

public val titleLabel : Text by lazy{Text("TETRIS", TITLE_FONT, TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT)}

public val nQuestion : Text by lazy{Text("Number of blocks per polynomios", QUESTION_FONT, N_QU_X, N_QU_Y, N_QU_WIDTH, N_QU_HEIGHT)}

public val exitQuestion : Text by lazy{Text("Are you sure you want to quit?", QUESTION_FONT, EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT)}

public val optionsLabel : Text by lazy{Text("OPTIONS", QUESTION_FONT, OPTIONS_LABEL_X, OPTIONS_LABEL_Y, OPTIONS_LABEL_WIDTH, OPTIONS_LABEL_HEIGHT)}

public val rLabel : Text by lazy{Text("Red", QUESTION_FONT, R_LABEL_X, R_LABEL_Y, R_LABEL_WIDTH, R_LABEL_HEIGHT)}

public val gLabel : Text by lazy{Text("Green", QUESTION_FONT, G_LABEL_X, G_LABEL_Y, G_LABEL_WIDTH, G_LABEL_HEIGHT)}

public val bLabel : Text by lazy{Text("Blue", QUESTION_FONT, B_LABEL_X, B_LABEL_Y, B_LABEL_WIDTH, B_LABEL_HEIGHT)}

public val pauseLabel : Text by lazy{Text("Pause", QUESTION_FONT, PAUSE_LABEL_X, PAUSE_LABEL_Y, PAUSE_LABEL_WIDTH, PAUSE_LABEL_HEIGHT)}



