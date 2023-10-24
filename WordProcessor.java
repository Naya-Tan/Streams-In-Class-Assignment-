package InClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WordProcessor {

	
	private List<String> stopWords;
	private int beg, end;
	
	
	public WordProcessor(List<String> stopWords, int beg, int end) {
		this.stopWords = stopWords;
		this.beg = beg;
		this.end = end;
	}
	
	public List<String> textToWords(String text) {
		return List.of(text.split("\\PL+"));
	}
	
	
	public List<String> shrink(List<String> words) {
		
		return words.stream()
		//.forEach(w -> System.out.println(w))
		.map(w -> w.toLowerCase())
		.toList();
	}
	
	public List<String> removeStopWords(List<String> words) {
		
		return words.stream()
				.filter(w -> (!stopWords.contains(w)))
				.filter(w -> !w.equalsIgnoreCase("s"))
				.toList();
	}
	
	public void printWords(List<String> words) {
		words.stream().forEach(w -> System.out.println(w));
	}
	
	public List<String> removeEnds(List<String> words) {
		
		return words.stream().skip(beg)
		.limit((words.size() - beg - end))
		.toList();
		
	}
	
	public List<String> scrub(List<String> words){
		// 1st removes the end words from beginning and end
		// 2nd sends all the words to lower case
		// 3rd takes out stopWords
		return removeStopWords(shrink(removeEnds(words)));
		
			
	}
	
	// create two new functions 
	public void findWordsBeginningWithVowels(List<String> words) {
		// code that finds all the words in the list that begin with a, e, i, o, u, and then prints them out
		List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
		
		words.stream()
		//make sure there isnt any empty strings and check for first letter of the word 
        .filter(w -> !w.isEmpty() && vowels.contains(w.substring(0, 1).toLowerCase()))
        .forEach(w -> System.out.println(w));
	}
	
	public Map<String, Integer> findWordFrequency(List<String> words, List<String> targets){
		return null;
		// code that creates a map of all the frequency of targets n the words list 
		
	}
	
	
}
