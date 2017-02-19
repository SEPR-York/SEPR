package com.mygdx.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;

/*
 * This class handles the back end for the leaderboard.
 * @author Gandhi Inc.
 * @version assessment 3
 * @since assessment 3
 */

public class LeaderboardBackend{

																				// Declaration and Initialisation of the array list of String Array
	private ArrayList<String[]> ArrayOfPeopleWithScores = new ArrayList<String[]>();




	/**
	 * A getter for the array list ""
	 */

	public ArrayList<String[]> getListofScores(){
		return ArrayOfPeopleWithScores;
	}

/*##############################################################################
#
#						Setters
#
##############################################################################*/

	static public void AddPlayerToLeaderboard(String player,int score){

		/**
		 * This method handles adding new players to the end of the Game save file
		 *
		 * @param player - This is the name of the player that you want to store(type String)
		 * @param score - the score of the player that you want to store (type int)
		 */
		try
		{
		    String filename= "GameSave.txt";
		    FileWriter fw = new FileWriter(filename,true); 						//The true will append the new data
		    fw.write(player + "," + Integer.toString(score) + ",\n");			//Appends the string to the file
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}


	public static void main(String args[]){
		LeaderboardBackend instance = new LeaderboardBackend();
		instance.OpenFile();
		String[][] players = instance.GetTopThree();

	}

	public void OpenFile(){

		/**
		 * This method opens the GameSave.txt file, splits the vaules held in the file
		 * and the populates the array list "arrayofpeoplewithscores".
		 * <p>
		 * This method also contains error handling for if the file "GameSave.txt" does not exist.
		 * If the file does not exist, the method will create the file and populate it with
		 * Example players.
		 */

		BufferedReader br;														// Declare the buffered reader (To Read the file)
		try{
			br = new BufferedReader(new FileReader("GameSave.txt"));			// Assign it given the file path
		} catch (Exception e){													//Catches the error if the file does not exist
			File f = new File("./GameSave.txt");
			try
			{
				f.createNewFile();												//creates the new file
			}
			catch (Exception err)
			{
				err.printStackTrace();											//if a new file cannot be created an error is raised.
				return;
			}
			AddPlayerToLeaderboard("Example Player 1",0);						//populates the file with example players with a score of 0
			AddPlayerToLeaderboard("Example Player 2",0);
			AddPlayerToLeaderboard("Example Player 3",0);
			try
			{
				br = new BufferedReader(new FileReader("GameSave.txt"));		//opens the newly created file
			}
			catch (Exception err)
			{
				err.printStackTrace();
				return;
			}
		}


		String line;															// Declare string to store current line

		try{
			line = br.readLine();												// Attempt to read the line from file
		} catch (Exception e){													//Catches error if cannot read line
			e.printStackTrace();
			return;
		}

		while (line != null){													// While there is a line to read add it to the ArrayList
			ArrayOfPeopleWithScores.add(line.split(","));						//splits the file up on a comma
			try{
				line = br.readLine();											// Attempt to read the next line
			} catch (Exception e){
				e.printStackTrace();
				return;
			}
		}

		try{
			br.close();															//tries to close the file
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
	}

	private int ReturnBestPlayer(ArrayList<String[]> a){
		/**
		 * This function will return the best three players that have played the game so that they are able to be displayed
		 * <p>
		 * This method also contains error handling for if the "GameSave.txt" file contains less than three players
		 *
		 * @return ArrayOfBestPlayers - This is an array of size three that contains the best three players
		 */

		ArrayList<String[]> AllThePlayers = new ArrayList<String[]>(a);
		int index = 0;
		int highest = 0;
		for (int i = 0; i < AllThePlayers.size(); i++){ 						//This for loop is part of the error handling. it loops through the array list of all the players
																				//and if one of the sting array that it contains only has one value in it, it will replace that with
																				//an empty array. This stops a null pointer error.
			if (AllThePlayers.get(index).length == 1)
			{
				String[] retArray = new String[2];
				retArray[0] = "";
				retArray[1] = "";
				AllThePlayers.set(index, retArray);
			}
			int tmp;
			try
			{
				tmp = Integer.parseInt(AllThePlayers.get(i)[1]);
			}
			catch (Exception e)
			{
				tmp = 0;
				e.printStackTrace();
			}
			if (tmp > highest){
				index = i;
				highest = tmp;
			}
		}
		return(index);
	}

	public String[][] GetTopThree(){
		ArrayList<String[]> AllThePlayers = new ArrayList<String[]>(getListofScores());
		String[][] retArray = new String[3][];
		for (int i = 0; i < 3; i++)
		{
			retArray[i] = new String[2];
			retArray[i][0] = "";
			retArray[i][1] = "";
		}
		for (int i = 0; i < 3 && AllThePlayers.size() != 0; i++)
		{
			int index = ReturnBestPlayer(AllThePlayers);
			if (AllThePlayers.get(index).length == 1)
			{
				String[] tmpArray = new String[2];
				tmpArray[0] = "";
				tmpArray[1] = "";
				AllThePlayers.set(index, tmpArray);
			}
			retArray[i] = AllThePlayers.get(index);

			AllThePlayers.remove(index);
		}

		return retArray;

	}



}
