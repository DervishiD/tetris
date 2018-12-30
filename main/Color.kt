package main

import java.awt.Color
import java.awt.Color.BLACK
import java.awt.Color.GREEN
import java.awt.Color.RED
import java.awt.Color.WHITE
import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.random.Random
import kotlin.random.nextInt

private const val MINIMAL_DISTANCE = 75
private const val MAXIMAL_NIGHT_DISTANCE = 125

private fun dRed(c1 : Color, c2 : Color) : Double{
    return abs(c1.red - c2.red).toDouble()
}

private fun dGreen(c1 : Color, c2 : Color) : Double{
    return abs(c1.green - c2.green).toDouble()
}

private fun dBlue(c1 : Color, c2 : Color) : Double{
    return abs(c1.blue - c2.blue).toDouble()
}

public fun distance(c1 : Color, c2 : Color) : Double{
    return sqrt(dRed(c1, c2) * dRed(c1, c2) + dGreen(c1, c2) * dGreen(c1, c2) + dBlue(c1, c2) * dBlue(c1, c2))
}

public fun setTextColor(){
    textColor = if(distance(backgroundColor, BLACK) > distance(backgroundColor, WHITE)) BLACK else WHITE
}

public fun setFocusColor(){
    focusColor = if(distance(backgroundColor, GREEN) > distance(backgroundColor, RED)) GREEN else RED
}

public fun randomVisibleColor() : Color{
    var r = Random.nextInt(0, 255)
    var g = Random.nextInt(0, 255)
    var b = Random.nextInt(0, 255)
    var c : Color = Color(r, g, b)
    return if(distance(c, backgroundColor) < MINIMAL_DISTANCE || (nightMode && distance(c, backgroundColor) > MAXIMAL_NIGHT_DISTANCE))
               randomVisibleColor()
           else c
}
