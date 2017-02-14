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
	private void buildsWall(Player player, Tile tile)
	{
		Roboticon rob = tile.getRoboticonStored(); // Stores the roboticon on that tile under rob
		rob.setProductionModifier(0,0,0);

	}

	/**
	 * The meteor shower will damage the production of a tile. This means the
	 * @param player
	 * @param tile
	 */
	private void meteorShower(Player player, Tile tile)
	{

	}

	/**
	 * The Solar flares make the screen flash white and then production of all tiles is cut in half
	 *
	 * @param player
	 * @param tile
	 */
	private void solarFlares(Player player, Tile tile)
	{

	}

	private Player choosePlayer()
	{
		return null;
	}

	/**
	 *
	 * @param player
	 * @param tile
	 */
	private void randomlyChooseEffect(Player player, Tile tile)
	{
		Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        if(randomNumber == 1)
        {
        	buildsWall(player, tile);
        }
        else if(randomNumber == 2)
        {
        	meteorShower(player, tile);
        }
        else
        {
        	solarFlares(player, tile);
        }
	}
}
