import java.io.BufferedReader;
import java.io.FileReader;
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
	
	
	public static void main(String args[]){
		LeaderboardBackend instance = new LeaderboardBackend();
		instance.OpenFile();
		String player = instance.ReturnBestPlayers();
		System.out.println(player);
		System.out.println("works");
	}
	
	public void OpenFile(){
		// Declare the buffered reader (To Read the file)
		BufferedReader br;
		try{
			// Assign it given the file path
			br = new BufferedReader(new FileReader("GameSave.txt"));
		} catch (Exception e)
		{
			// Return on error, to be fixed with exception handling
			e.printStackTrace();
			return;
		}

		// Declare string to store current line
		String line;
		
		// Attempt to read the line from file
		try
		{
			line = br.readLine();	
		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
		
		// While there is a line to read add it to the ArrayList
		while (line != null)
		{
			ArrayOfPeopleWithScores.add(line.split(","));
			// Attempt to read the next line
			try
			{
				line = br.readLine();	
			} catch (Exception e)
			{
				e.printStackTrace();
				return;
			}
		}

		// Print out first element of the first array (Just for testing)
		System.out.println(ArrayOfPeopleWithScores.get(0)[1]);
		try
		{
			br.close();		
		} catch (Exception e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	public String ReturnBestPlayers(){
		/*
		 * This function will return the best three players that have played the game so that they are able to be diplayed
		 * @return ArrayOfBestPlayers - This is an array of size three that contains the best three players 
		 */
		
		ArrayList<String[]> AllThePlayers = getListofScores();
		int MaxScore = 0;
		String BestPlayer = "";
		for (int i = 0; i < AllThePlayers.size(); i++){
			int tmp = Integer.parseInt(AllThePlayers.get(i)[1]);
			if (tmp > MaxScore){
				MaxScore = tmp;
				BestPlayer = AllThePlayers.get(i)[0];
			}	
		}
		return(BestPlayer);
	}
	
	public void AddNewPlayer(String Player, int score){
		
	}
	
	public ArrayList<String[]> getListofScores()
	{
		return ArrayOfPeopleWithScores;
	}
	
	public void AddRecordToList(String[] arr)
	{
		ArrayOfPeopleWithScores.add(arr);
	}
	
}