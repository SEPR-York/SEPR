package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.Texture;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.awt.*;

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
   * The effect(bonus) that the college uniquely has.
   */
  //private Effect Effect;
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
   * The constructor for the class.
   * @param ID The ID of the college.
   * @param Description The description of the college.
   */
  public College(int ID, String Description){
    if (ID < 1 || ID > 9) {
      throw new ValueException("Invalid College ID Given (Must be between 1 and 9)");
    }
    //Throw an exception if an invalid college ID is given

    this.ID = ID;
    //Assign it to the college object otherwise

    switch (this.ID) {
      case (1):
        this.Name = "Derwent";
        this.logoTexture = new Texture("image/Derwent.png");
        break;
      case (2):
        this.Name = "Langwith";
        this.logoTexture = new Texture("image/Langwith.png");
        break;
      case (3):
        this.Name = "Vanburgh";
        this.logoTexture = new Texture("image/Vanburgh.png");
        break;
      case (4):
        this.Name = "James";
        this.logoTexture = new Texture("image/James.png");
        break;
      case (5):
        this.Name = "Wentworth";
        this.logoTexture = new Texture("image/Wentworth.png");
        break;
      case (6):
        this.Name = "Halifax";
        this.logoTexture = new Texture("image/Halifax.png");
        break;
      case (7):
        this.Name = "Alcuin";
        this.logoTexture = new Texture("image/Alcuin.png");
        break;
      case (8):
        this.Name = "Goodricke";
        this.logoTexture = new Texture("image/Goodricke.png");
        break;
      case (9):
        this.Name = "Constantine";
        this.logoTexture = new Texture("image/Constantine.png");
        break;
    }
    //College ID determines name and logo

    this.logo = new Image(logoTexture);
    //Map the college's associated logo texture to an image object

    this.Description = Description;
    //Set the description of the college
    //This will be displayed on the college-selection screen
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
   * @return
   */
  public Texture getLogoTexture() {
    return logoTexture;

  }
}