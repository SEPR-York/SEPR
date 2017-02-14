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
	
	
	
/*##############################################################################
#
#						GETTERS
#
##############################################################################*/
	
	
	public ArrayList<String[]> getListofScores(){
		return ArrayOfPeopleWithScores;
	}
	
/*##############################################################################
#
#						Setters
#
##############################################################################*/
	
	public void AddPlayerToLeaderboard(String player,int score){
		
		/*
		 * This class handles adding new players to the end of the Game save file
		 * 
		 * @param player - This is the name of the player that you want to store(type String)
		 * @param score - the score of the player that you want to store (type int)
		 */
		try
		{
		    String filename= "GameSave.txt";
		    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		    fw.write(player + "," + Integer.toString(score) + ",\n");//appends the string to the file
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
		System.out.println(players[0][0]);
		System.out.println(players[1][0]);
		System.out.println(players[2][0]);
		instance.AddPlayerToLeaderboard("ticks", 100);
		System.out.println("works");
	}

	public void OpenFile(){
		// Declare the buffered reader (To Read the file)
		BufferedReader br;
		try{
			// Assign it given the file path
			br = new BufferedReader(new FileReader("GameSave.txt"));
		} catch (Exception e){
			// Return on error, to be fixed with exception handling
			e.printStackTrace();
			return;
		}

		// Declare string to store current line
		String line;

		// Attempt to read the line from file
		try{
			line = br.readLine();
		} catch (Exception e){
			e.printStackTrace();
			return;
		}

		// While there is a line to read add it to the ArrayList
		while (line != null){
			ArrayOfPeopleWithScores.add(line.split(","));
			// Attempt to read the next line
			try{
				line = br.readLine();
			} catch (Exception e){
				e.printStackTrace();
				return;
			}
		}

		try{
			br.close();
		} catch (Exception e){
			e.printStackTrace();
			return;
		}
	}

	private int ReturnBestPlayer(ArrayList<String[]> a){
		/*
		 * This function will return the best three players that have played the game so that they are able to be diplayed
		 * @return ArrayOfBestPlayers - This is an array of size three that contains the best three players
		 */

		ArrayList<String[]> AllThePlayers = new ArrayList<String[]>(a);
		int index = 0;
		for (int i = 0; i < AllThePlayers.size(); i++){
			int tmp = Integer.parseInt(AllThePlayers.get(i)[1]);
			if (tmp > Integer.parseInt(AllThePlayers.get(index)[1])){
				index = i;
			}
		}
		return(index);
	}

	public String[][] GetTopThree(){
		ArrayList<String[]> AllThePlayers = new ArrayList<String[]>(getListofScores());
		String[][] retArray = new String[3][];
		for (int i = 0; i < 3; i++)
		{
			int index = ReturnBestPlayer(AllThePlayers);
			retArray[i] = AllThePlayers.get(index);
			AllThePlayers.remove(index);
		}

		return retArray;

	}



}
