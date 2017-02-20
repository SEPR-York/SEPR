package com.mygdx.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GambleTest {

	@Test
	public void DipTest(){
			Gamble g = new Gamble();
			assertTrue(g.PlayLuckyDip() == 100 || g.PlayLuckyDip() == -10);
			assertTrue(g.PlayRoulette(1) == 100 || g.PlayRoulette(1) == -10);
		}

}
