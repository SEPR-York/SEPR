package com.mygdx.game;

import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.badlogic.gdx.scenes.scene2d.ui.Window;
/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: ____________
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
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
		tile.changeOreCount(0);
		tile.changeEnergyCount(0);
		tile.changeFoodCount(0);
		rob.setProductionModifier(0, 0, 0);					// Set the production of that roboticon to 0 for all elements
		tile.setWall();										// Get the tile to build the wall and set value to TRUE
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
		tile.setMeteor();									// Get the tile to build the meteor logo
	}

	/**
	 * The Solar flare divides a player's resource by 2
	 *
	 * @param tile
	 */
	private void solarFlares(Tile tile)
	{
		Player player = tile.getOwner();
		player.setFoodCount(player.getFoodCount()/2);
		player.setEnergyCount(player.getEnergyCount()/2);
		player.setOreCount(player.getOreCount()/2);
		tile.setSolarFlare();								// Get the tile to build the solar flare on it
	}


	/**
	 *
	 * @param tile
	 */
	public void randomlyChooseEffect(Player player)
	{
		Random rand0 = new Random(); 						// If there will be an effect this round
		Random rand1 = new Random(); 						// Randomly choose which effect will be set
		Random rand2 = new Random(); 						// Randomly select a player to effect

		int randomTile = rand2.nextInt(player.getTileList().size());
		Tile tile = player.getTileList().get(randomTile);

		int random = 1;//rand0.nextInt(3);

		if(random == 1 && tile.hasRoboticon()) 				// If the random number is 1 - basically a 1 in 5 chance the random effect will occur each round
		{
	        int randomNumber = 1 ; //rand1.nextInt(3); 			// Randomly chooses a number between 1 and 3

	        if(randomNumber == 1) 							// If that random number is 1
	        {
	        	System.out.println("Builds a wall!");
	        	JOptionPane optionPane = new JOptionPane();
	        	JDialog trumpDialog = optionPane.createDialog("Trump has built a wall! Looks like you will no longer be able to produce resources!");
	        	trumpDialog.setAlwaysOnTop(true);
	        	trumpDialog.setVisible(true);
	        	//optionPane.showMessageDialog(null, "Trump has built a wall! Looks like you will no longer be able to produce resources!", "Trump!", JOptionPane.PLAIN_MESSAGE);
	        	
	        	
	        	buildsWall(tile); 							// Builds the wall around a random tile & stops production
	        }

	        else if(randomNumber == 2) 						// If the random number is 2
	        {
	        	System.out.println("Meteor strike!");
	            JOptionPane.showMessageDialog(null, "Meteor Strike! No roboticons have survived on that tile!", "Meteor Strike!", JOptionPane.PLAIN_MESSAGE);
	        	meteorShower(tile); 						// Rains a meteorShower and takes away all of a player's ore
	        }
	        else
	        {
	        	System.out.println("Solar flares!");
	            JOptionPane.showMessageDialog(null, "Solar flares! Half your resources have now been stolen!", "Solar Flares!", JOptionPane.PLAIN_MESSAGE);
	        	solarFlares(tile); 							// Solar Flares
	        }
		}
	}
}
