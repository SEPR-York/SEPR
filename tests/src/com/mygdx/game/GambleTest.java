package com.mygdx.game;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: http://gandhi-inc.me/downloads/assessment3.jar
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */

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
