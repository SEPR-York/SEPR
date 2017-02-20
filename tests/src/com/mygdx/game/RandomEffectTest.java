package com.mygdx.game;

import com.badlogic.gdx.Game;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: http://gandhi-inc.me/downloads/assessment3.jar
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
public class RandomEffectTest extends TesterFile {
	private Game dummyGame = new Main();
	private Player dummyPlayer = new Player(1, "Dummy");
	RandomEffect testEffects = new RandomEffect();

	@Test
	public void wallTest() 
	{
		Tile dummyTile = new Tile(dummyGame, 0, 5, 5, 5, false, new Runnable() 
		{
	        @Override
	        public void run() {}
	    });
		Roboticon dummyBot = new Roboticon(0, dummyPlayer, dummyTile);
		
		testEffects.buildsWall(dummyTile);
		
		int[] newRes = dummyTile.getResources();
		int[] newLvl = dummyBot.getLevel();
		assertEquals(dummyTile.hasWall(), true);
		assertTrue(newRes[0]==0 && newRes[1]==0 && newRes[2]==0);
		assertTrue(newLvl[0]==0 && newLvl[1]==0 && newLvl[2]==0);
	}

	@Test
	public void meteorTest() {
		Tile dummyTile = new Tile(dummyGame, 0, 5, 5, 5, false, new Runnable() {
	        @Override
	        public void run() {}});
		Roboticon dummyBot = new Roboticon(0, dummyPlayer, dummyTile);
		
		assertEquals(dummyTile.getRoboticonStored(), dummyBot);
		
		testEffects.meteorShower(dummyTile);
		
		assertEquals(dummyTile.getRoboticonStored(), null);
	}
	
	@Test
	public void solarTest() {
		Tile dummyTile = new Tile(dummyGame, 0, 5, 5, 5, false, new Runnable() {
	        @Override
	        public void run() {}});
		
		int[] halfBeforeRes = new int[] {dummyPlayer.getFoodCount()/2, dummyPlayer.getOreCount()/2, dummyPlayer.getEnergyCount()/2};
		
		testEffects.solarFlares(dummyTile);
		
		int[] afterRes = new int[] {dummyPlayer.getFoodCount(), dummyPlayer.getOreCount(), dummyPlayer.getEnergyCount()};
		assertTrue(halfBeforeRes[0]==afterRes[0]);
		assertTrue(halfBeforeRes[1]==afterRes[1]);
		assertTrue(halfBeforeRes[2]==afterRes[2]);
	}
}
