package week3_TestNG;

public class Stringcount {
	public static void main(String[] args)
	{
		String sentence = "he is a good, he won 865 competations, but sometimes he don't. what you think? all test-cases should pass. done-done?";
		
		String[] words = sentence.trim().split("\\s");
		System.out.println(words.length);
	}

}
