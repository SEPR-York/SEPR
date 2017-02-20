package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: http://gandhi-inc.me/downloads/assessment3.jar
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
public class ResourceAccessTest extends TesterFile{

    @Test
    public void TestsHaveAssets(){
        assertTrue(Gdx.files.internal("image/Roboticon111.png").exists());
    }
}
