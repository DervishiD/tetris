package display.screen

import display.*
import display.button.Selector
import ioManager.readBestScores
import ioManager.readLastScores
import main.FRAMEX
import main.FRAMEY
import main.Key
import main.Key.*
import main.textColor
import java.awt.Graphics

class StatsScreen : Screen() {

    companion object {
        @JvmStatic private val BASE_LIST_Y = FRAMEY * 2 / 5
        @JvmStatic private val DELTA_Y_LIST = (FRAMEY - BASE_LIST_Y) / 12
        @JvmStatic private val DELTA_Y_STATS = (FRAMEY - BASE_LIST_Y) / 8
    }

    private var currentN : Int = 4
    private var bestScores : ArrayList<Int>
    private var lastScores : ArrayList<Int>
    private var bestMean : Int
    private var lastMean : Int
    private var lastTenMean : Int

    private var focusedSelector : Selector? = statsSelector

    init{
        previousScreen = startMenu
        bestScores = readBestScores(currentN)
        lastScores = readLastScores(currentN)
        bestMean = computeBestMean()
        lastMean = computeLastMean()
        lastTenMean = computeLastTenMean()

        addButton(statsSelector)
        addButton(backButton)
        this.add(statsLabel)

        statsSelector.focus()
        statsSelector.activate()

    }

    private fun computeBestMean() : Int{
        return if(bestScores.size == 0) 0 else{
            var sum : Int = 0
            for(k : Int in bestScores){
                sum += k
            }
            sum / bestScores.size
        }
    }

    private fun computeLastTenMean() : Int{
        return if(lastScores.size == 0) 0 else{
            var sum : Int = 0
            val size : Int = if(lastScores.size < 10) lastScores.size else 10
            for(k : Int in 0 until size){
                sum += lastScores[k]
            }
            sum / size
        }
    }

    private fun computeLastMean() : Int{
        return if(lastScores.size == 0) 0 else{
            var sum : Int = 0
            for(k : Int in lastScores){
                sum += k
            }
            sum / lastScores.size
        }
    }

    public override fun reactTo(key: Key) {
        when(key){
            ESCAPE ->
                if(focusedSelector == null){
                    BACK_ACTION.invoke()
                }else{
                    focusedSelector!!.unfocus()
                    focusedSelector!!.deactivate()
                    focusedSelector = null
                }
            ENTER ->
                if(currentButton() is Selector){
                    if(focusedSelector == null){
                        focusedSelector = currentButton() as Selector
                        focusedSelector!!.activate()
                    }else{
                        focusedSelector!!.deactivate()
                        focusedSelector = null
                    }
                }else{
                    clickButton()
                    focusedSelector?.unfocus()
                    focusedSelector = null
                }
            UP ->
                if(focusedSelector == null){
                    previousButton()
                }
            DOWN ->
                if(focusedSelector == null){
                    nextButton()
                }
            LEFT ->
                if(focusedSelector != null){
                    focusedSelector!!.previous()
                    refreshData()
                }else{
                    previousButton()
                }
            RIGHT ->
                if(focusedSelector != null){
                    focusedSelector!!.next()
                    refreshData()
                }else{
                    nextButton()
                }
        }
    }

    public fun refreshData(){
        currentN = statsSelector.selectedOption().toInt()
        bestScores = readBestScores(currentN)
        lastScores = readLastScores(currentN)
        bestMean = computeBestMean()
        lastMean = computeLastMean()
        lastTenMean = computeLastTenMean()
    }

    public override fun save() {
        bestScores = readBestScores(4)
        lastScores = readLastScores(4)
        statsSelector.reset()
        resetList()
    }

    public override fun paintComponent(g: Graphics?) {
        g!!.color = background
        g.fillRect(0, 0 , FRAMEX, FRAMEY)
        g.color = textColor
        writeBestScores(g)
        writeLastTenScores(g)
        writeStats(g)
    }

    private fun writeBestScores(g : Graphics){
        g.font = QUESTION_FONT
        g.drawString("Best Scores", 5, BASE_LIST_Y)
        g.font = DEFAULT_BUTTON_FONT
        for(k : Int in 0 until bestScores.size){
            g.drawString(bestScores[k].toString(), 5, BASE_LIST_Y + (k + 1) * DELTA_Y_LIST)
        }
    }

    private fun writeLastTenScores(g : Graphics){
        g.font = QUESTION_FONT
        g.drawString("Last ten scores", FRAMEX / 3, BASE_LIST_Y)
        g.font = DEFAULT_BUTTON_FONT
        for(k : Int in 0 until if(lastScores.size < 10) lastScores.size else 10){
            g.drawString(lastScores[k].toString(), FRAMEX / 3, BASE_LIST_Y + (k + 1) * DELTA_Y_LIST)
        }
    }

    private fun writeStats(g : Graphics){
        g.font = QUESTION_FONT
        g.drawString("Best mean", FRAMEX * 2 / 3, BASE_LIST_Y)
        g.font = DEFAULT_BUTTON_FONT
        g.drawString(bestMean.toString(), FRAMEX * 2 / 3, BASE_LIST_Y + DELTA_Y_STATS)

        g.font = QUESTION_FONT
        g.drawString("Last ten mean", FRAMEX * 2 / 3, BASE_LIST_Y + 2 * DELTA_Y_STATS)
        g.font = DEFAULT_BUTTON_FONT
        g.drawString(lastTenMean.toString(), FRAMEX * 2 / 3, BASE_LIST_Y + 3 * DELTA_Y_STATS)

        g.font = QUESTION_FONT
        g.drawString("Last 500 mean", FRAMEX * 2 / 3, BASE_LIST_Y + 4 * DELTA_Y_STATS)
        g.font = DEFAULT_BUTTON_FONT
        g.drawString(lastMean.toString(), FRAMEX * 2 / 3, BASE_LIST_Y + 5 * DELTA_Y_STATS)
    }

}