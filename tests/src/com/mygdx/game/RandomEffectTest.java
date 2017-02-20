package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.RandomEffect;
import static org.junit.Assert.*;

import org.junit.Test;

public class RandomEffectTest extends TesterFile {
	private Game dummyGame = new Main();
	private Player dummyPlayer = new Player(1, "Dummy");
	RandomEffect testEffects = new RandomEffect();

	@Test
	public void wallTest() {
		Tile dummyTile = new Tile(dummyGame, 0, 5, 5, 5, false, new Runnable() {
	        @Override
	        public void run() {}});
		Roboticon dummyBot = new Roboticon(0, dummyPlayer, dummyTile);
		
		testEffects.buildsWall(dummyTile);
		
		assertEquals(dummyTile.hasWall(), true);
		assertEquals(dummyTile.getResources(), new int[] {0,0,0});
		assertEquals(dummyBot.getLevel(), new int[] {0,0,0});
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
		assertEquals(halfBeforeRes, afterRes);
	}
}
