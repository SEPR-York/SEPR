package com.mygdx.game;

/*
 * This Class handles the Gambling system of the game
 *@version 1.0.0
 *@author lrj509@york.ac.uk
*/

import java.util.Random;
/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: http://gandhi-inc.me/downloads/assessment3.jar
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
class Gamble{

    /*
    * This Is the price to play a game of roulette, it does not have a modifier
    * as it is not meant to be changed in game.
    * Has been declared static so that an instance of the gamble class is not needed to get the prices since the prices will be constant throughout a whole game.
    */
    static private int PriceToPlayRoulette = 10;

    /*
    * This is the price to play a game of lucky dip, it does not have a modfier
    * as it is not meant to be changed in game.
    * Has been declared static so that an instance of the gamble class is not needed to get the prices since the prices will be constant throughout a whole game.
    */
    static private int PriceToPlayLuckyDip = 10;


    /**
    * This is an accessor for the PriceToPlayRoulette variable.
    * @return PriceToPlayRoulette
    */
    static public int GetPriceToPlayRoulette(){
        return PriceToPlayRoulette;
    }


    /**
    *This is an accessor for the PriceToPlayLuckyDip variable.
    *@return PriceToPlayLuckyDip
    */
    static public int GetPriceToPlayLuckyDip(){
        return PriceToPlayLuckyDip;
    }

    /**
    * The Lucky Dip Game
    * <p>
    * This game is a game where you have a one in tem chance of wining back 10 times your winnings.
    * @return Winning - The amount of money won or lost in the game. posative for a win, negative for a loss.
    */
    public int PlayLuckyDip(){
        Random rand = new Random();
        // Selects a random number between 0 and 9
        int RandomNumber = rand.nextInt(10);
        // If the number 0 then the player wins otherwise the player loses
        if (RandomNumber == 0){
            return(10*GetPriceToPlayLuckyDip());
        }
        else{
            return(-1*GetPriceToPlayLuckyDip());
        }
    }

    /**
    * The Roulette game
    * <p>
    * This game is a game of chance to be played in the game.
    * It takes a number between 0 and 32 as input , the numbers on a roulette
    * wheel, and returns a int relating to the money won or lost.
    * @param UserPickedNumber - The number that the user wishes to pick for the roulette spin.
    * @return Winning - The amount of money won or lost at the game. posative for a min, negative for a loss.
    */
    public int PlayRoulette(int UserPickedNumber){
        // If the number is outside of the bounds 0 - 32 than throw an exception
        if(UserPickedNumber < 0)
        {
            throw new IllegalArgumentException();
        }
        if(UserPickedNumber > 32)
        {
            throw new IllegalArgumentException();
        }
        Random rand = new Random();
        // Othwerise pick a random number
        int RandomNumber = rand.nextInt(33);
        // If the user pick is the same as the random pick then the user wins otherwise they lose
        if (RandomNumber == UserPickedNumber){
            return(GetPriceToPlayRoulette() * 32);
        }
        else{
            return(-1*GetPriceToPlayRoulette());
        }
    }

}
