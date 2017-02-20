package com.mygdx.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GambleTest {

	@Test
	public void DipTest(){
			Gamble g = new Gamble();
			int x = g.PlayLuckyDip();
			assertTrue(x == 100 || x == -10);
		}
	
	@Test
	public void RoulTest(){
			Gamble g = new Gamble();
			int x = g.PlayRoulette(1);
			assertTrue(x == 320 || x == -10);
		}


}
