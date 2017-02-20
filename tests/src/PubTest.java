import org.junit.Test;
import com.badlogic.gdx.Gamble;

import static org.junit.Assert.*;

/**
 * @author Gandhi Inc
 * @since assessment 3
 * @version assessment 3
 * 
 * Testing for the Gamble class
 */
public class PubTest{
	
	@Test
	public void DipTest(){
		g = Gamble()
		assertTrue(g.PlayLuckyDip() == 100 || g.PlayLuckyDip() == -10);
		assertTrue(g.PlayRoulette(1) == 100 || g.PlayRoulette(1) == -10);
	}
	
}