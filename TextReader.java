package InClass;

import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class TextReader {
	   
	
	
	   public static void main (String[] args) throws IOException
	   {
		   Long startTime = System.currentTimeMillis();
		   HashMap<String, Integer> words = new HashMap();
		   String magic_word = "to";
		   int GUTENBERG_BEG = 130;
		   int GUTENBERG_END = 2922;
		   
		   String[] files = {"MobyDick.txt", "Bartleby.txt", 
				   "IAndMyChimney.txt", "Omoo.txt", "Pierre.txt",
				   "Redburn.txt", "TheConfidenceMan.txt", "ThePiazzaTales.txt",
				   "Typee.txt", "WhiteJacket.txt"};
		   
		   //Generate Stop Words List
		   String contents = Files.readString(Path.of("src/InClass/stopWords.txt"), StandardCharsets.UTF_8);
		   List<String> stopWords = List.of(contents.split(","));
		   
		   
		   WordProcessor processor = new WordProcessor(stopWords, GUTENBERG_BEG, GUTENBERG_END);
		   
		   //put all the words in all the texts into one big list.
		   List<String> melvilleWords = new ArrayList<String>();
		   for (String f : files) {
			   contents = Files.readString(Path.of("src/InClass/" + f), StandardCharsets.UTF_8);
			   melvilleWords.addAll(processor.textToWords(contents));
		   }
		   
		   // Does the word Scrubbing
		   List<String> scrubbedMelvilleWords = processor.scrub(melvilleWords);
		   
		   processor.printWords(scrubbedMelvilleWords);
		   
		   
		   // test if it removes all the words that begin with a vowel 
		   processor.findWordsBeginningWithVowels(melvilleWords); // well rn it prints true 
		   
//		   System.out.println("Iterator: " + WordCounter.countWordsByIterating(melvilleWords, 0));
//		   System.out.println("By Stream: " + WordCounter.countWordsWithStreams(melvilleWords, 0));
//		   System.out.println("Iterator: " + WordCounter.countWordsWithParallelStreams(melvilleWords, 0));
		   
//		   System.out.println("Iterator: " + WordCounter.countWordsWithParallelStreams(melvilleWords, 0));
//		   System.out.println("By Stream: " + WordCounter.countWordsWithStreams(melvilleWords, 0));
//		   System.out.println("Iterator: " + WordCounter.countWordsByIterating(melvilleWords, 0));
		   
//		   System.out.println("Distinct Words: " + WordCounter.countDistinctWords(melvilleWords, 0));
		   
		   
		   
		   /*
		   
		   
		   ArrayList<WordCounter> counters = new ArrayList();
		   
		   for (int i =0; i < files.length; i++) {
			   counters.add(new WordCounter(words, files[i], magic_word));
		   }		   
		   
		   ExecutorService executor = Executors.newCachedThreadPool();
		   
		   
		   // Not Explicitly Concurrent
//		   for (String file : files)
//			   WordCounter.countWords(words, file);
		   
		   
		   // USING RUNNABLE
		   for (WordCounter c : counters) 
			   executor.execute(c);
		   
		   
		   // RACE CONDITION
		   //int runnableMagicCount = words.get(magic_word);
		   //System.out.println("Total (Runnable) occurances of " + magic_word + " is " + runnableMagicCount);
		   
		   
		   // USING FUTURES AND CALLABLE
		   try {
			   List<Future<Long>> futures = executor.invokeAll(counters);
			   long total = 0;
			   for (Future<Long> f : futures) 
			   	total += f.get();
			   
			   //long total = executor.invokeAny(counters);
			   
			   
			   System.out.println("Total occurances of " + magic_word + " is " + total);
		   }
		   catch(InterruptedException e) {
			   System.out.println("Task Interrupted!!!!");
		   }
		   catch(ExecutionException e) {
			   System.out.println("Exceptional Execution!!!!");
		   }
		   
		   
		   Long endTime = System.currentTimeMillis();
		   System.out.println("End TIME!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + (endTime - startTime));
		   
		   
		   */
		   
		   
	   }
		   
	   
	   
	   
	   
}   
