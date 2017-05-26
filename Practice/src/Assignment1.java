import java.util.*;

public class Assignment1
{
       public static class WordPair
       {
           String firstWord;
        }

        public static void main(String[] args)
       {
           WordPair tempWordPair = new WordPair();
           ArrayList<WordPair> wordPairList = new ArrayList<WordPair>();

           tempWordPair.firstWord = "aaa";
           wordPairList.add( tempWordPair );
           tempWordPair = new WordPair();
           tempWordPair.firstWord = "bbb";
           wordPairList.add( tempWordPair );
           tempWordPair = new WordPair();
           tempWordPair.firstWord = "ccc";
           wordPairList.add( tempWordPair );

           System.out.println("[0] - " + wordPairList.get(0).firstWord);
           System.out.println("[1] - " + wordPairList.get(1).firstWord);
           System.out.println("[2] - " + wordPairList.get(2).firstWord);
         }
}