package com.mygdx.game;

import java.util.Random;

public class RandomEffect
{
	/**
	 * Donald Trump decides to build a wall - we stop all production of the roboticon on a specific tile
	 * There is a wall built around their tile and a Mexican flag appears
	 * @param player
	 * @param tile
	 */
	private void buildsWall(Player Player[], Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored(); // Stores the roboticon on that tile under rob
		rob.setProductionModifier(0,0,0);

	}

	/**
<<<<<<< HEAD
	 * The meteor shower will damage the production of a tile. This means the
	 * @param player
=======
	 * The meteor shower will damage the production of a tile. This means the 
	 * @param players
>>>>>>> 3a95b71f0fcbe1578d06669fd35568e773fdc920
	 * @param tile
	 */
	private void meteorShower(Player[] players, Tile tile)
	{

	}

	/**
	 * The Solar flares make the screen flash white and then production of all tiles is cut in half
	 *
	 * @param player
	 * @param tile
	 */
	private void solarFlares(Player[] player, Tile tile)
	{

	}
<<<<<<< HEAD

	private Player choosePlayer()
	{
		return null;
	}

=======
	
	
>>>>>>> 3a95b71f0fcbe1578d06669fd35568e773fdc920
	/**
	 *
	 * @param player
	 * @param tile
	 */
	private void randomlyChooseEffect(Player[] players, Tile tile)
	{
		Random rand0 = new Random(); //If there will be an effect this round
		Random rand1 = new Random(); //Randomly choose which effect will be set
		Random rand2 = new Random(); //Randomly select a player to effect
		
		//int randomPlayerSelect = rand2.nextInt(2);
		//Player randomPlayer = Player[randomPlayerSelect];
		
        int randomNumber = rand1.nextInt(3);
        
        if(randomNumber == 1)
        {
        	buildsWall(players, tile);
        }
        
        else if(randomNumber == 2)
        {
        	meteorShower(players, tile);
        }
        else
        {
        	solarFlares(players, tile);
        }
	}
}
