//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.beans.Transient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import org.junit.Test;
 
public class SouthieStyles {
    public static void main (String[] args) 
    {
        //convert the Jaws file
        ConvertJaws();

        //convert the Guttenburg file, just dialogs
        ConvertGuttenburg();
    }
 
    //Reads the contents of jaws.txt file and converts them to southie and save to processedJawsFile.txt file
   private static void ConvertJaws()
   {
        String jawsFileName = "jaws.txt";

        try (Scanner reader = new Scanner(new File(jawsFileName))) 
        {
            StringBuilder sentenceBuilder = new StringBuilder();
            
            while (reader.hasNextLine()) 
            {
                String lineRead = reader.nextLine();
                String[] wordRead = lineRead.split(" ");

                for(int i=0; i < wordRead.length; i++)
                {
                    if (wordRead[i].equals("'") || wordRead[i].equals(":")) // ignore lone apostrophes
                    {
                        sentenceBuilder.append(wordRead);
                        continue;
                    }

                    String southieWord = ConvertWordToSouthieWord(wordRead[i]);
                    sentenceBuilder.append(southieWord);
                    sentenceBuilder.append(" ");
                }
                sentenceBuilder.append("\n");
            }
            //writing to file
            try
            {  
                FileWriter outFile = new FileWriter("processedJawsFile.txt", false);
                outFile.write(sentenceBuilder.toString());
                outFile.close();
            }   
            catch(IOException e)
            {
                e.printStackTrace();
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File: " + jawsFileName + " doesn't exist in the current directory.");
            e.printStackTrace();
        }

   }


   //Just convert the dialogs in Southie to file processedGuttenburg.txt
   private static void ConvertGuttenburg()
   {
        String fileName = "Guttenburg.txt";

        try (Scanner reader = new Scanner(new File(fileName))) 
        {
            StringBuilder sentenceBuilder = new StringBuilder();
            
            while (reader.hasNextLine()) 
            {
                String lineRead = reader.nextLine();

                //check if this line contains a ""
                if(lineRead.contains("\""))
                {
                    //if the line contains a dialog convert it to southie else copy line as it is
                    lineRead = ConvertDialogToSouthie(lineRead);
                }
                
                sentenceBuilder.append(lineRead);
                sentenceBuilder.append("\n");
            }
            //writing to file
            try
            {  
                FileWriter outFile = new FileWriter("processedGuttenburg.txt", false);
                outFile.write(sentenceBuilder.toString());
                outFile.close();
            }   
            catch(IOException e)
            {
                e.printStackTrace();
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " doesn't exist in the current directory.");
            e.printStackTrace();
        }

   }
   
   private static String ConvertWordToSouthieWord(String NormalWord)
    {
        String southieWord = NormalWord;
        southieWord = ProcessWordVery(southieWord);
        southieWord = ProcessLetterRExceptions(southieWord);
        southieWord = ProcessRFollowedByAnVowel(southieWord);
        southieWord = ProcessWordsEndingInA(southieWord);
        return southieWord;
    }
 
    private static String  ConvertDialogToSouthie(String lineText)
    {
        StringBuilder returnedLine = new StringBuilder();
        
        String[] lineWords = lineText.split(" ");
        String currentWord = "";
        String southieWord = "";
        for(int i=0; i < lineWords.length; i++)
        {
              //get the current word
             currentWord = lineWords[i];

            //if the current word starts with a Quote 
            if((currentWord.startsWith("\"") && !currentWord.endsWith("\"")))
            {
                //drop the quote
                southieWord = ConvertWordToSouthieWord(currentWord);
                returnedLine.append(southieWord);
                returnedLine.append(" ");

                
                do
                {
                    ++i;
                    currentWord = lineWords[i];
                    southieWord = ConvertWordToSouthieWord(currentWord);
                    returnedLine.append(southieWord);
                    returnedLine.append(" ");

                 }while( i < lineWords.length-1 && lineWords[i].endsWith("\"") == false);

            }
            else
            {
                returnedLine.append(currentWord);
                returnedLine.append(" ");
            }
        }
        
        return returnedLine.toString();
    }

/*
If 'r' is at the end of a word and is preceded by "ee" or 'i' replace 'r' with "yah" instead of 'h'. For example, "deer" becomes "deeyah"
instead of "deeh", but "veneers" still becomes "veneehs".
If 'r' is at the end of a word and is preceded by "oo", replace 'r' with "wah". For example, "door" becomes "doowah" instead of "dooh"
(but "doors" still becomes "doohs").
*/
   private static String ProcessLetterRExceptions(String GivenWord)
   {
        StringBuilder SouthieWordBuilder = new StringBuilder(GivenWord);
 
        String givenWordLower = GivenWord.toLowerCase();
       
        int wordLength = givenWordLower.length();
        if(wordLength > 1 && givenWordLower.contains("r") )
        {
           //exception 1- is r the last character
           int indexOfr = givenWordLower.indexOf('r');
           if(indexOfr == wordLength -1)
           {
               boolean replaceRWithYah = false;
               boolean replaceRWithWah = false;
               
               //the last character is either 'r' and one before is 'i'
                if(givenWordLower.charAt(wordLength -2) == 'i')
                {
                    //the character before the last character is 'i'
                    replaceRWithYah = true;
                }
                else if(wordLength >= 3 )
                {
                    String twoAlphabetsBeforeR = givenWordLower.substring(wordLength-3, wordLength-1);
                    if(twoAlphabetsBeforeR.compareToIgnoreCase("ee") == 0 )
                    {
                        //the 2 characters before the last character are "ee" or "EE"
                        replaceRWithYah = true;
                    }
                    else if(twoAlphabetsBeforeR.compareToIgnoreCase("oo") == 0)
                    {
                        replaceRWithWah = true;
                    }
                }
               
                if(replaceRWithYah || replaceRWithWah)
                {
                   
                    boolean useCaps = false;
                    if(GivenWord.charAt(wordLength-1) == 'R')
                    {
                        useCaps = true;
                    }
 
                    String replaceString = "";
                    if(replaceRWithYah)
                    {
                        replaceString = (useCaps)? "YAH" : "yah";
                    }
                    else
                    {
                        replaceString = (useCaps)? "WAH" : "wah";
                    }
                   
                    //delete the last character
                    SouthieWordBuilder.deleteCharAt(wordLength -1);
                    //append the replaceString
                    SouthieWordBuilder.append(replaceString);
                }
           }
        }
 
        return SouthieWordBuilder.toString();
   }
   //If there's an 'r' following a vowel ('a', 'e', i', 'o', or 'u'), replace 'r' with 'h'. For example, "I left my car keys by the harbor"
   //becomes "I left my cah keys by the hahboh."
   private static String ProcessRFollowedByAnVowel(String GivenWord)
   {
       StringBuilder SouthieWordBuilder = new StringBuilder(GivenWord);
       
       //number of alphabets in the word.
       int wordLength = GivenWord.length();
       String vowelsLower = "aeiou";
       String vowelsUpper = "AEIOU";
 
       if(wordLength > 1 && (GivenWord.contains("r") || GivenWord.contains("R")))
       {
           //if the word contains 'r' or 'R'
           for(int index=0; index < wordLength; index++)
           {
               //if the first letter is an 'r' don't touch it.
               if(index > 0 && (GivenWord.charAt(index) == 'r' || GivenWord.charAt(index) == 'R') )
               {
                   char replaceChar = (GivenWord.charAt(index) == 'r')? 'h':'H';
                   
                   char previousLetter =  GivenWord.charAt(index - 1);
                   if(vowelsLower.indexOf(previousLetter) != -1 || vowelsUpper.indexOf(previousLetter) != -1)
                   {
                       //A vowel was found before 'r' or 'R'
                        SouthieWordBuilder.setCharAt(index, replaceChar);
                   }
               }
           }
       }
       return SouthieWordBuilder.toString();
   }
 
   //If a word ends in 'a', append an 'r'. For example "tuna" becomes "tunar", "Cuba" becomes "Cubar", and "idea" becomes "idear".
   //(Don't change this to an 'h' based on the previous rule; leave it as an 'r'.) Do not apply this rule to the word "a",
   //so "a tuna" should become "a tunar", not "ar tunar".
   private static String ProcessWordsEndingInA(String GivenWord)
   {
        StringBuilder SouthieWordBuilder = new StringBuilder(GivenWord);
       
        //convert the word to lowercase
        String wordLowerCase = GivenWord.toLowerCase();
        int wordLength = GivenWord.length();
 
        //if the word ends in 'a' append 'r' to the word
        if(wordLength > 1 && wordLowerCase.charAt(wordLength -1) == 'a')
        {
            if(GivenWord.charAt(wordLength -1 ) == 'a'){
                //make it the same case as 'a'
                SouthieWordBuilder.append('r');
            }
            else{
                //make it the same case as 'A'
                SouthieWordBuilder.append('R');
            }
        }
 
        return SouthieWordBuilder.toString();
   }
 
   //Replace the word "very" with the word "wicked". So "very hard" becomes "wicked hahd"
    private static String ProcessWordVery(String GivenWord)
    {
        String returnWord = GivenWord;
 
        if(returnWord.compareToIgnoreCase("very") == 0)
        {
            returnWord = "wicked";
        }
 
        return returnWord;
    }
 
/*
    @Test
    public void testProcessWordVery()
    {
        //AAA
   
        //arrange
        String testWord = "very";
   
        //Act
        String result = ProcessWordVery(testWord);
   
        //Assert
        assertEquals(result, "wicked");
   
    }
 
    @Test
    public void testProcessVery_worksWithOneWordOnly()
    {
        //arrange
        String wordToTest = "a very";
 
        //act
        String result = ProcessWordVery(wordToTest);
       
        //assert
        assertNotEquals("wicked", result);
    }
   
 
    @Test
    public void testProcessRFollowedByAnVowel_Car()
    {
        //arrange
        String wordToTest = "car";
 
        //act
        String result = ProcessRFollowedByAnVowel(wordToTest);
 
        //assert
        assertEquals("cah", result);
    }
 
    @Test
    public void testProcessRFollowedByAnVowel_RetainsLetterCase()
    {
        //arrange
        String wordToTest = "Car";

        //act
        String result = ProcessRFollowedByAnVowel(wordToTest);

        //assert
        assertEquals("Cah", result);
     
    }
 
    @Test
    public void testProcessRFollowedByAnVowel_Harbor()
    {
        //arrange
        String wordToTest = "Harbor";

        //act
        String result = ProcessRFollowedByAnVowel(wordToTest);

        //assert
        assertEquals("Hahboh", result);
     
    }
 
    @Test
    public void testProcessWordsEndingInA_tuna()
    {
        //arrange
        String wordToTest = "tuna";

        //act
        String result = ProcessWordsEndingInA(wordToTest);

        //assert
        assertEquals("tunar", result);
       
    }
 
    @Test
    public void testProcessWordsEndingInA_PreserversCase()
    {
        //arrange
        String wordToTest = "IDEa";

        //act
        String result = ProcessWordsEndingInA(wordToTest);

        //assert
        assertEquals("IDEar", result);

    }
 
    @Test
    public void testConvertWordToSouthieWord_direct()
    {
        //arrange
        String wordToTest = "direct";

        //act
        String result = ConvertWordToSouthieWord(wordToTest);

        //assert
        assertEquals("dihect", result);
     
    }
 
    @Test
    public void testConvertWordToSouthieWord_everybody()
    {
        //arrange
        String wordToTest = "EveryBody";

        //act
        String result = ConvertWordToSouthieWord(wordToTest);

        //assert
        assertEquals("EvehyBody", result);

        
    }

    @Test
    public void testDialogInLineGetsConvertedToSouthie()
    {
        //arrange
        String dialogLineToTest = "undo the heavy burdens. . .let the oppressed go free.";
        String southieLines = "undo the heavy buhdens. . .let the oppressed go free. ";

        //act
        String convertedLine = ConvertDialogToSouthie(dialogLineToTest);

        //assert
        assertEquals(southieLines, convertedLine); 
    }
    */
}









