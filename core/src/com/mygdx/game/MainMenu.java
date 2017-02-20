package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: http://gandhi-inc.me/downloads/assessment3.jar
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
public class MainMenu implements Screen {

    /**
     * Stores current game-state, enabling transitions between screens and external QOL drawing functions
     */
    private Game game;

    /**
     * On-screen stage which can be populated with actors
     */
    private Stage stage;

    /**
     * Provides the spatial framework for menu buttons and labels to be organised over
     */
    private Table table;

    /**
     * Array of all menu buttons
     */
    private TextButton[] buttons = new TextButton[3];

    /**
     * Establishes the font which is used to encode the menu's options
     */
    private TTFont menuFont;

    /**
     * Establishes the font which is used to encode the game's title
     */
    private TTFont titleFont;

    /**
     * Establishes the font which, at the moment, encodes a "Title TBC" message
     */
    private TTFont tempFont;

    /**
     * Object defining QOL drawing functions for rectangles and on-screen tables
     * Used in this class accelerate table row creation
     */
    private Drawer drawer;

    /**
     * Batch that manages the rendering pipeline for all of the images to be displayed on the screen
     */
    private SpriteBatch batch;

    /**
     * The object which will encode the menu's background
     */
    private Sprite background;

    /**
     * The menu-screen's initial constructor
     *
     * @param game Variable storing the game's state for rendering purposes
     */
    public MainMenu(Game game) {
        this.game = game;
    }
    //Import current game-state

    /**
     * Secondary constructor of the main menu which focuses on preparing visual elements
     * Specifically instantiates the menu's stage; spatial construction table; fonts; background image and buttons
     * before adding the stage containing the table (which itself contains the menu's labels, buttons and background
     * image) to the screen's rendering pipeline, which is also set up at the beginning of this method
     */
    @Override
    public void show() {
        drawer = new Drawer(game);

        batch = new SpriteBatch();
        //Initialise sprite-batch

        stage = new Stage();
        table = new Table();
        //Initialise stage and button-table

        titleFont = new TTFont(Gdx.files.internal("font/earthorbiterxtrabold.ttf"), 120, 2, Color.BLACK, false);
        menuFont = new TTFont(Gdx.files.internal("font/enterthegrid.ttf"), 36, 2, Color.BLACK, false);
        tempFont = new TTFont(Gdx.files.internal("font/earthorbiter.ttf"), 24, 2, Color.BLACK, false);
        //Initialise menu font

        Gdx.input.setInputProcessor(stage);
        //Set the stage up to accept user inputs

        background = new Sprite(new Texture("image/MenuBG.png"));
        background.setSize(background.getWidth(), background.getHeight());
        background.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //Create logo sprite and re-size/re-position it to fit into game window

        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //Fill the screen with the table
        //This is bound to change in the future for obvious reasons

        TextButton.TextButtonStyle menuButtonStyle = new TextButton.TextButtonStyle();
        menuButtonStyle.font = menuFont.font();
        menuButtonStyle.fontColor = Color.WHITE;
        menuButtonStyle.pressedOffsetX = 1;
        menuButtonStyle.pressedOffsetY = -1;
        //Set up the format for the buttons on the menu

        buttons[0] = new TextButton("Start", menuButtonStyle);
        buttons[0].addListener(new ChangeListener() 
        {
            public void changed(ChangeEvent event, Actor actor)
            {
            	// ------------ PLAYER 1 ---------------
            	
                String player1 = JOptionPane.showInputDialog(null, "Player 1 enter your name", "Player 1");

                if(player1 == null || player1 == "")   		// If the player click's cancel or doesn't enter a name
                {
                	game.setScreen(new MainMenu(game));		// Returns to main screen
                }
                else										// If the player has a valid input
                {
                	// Create array list of colleges
                	String[] tmpArray = {"Derwent", "Langwith", "Vanburgh", "James", "Wentworth", "Halifax", "Alcuin", "Goodricke", "Constantine"};
                    ArrayList<String> collegeValueList = new ArrayList<String>(Arrays.asList(tmpArray));
                    
                    //Create a college selection message
                    JDialog.setDefaultLookAndFeelDecorated(true);														//Set the type of display box
                    String initialSelection = "Derwent";																//Default to Derwent  
                    Object player1college = JOptionPane.showInputDialog(												//Show the message
                    													null, 											// Parent JFrame is null
                    													"Which college would you like to be in?", 		// Text to display
                    													"Player 1", 									// Title
                    													JOptionPane.QUESTION_MESSAGE, 					// Type of message
                    													null, 											// null
                    													collegeValueList.toArray(), 					// List of options
                    													initialSelection);								// Initial value selected
                    
                    if (player1college == null || player1college == "")								// If the input isn't valid																	
                    {
                        	game.setScreen(new MainMenu(game));										// Return to main menu
                    }
                    else
                    {
		                System.out.printf("Player 1's name is '%s'.\n", player1);				//Print players name to console
		                System.out.println("Player 1 has chosen college: " + player1college);	//Print their college to console
		                
		                College college1 = new College((String) player1college);				//Set their college to their name
		
		                collegeValueList.remove((String) player1college);						//Remove the college player 1 picked from player 2's list
		
		                // --------------- PLAYER 2 ----------------
			            // Player 2 enter their name frame
		                String player2 = JOptionPane.showInputDialog(null, 							//Parent class is null
		                											"Player 2 enter your name", 	//Text to display
		                											"Player 2");					//Default name
		                
		                if(player2 == null || player2 == "")    									// If the player click's cancel or doesn't enter a name
		                {
		                	game.setScreen(new MainMenu(game));										// Return to main menu									
		                }
		                else
		                {
		                	JDialog.setDefaultLookAndFeelDecorated(true);
		                    Object player2college = JOptionPane.showInputDialog(null, 
		                    								"Which college would you like to be in?", 		// Question in message
		                    								"Player 2", 									// Title of message
		                    								JOptionPane.QUESTION_MESSAGE, 					// Type of message window
		                    								null, 											// null
		                    								collegeValueList.toArray(), 					// List of options available
		                    								initialSelection);								// Default option selected
		  
		                    if (player2college == null || player2college == "")								// If the input isn't valid																	
		                    {
		                        	game.setScreen(new MainMenu(game));										// Return to main menu
		                    }
		                    else																			// If it is valid
		                    {
		                    	System.out.printf("Player 2's name is '%s'.\n", player2);					// Print player 2's name to console
		                        System.out.println("Player 2 has chosen college: " + player2college);		// Print their college to console
		                        College college2 = new College((String) player2college);					// Set player 2's college selection to their college choice
		
		                    	game.setScreen(new GameScreen(game, player1, player2, college1, college2));	// START THE GAME!
		                    }
		                }
                    }
                }
            }
        });
        
        buttons[1] = new TextButton("How to Play", menuButtonStyle);
        buttons[1].addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new HowToPlay(game));
            }
        });
        buttons[2] = new TextButton("Leaderboard", menuButtonStyle);
        buttons[2].addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new LeaderboardFrontend(game));
            }
        });
        //Initialise menu buttons using defined style

        //ADD TITLE BAR
        drawer.addTableRow(table, new Label("Sabbaticoup", new Label.LabelStyle(titleFont.font(), Color.WHITE)), 0, 0, 0, 0);
        drawer.addTableRow(table, new Label("(Gandhi Inc.)", new Label.LabelStyle(tempFont.font(), Color.WHITE)), 0, 0, 50, 0);

        //ADD BUTTONS
        for (int i = 0; i < buttons.length; i++) {
            drawer.addTableRow(table, buttons[i]);
        }

        //FINALISE TABLE
        stage.addActor(table);

        //Draw temporary debug lines
        //drawer.debug(stage);
    }

    /**
     * Renders all visual elements (set up in the [show()] subroutine and all of its subsiduaries) to the window
     * This is called to prepare each and every frame that the screen deploys
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //OpenGL nonsense
        //First instruction sets background colour

        batch.begin();
        background.draw(batch);
        batch.end();
        //Run through the rendering pipeline to draw the menu's background image to the screen

        stage.act(delta);
        stage.draw();
        //Draw the stage onto the screen
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    /**
     * Disposes of all visual data used to construct previous frames
     * This is called after each frame is rendered, and remains necessary to prevent memory leaks
     */
    @Override
    public void dispose() {
        menuFont.dispose();

        stage.dispose();
    }
}
