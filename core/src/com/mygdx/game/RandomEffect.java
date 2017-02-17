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
	private void buildsWall(Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored(); // Stores the roboticon on that tile under rob
		rob.setProductionModifier(0,0,0);
		float x = tile.getOriginX();
		float y = tile.getOriginY();
		tile.setWall(true, x, y);
	}

	/**
	 * Destorys the roboticon on the specific tile
	 * @param players
	 * @param tile
	 */
	private void meteorShower(Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored();
		tile.removeRoboticon(rob);
	}

	/**
	 * The Solar flares make the screen flash white and then production of all tiles is cut in half
	 *
	 * @param player
	 * @param tile
	 */
	private void solarFlares()
	{

	}


	/**
	 *
	 * @param tile
	 */
	private void randomlyChooseEffect(Tile tile)
	{
		Random rand0 = new Random(); 							// If there will be an effect this round
		Random rand1 = new Random(); 							// Randomly choose which effect will be set
		Random rand2 = new Random(); 							// Randomly select a player to effect
		
		
		int random = rand0.nextInt(5);
		
		if(random == 3) 										// If the random number is 3 - basically a 1 in 5 chance the random effect will occur each round
		{
	        int randomNumber = rand1.nextInt(3); 				// Randomly chooses a number between 1 and 3
	        
	        if(randomNumber == 1) 								// If that random number is 1
	        {
	        	buildsWall(tile); 								// Builds the wall around a random tile & stops production
	        }
	        
	        else if(randomNumber == 2) 							// If the random number is 2
	        {
	        	meteorShower(tile); 							// Rains a meteorShower and takes away all of a player's ore
	        }
	        else 
	        {
	        	solarFlares(); 									// Solar Flares 
	        }
		}
	}
}
