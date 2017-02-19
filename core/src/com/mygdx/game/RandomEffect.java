package com.mygdx.game;

import java.util.Random;

public class RandomEffect
{
	/**
	 * Donald Trump decides to build a wall - we stop all production of the roboticon on a specific tile
	 * There is a wall built around their tile and a Mexican flag appears
	 * @param tile
	 */
	private void buildsWall(Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored(); 			// Stores the roboticon on that tile under rob
		rob.setProductionModifier(0,0,0);					// Set the production of that roboticon to 0 for all elements
		tile.hasWall();										// Get the tile to build the wall and set value to TRUE
	}

	/**
	 * Destorys the roboticon on the specific tile
	 * @param players
	 * @param tile
	 */
	private void meteorShower(Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored();			// Find the roboticon on that tile
		tile.removeRoboticon(rob);							// Remove the roboticon from that tile
		tile.hasMeteor();									// Get the tile to build the meteor logo
	}

	/**
	 * The Solar flares make the screen flash white and then production of that tile is stoped for one round
	 *
	 * @param tile
	 */
	private void solarFlares(Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored();			// Find the roboticon stored on the tile
		//rob.setProductionModifier(0, 0, 0);					// Set the production of that tile to 0 for the round
		tile.hasSolarFlare();								// Get the tile to build the solar flare on it
	}


	/**
	 *
	 * @param tile
	 */
	private void randomlyChooseEffect(Player player)
	{
		Random rand0 = new Random(); 						// If there will be an effect this round
		Random rand1 = new Random(); 						// Randomly choose which effect will be set
		Random rand2 = new Random(); 						// Randomly select a player to effect
		
		int randomTile = rand2.nextInt(player.getTileList().size());
		Tile tile = player.getTileList().get(randomTile);
		
		int random = rand0.nextInt(5);

		if(random == 3) 									// If the random number is 3 - basically a 1 in 5 chance the random effect will occur each round
		{
	        int randomNumber = rand1.nextInt(3); 			// Randomly chooses a number between 1 and 3

	        if(randomNumber == 1) 							// If that random number is 1
	        {
	        	buildsWall(tile); 							// Builds the wall around a random tile & stops production
	        }

	        else if(randomNumber == 2) 						// If the random number is 2
	        {
	        	meteorShower(tile); 						// Rains a meteorShower and takes away all of a player's ore
	        }
	        else
	        {
	        	solarFlares(tile); 							// Solar Flares
	        }
		}
	}
}
