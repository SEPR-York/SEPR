package com.mygdx.game;

/*
 * This Class handles the Gambling system of the game
 *@version 1.0.0
 *@author lrj509@york.ac.uk
*/

import java.util.Random;

class Gamble{

    public static void main(String args[]){

        Gamble bla = new Gamble();
        System.out.println(bla.PlayLuckyDip());
        System.out.println(bla.PlayRoulette(10));
        System.out.println("It Works");
    }

/*
 *This Is the price to play a game of roulette, it does not have a modifier
 *as it is not meant to be changed in game.
 */

    static private int PriceToPlayRoulette = 10;

/*
 *This is the price to play a game of lucky dip, it does not have a modfier
 * as it is not meant to be changed in game.
 */

    static private int PriceToPlayLuckyDip = 10;


/*
 *This is an accessor for the PriceToPlayRoulette variable.
 *@return PriceToPlayRoulette
 */

    static public int GetPriceToPlayRoulette(){
        return PriceToPlayRoulette;
    }


/*
 *This is an accessor for the PriceToPlayLuckyDip variable.
 *@return PriceToPlayLuckyDip
 */

    static public int GetPriceToPlayLuckyDip(){
        return PriceToPlayLuckyDip;
    }


/*
 *The Roulette game
 *<p>
 *This game is a game of chance to be played in the game.
 * It takes a number between 0 and 32 as input , the numbers on a roulette
 *wheel, and returns a int relating to the money won or lost.
 *@param UserPickedNumber - The number that the user wishes to pick for the roulette spin.
 *@return Winning - The amount of money won or lost at the game. posative for a min, negative for a loss.
 */

    public int PlayRoulette(int UserPickedNumber){
        if(UserPickedNumber < 0) throw new IllegalArgumentException();
        if(UserPickedNumber > 32) throw new IllegalArgumentException();
        Random rand = new Random();
        int RandomNumber = rand.nextInt(33);
        if (RandomNumber == UserPickedNumber){
            return(GetPriceToPlayRoulette() * 32);
        }
        else{
            return(-1*GetPriceToPlayRoulette());
        }
    }

/*
 *The Lucky Dip Game
 *<p>
 *This game is a game where you have a one in tem chance of wining back 10 times your winnings.
 *@return Winning - The amount of money won or lost in the game. posative for a win, negative for a loss.
 */

    public int PlayLuckyDip(){
        Random rand = new Random();
        int RandomNumber = rand.nextInt(10);
        if (RandomNumber == 0){
            return(10*GetPriceToPlayLuckyDip());
        }
        else{
            return(-1*GetPriceToPlayLuckyDip());
        }

    }
}
