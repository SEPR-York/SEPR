package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * @author Gandhi-Inc.
 * @version Assessment 3
 *          An executable version of the game can be found at: ____________
 *          Our website is: www.gandhi-inc.me
 * @since Assessment 3
 */
public class College {

  /**
   * The numeric representation of the college
   *
   * DERWENT: 1
   * LANGWITH: 2
   * VANBURGH: 3
   * JAMES: 4
   * WENTWORTH: 5
   * HALIFAX: 6
   * ALCUIN: 7
   * GOODRICKE: 8
   * CONSTANTINE: 9
   */
  private int ID;

  /**
   * The name of the College.
   */
  private String Name;

  /**
   * The custom name that a player can choose for the college.
   */
  private String CustomName;

  /**
   * The player is playing as the college.
   */

  private Player Owner;

  /**
   * The description of the College.
   */
  private String Description;

  /**
   * The symbol of the college
   */
  private Image logo;

  /**
   * The texture encoding the symbol of the college
   */
  private Texture logoTexture;

  /**
   * The constructor for the College class
   * This will assign a name and a logo to the College based on the ID provided
   *
   * @param ID The ID of the college.
   * @param Description The description of the college.
   */
  public College(String college){

    if (college == "Derwent") 
    {
        this.Name = "Derwent";
        this.logoTexture = new Texture("image/Derwent.png");
    }
    else if (college == "Langwith")
    {
    	this.Name = "Langwith";
        this.logoTexture = new Texture("image/Langwith.png");
    }
    else if (college == "Vanburgh")
    {
    	this.Name = "Vanburgh";
        this.logoTexture = new Texture("image/Vanburgh.png");
    }
    else if (college == "James")
    {
    	this.Name = "James";
        this.logoTexture = new Texture("image/James.png");
    }
    else if (college == "Wentworth")
    {
    	this.Name = "Wentworth";
        this.logoTexture = new Texture("image/Wentworth.png");
    }
    else if (college == "Halifax")
    {
    	this.Name = "Halifax";
        this.logoTexture = new Texture("image/Halifax.png");
    }
    else if (college == "Alcuin")
    {
    	this.Name = "Alcuin";
        this.logoTexture = new Texture("image/Alcuin.png");
    }
    else if (college == "Goodricke")
    {
    	this.Name = "Goodricke";
        this.logoTexture = new Texture("image/Goodricke.png");
    }
    else if (college == "Constantine")
    {
        this.Name = "Constantine";
        this.logoTexture = new Texture("image/Constantine.png");
    }

    this.logo = new Image(logoTexture);
    //Map the college's associated logo texture to an image object

  }

  /**
   * Setter for the custom name.
   * @param Name The name that the custom name is to be changed to.
   */
  public void changeCustomName(String Name) {
    this.CustomName = Name;
  }

  /**
   * Assigns a player to the college.
   * @param Player The player that has chosen the college.
   */
  public void assignPlayer( Player Player) {
      this.Owner = Player;
  }

  /**
   * Returns the college's assigned name
   *
   * @return String The college's name
   */
  public String getName() {
    return this.Name;
  }

  /**
   * Returns the college's associated ID
   *
   * @return Integer The college's associated ID
   */
  public int getID() {
    return this.ID;
  }

  /**
   * Returns an Image object with the texture of the college's logo mapped to it
   *
   * @return Image Icon representing the college
   */
  public Image getLogo() {
    return this.logo;
  }

  /**
   * Returns the texture file encoding the college's logo
   *
   * @return Texture The texture encoding the college's logo
   */
  public Texture getLogoTexture() {
    return logoTexture;

  }
}