package jar;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordTest {

	@Test
	public void testReverseWord() {
		try {
			String reversedWord = ReverseWord.reverseWord("");
			assertEquals("", reversedWord);
	
			String reversedWordB = ReverseWord.reverseWord("Rody");
			assertEquals("ydoR", reversedWordB);
			
			String reversedWordC = ReverseWord.reverseWord("Jos");
			assertEquals("soJ", reversedWordC);		
		}
		catch(InvalidInputException e) {
			e.printStackTrace();
		}
	}
	
	public void testReverseA() {
		try {
			String reversedWordA = ReverseWord.reverseWord("a");
			assertEquals("a", reversedWordA);
		}
		catch(InvalidInputException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test(expected = InvalidInputException.class)
	public void testReverseWordNull() throws InvalidInputException
	{
		String reversedWord = ReverseWord.reverseWord(null);
	}

}
