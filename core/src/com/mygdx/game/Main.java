package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: ____________
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
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
