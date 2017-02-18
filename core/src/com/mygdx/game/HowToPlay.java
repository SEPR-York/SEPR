package com.mygdx.game;

import java.awt.Desktop;
import java.net.URL;

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

/**
 * This has been modified from the main menu class
 * @author Gandhi Inc.
 * @since Assessment 3
 * @version Assessment 3
 *
 */
public class HowToPlay implements Screen {

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
     * Array of all the text that needs to be rended. 
     */
    private TextButton[] buttons = new TextButton[12];

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

    




    public HowToPlay(Game game){ 																				    //Import current game-state
        this.game = game;
    }

    /**
     * Secondary constructor of the main menu which focuses on preparing visual elements
     * Specifically instantiates the menu's stage; spatial construction table; fonts; background image and buttons
     * before adding the stage containing the table (which itself contains the menu's labels, buttons and background
     * image) to the screen's rendering pipeline, which is also set up at the beginning of this method
     */
    @Override
    public void show() {
        drawer = new Drawer(game);

        batch = new SpriteBatch(); 																					//Initialise sprite-batch
        

        stage = new Stage();
        table = new Table();																						//Initialise stage and button-table

        menuFont = new TTFont(Gdx.files.internal("font/enterthegrid.ttf"), 36, 2, Color.BLACK, false);				//Initialise menu font


        Gdx.input.setInputProcessor(stage);																			//Set the stage up to accept user inputs
        

        background = new Sprite(new Texture("image/Solid_white.svg.png"));
        background.setSize(background.getWidth(), background.getHeight());
        background.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 									//Fill the screen with the table

        
        

        TextButton.TextButtonStyle menuButtonStyle = new TextButton.TextButtonStyle(); 								//enables the button to look like it is depressed when it is pressed
        menuButtonStyle.font = menuFont.font();
        menuButtonStyle.fontColor = Color.BLACK;
        menuButtonStyle.pressedOffsetX = 1;
        menuButtonStyle.pressedOffsetY = -1;



        buttons[0] = new TextButton("How to Play", menuButtonStyle); 												//places the lines of text into an array
        buttons[1] = new TextButton("", menuButtonStyle); 															//which is then rendered onto the screen later
        buttons[2] = new TextButton("", menuButtonStyle);
        buttons[3] = new TextButton("", menuButtonStyle);
        buttons[4] = new TextButton("", menuButtonStyle);
        buttons[5] = new TextButton("", menuButtonStyle);
        buttons[6] = new TextButton("", menuButtonStyle);
        buttons[7] = new TextButton("", menuButtonStyle);
        buttons[8] = new TextButton("", menuButtonStyle);
        buttons[9] = new TextButton("", menuButtonStyle);
        buttons[10] = new TextButton("for more information, click here", menuButtonStyle);
        buttons[10].addListener(new ChangeListener() 
        { 	
        	public void openpage(ChangeEvent event, Actor actor)
        	{
        		try 
        		{
            	    Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
            	} 
        		catch (Exception e) {}
        	}
        	
        });
        
        
        
        buttons[11] = new TextButton("Back to Main Menu", menuButtonStyle); 										//creates the "back to main menu" button and adds a listner 
        buttons[11].addListener(new ChangeListener() { 																//to the button so when it is pressed it sends you back to the main menu
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

        
        for (int i = 0; i < buttons.length; i++) {																	//renders the buttons
            drawer.addTableRow(table, buttons[i]);
        }

        
        stage.addActor(table);																						//FINALISE TABLE

    }

    /**
     * Renders all visual elements (set up in the [show()] subroutine and all of its subsiduaries) to the window
     * This is called to prepare each and every frame that the screen deploys
     *
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1); 																			 //First instruction sets background colour
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin(); 																								//Run through the rendering pipeline to draw the menu's background image to the screen

        background.draw(batch);
        batch.end();
        
        stage.act(delta);																							//Draw the stage onto the screen
        stage.draw();
        
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
