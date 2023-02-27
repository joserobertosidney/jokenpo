package com.example.jokenpo2

import kotlin.random.Random

enum class Result{
    WIN, DRAW, LOSS
}

class JokenpoEngine(private val avaiablePlays: Array<String>) {

    fun calculateResults( playerPlay: String) : Result{
        val aiPlay = getAIPlay()

       return when {
            playerPlay == aiPlay -> Result.DRAW
            playerPlay == "Pedra" && aiPlay == "Tesoura" -> Result.WIN
            playerPlay == "Pedra" && aiPlay == "Papel" -> Result.LOSS
            playerPlay == "Papel" && aiPlay == "Pedra" -> Result.WIN
            playerPlay == "Papel" && aiPlay == "Tesoura" -> Result.LOSS
            playerPlay == "Tesoura" && aiPlay == "Papel" -> Result.WIN
            else -> Result.LOSS
        }
    }

    fun getAIPlay(): String {
        val playIndex = Random.nextInt(0,2)
        return avaiablePlays[playIndex]
    }

}