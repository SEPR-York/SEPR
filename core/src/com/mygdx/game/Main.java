package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * @author Duck Related Team Name in Big Massive Letters
 * @version Assessment 2
 *          <p>
 *          An executable version of the game can be found at: https://jm179796.github.io/SEPR/DRTN-Assessment2.jar
 *          Our website is: https://jm179796.github.io/SEPR/
 * @since Assessment 2
 */
public class Main extends Game {
	/**
	 * Core game-state that enables the game to interact with the renderer and switch between screens
	 */
	private Game game;

	/**
	 * Class constructor that instantiates a game-state for the very first time
	 */
	public Main() {
		game = this;
	}

	/**
	 * Automatically set the game-state to load the splash-screen as soon as the game window opens
	 */
	@Override
	public void create () {
		System.out.println("Create");
		setScreen(new SplashScreen(game));
		//Load the splash screen as soon as the game opens
	}


}
