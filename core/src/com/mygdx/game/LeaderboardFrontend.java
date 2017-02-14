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

/**
 * @author Duck Related Team Name in Big Massive Letters && Gandhi Inc.
 * @since Assessment 2
 * @version Assessment 3
 *
 * An executable version of the game can be found at: https://jm179796.github.io/SEPR/DRTN-Assessment2.jar
 * Our website is: https://jm179796.github.io/SEPR/
 */
public class LeaderboardFrontend implements Screen {

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
    private TextButton[] buttons = new TextButton[9];

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

    private LeaderboardBackend backend = new LeaderboardBackend();

    private String[][] players;


    //Import current game-state

    public LeaderboardFrontend(Game game) {
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
        backend.OpenFile();
        players = backend.GetTopThree();
        drawer = new Drawer(game);

        batch = new SpriteBatch();
        //Initialise sprite-batch

        stage = new Stage();
        table = new Table();
        //Initialise stage and button-table

        titleFont = new TTFont(Gdx.files.internal("font/earthorbiterxtrabold.ttf"), 36, 2, Color.BLACK, false);
        menuFont = new TTFont(Gdx.files.internal("font/enterthegrid.ttf"), 36, 2, Color.BLACK, false);
        tempFont = new TTFont(Gdx.files.internal("font/earthorbiter.ttf"), 24, 2, Color.BLACK, false);
        //Initialise menu font

        Gdx.input.setInputProcessor(stage);
        //Set the stage up to accept user inputs

        background = new Sprite(new Texture("image/Solid_white.svg.png"));
        background.setSize(background.getWidth(), background.getHeight());
        background.setCenter(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //Create logo sprite and re-size/re-position it to fit into game window

        table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //Fill the screen with the table
        //This is bound to change in the future for obvious reasons

        TextButton.TextButtonStyle menuButtonStyle = new TextButton.TextButtonStyle();
        menuButtonStyle.font = menuFont.font();
        menuButtonStyle.fontColor = Color.BLACK;
        menuButtonStyle.pressedOffsetX = 1;
        menuButtonStyle.pressedOffsetY = -1;
        //Set up the format for the buttons on the menu
        //STILL NEED TO SORT OUT BUTTON ANIMATIONS


        //These add the information to a bufffer that is later rendered.



        buttons[0] = new TextButton("Leaderboard", menuButtonStyle);
        buttons[1] = new TextButton("", menuButtonStyle);
        buttons[2] = new TextButton("", menuButtonStyle);
        buttons[3] = new TextButton(players[0][0] + " : "+players[0][1],menuButtonStyle);
        buttons[4] = new TextButton(players[1][0] + " : "+players[1][1],menuButtonStyle);
        buttons[5] = new TextButton(players[2][0] + " : "+players[2][1],menuButtonStyle);
        buttons[6] = new TextButton("", menuButtonStyle);
        buttons[7] = new TextButton("", menuButtonStyle);
        buttons[8] = new TextButton("Back to Main Menu", menuButtonStyle);
        buttons[8].addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainMenu(game));
            }
        });

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
