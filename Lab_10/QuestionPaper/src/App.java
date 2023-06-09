
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
        
        //----------------------------------------------------------- Create Questions in code and Display
        
        System.out.println("***************************************Creating a list of questions and printing for students/graders****************");
        //get a list of questions
        ArrayList<CQuestion> testPaperQuestions = GenerateQuestionsList();
        
        //print test for students
        System.out.println("Printing question paper for Students");
        PrintTestWithQuestion(testPaperQuestions);
        System.out.println("End.....");

        //print test for graders
        System.out.println("Printing question paper for Graders");
        PrintTestWithQuestionAnswers(testPaperQuestions);
        System.out.println("End.....");

        //write test to a file
        System.out.println("***************************************Saving question paper for graders into a file.**********************************");
        Scanner readFilename = new Scanner(System.in);
        System.out.println("Enter the filename to save test paper with answers to(.txt):");
        String fileNameToSaveTo = readFilename.nextLine();
        readFilename.close();
        System.out.println("The test paper will be saved to  " + fileNameToSaveTo);
        WriteQuestionsWithAnswersToFile(testPaperQuestions, fileNameToSaveTo);
        

        //--------------------------------------------------------------------- Read Question papers from Question bank file and Display
        //Use question paper from a QuestionBank file
        System.out.println("**************************************Reading questions from a question-bank file and printing.*************************");
        ArrayList<CQuestion> testPaperQuestionsFromQuestionBank = ReadQuestionsFromQuestionBank();
        //print test for students
        System.out.println("Printing question paper for Students");
        PrintTestWithQuestion(testPaperQuestionsFromQuestionBank);

        //print test for graders
        System.out.println("Printing question paper for Graders");
        PrintTestWithQuestionAnswers(testPaperQuestionsFromQuestionBank);
       
    }

    //create a list of questions and return
    public static ArrayList<CQuestion> GenerateQuestionsList()
    {
       //objective question
       CQuestion myObjectiveQuestion1 = new CObjectiveQuestion("What is a class in Java?", "A class is a collection of data-members and member-functions.", 1, 3, 1);
       CQuestion myObjectiveQuestion2 = new CObjectiveQuestion("What are public/private/default/protected in Java?", "Access Modifiers", 2, 3, 1);
       CQuestion myObjectiveQuestion3 = new CObjectiveQuestion("Keyword for attributes and methods that cannot be overridden/modified in Java?", "final", 3, 3, 1);
    
       //fillintheblank question
       CQuestion myBlankQuestion1 = new CFillInTheBlankQuestion("Mr. (FillInTheBlank) was the 16th US President.", "Abraham Lincoln", 2, 4, 1);
       CQuestion myBlankQuestion2 = new CFillInTheBlankQuestion("(FillInTheBlank) keyword is used to Inherit a class from base class.", "extends", 2, 4, 1);
       CQuestion myBlankQuestion3 = new CFillInTheBlankQuestion("Override Keyword can be used to (FillInTheBlank) a function in the derived class.", "override", 2, 4, 1);

       //MultipleChoice Question
       ArrayList<String> multipleChoices1 = new ArrayList<>();
       multipleChoices1.add("Peter Griffin");
       multipleChoices1.add("Scooby Doo");
       multipleChoices1.add("Spongebob Squarepants");
       multipleChoices1.add("Eric Cartman");

       String QuestionText1 = "Who lives in a pineapple under the sea?";
       String CorrectAnswer1 = "Spongebob Squarepants";
       CQuestion myMultipleChoiceQuestion1 = new CMultipleChoiceQuestion(QuestionText1, CorrectAnswer1, 5, 7, 1, multipleChoices1);

       ArrayList<String> multipleChoices2 = new ArrayList<>();
       multipleChoices2.add("Guido van Rossum");
       multipleChoices2.add("James Gosling");
       multipleChoices2.add("Dennis Ritchie");
       multipleChoices2.add("Bjarne Stroustrup");

       String QuestionText2 = "Who invented Java Programming?";
       String CorrectAnswer2 = "James Gosling";
       CQuestion myMultipleChoiceQuestion2 = new CMultipleChoiceQuestion(QuestionText2, CorrectAnswer2, 5, 7, 1, multipleChoices2);

       ArrayList<String> multipleChoices3 = new ArrayList<>();
       multipleChoices3.add("Guido van Rossum");
       multipleChoices3.add("James Gosling");
       multipleChoices3.add("Dennis Ritchie");
       multipleChoices3.add("Bjarne Stroustrup");

       String QuestionText3 = "Who invented C++ Programming language?";
       String CorrectAnswer3 = "Bjarne Stroustrup";
       CQuestion myMultipleChoiceQuestion3 = new CMultipleChoiceQuestion(QuestionText3, CorrectAnswer3, 5, 7, 1, multipleChoices3);

   
       //add all questions to the test
       ArrayList<CQuestion> testPaperQuestions= new ArrayList<>();
       testPaperQuestions.add(myObjectiveQuestion1);
       testPaperQuestions.add(myObjectiveQuestion2);
       testPaperQuestions.add(myObjectiveQuestion3);
       testPaperQuestions.add(myBlankQuestion1);
       testPaperQuestions.add(myBlankQuestion2);
       testPaperQuestions.add(myBlankQuestion3);
       testPaperQuestions.add(myMultipleChoiceQuestion1);
       testPaperQuestions.add(myMultipleChoiceQuestion2);
       testPaperQuestions.add(myMultipleChoiceQuestion3);

       return testPaperQuestions;

    }
    
    //print testpaper with questions only
    public static void PrintTestWithQuestion(ArrayList<CQuestion> testPaperQuestions)
    {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Mid-term test paper");
        System.out.println("----------------------------------------------------------------------------------");
        int totalPoints = 0;
        for (CQuestion cQuestion : testPaperQuestions) {
            System.out.println(cQuestion.GetQuestion());
            System.out.println();
            totalPoints += cQuestion.getPoints();
        }
       
        System.out.print("Total Points: ");
        System.out.println(totalPoints);

    }

    //print test with questions and answers
    public static void PrintTestWithQuestionAnswers(ArrayList<CQuestion> testPaperQuestions)
    {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Mid-term test paper with answers");
        System.out.println("----------------------------------------------------------------------------------");

         int totalPointsTest = 0;
        for (CQuestion cQuestion : testPaperQuestions) {
            System.out.println(cQuestion.QuestionWithAnswer());
            System.out.println();
            totalPointsTest += cQuestion.getPoints();
        }
       
        System.out.print("Total Points: ");
        System.out.println(totalPointsTest);
    }

    //write the question paper with answers to a file
    public static void WriteQuestionsWithAnswersToFile(ArrayList<CQuestion> testPaperQuestions, String FileNameToUse)
    {
        StringBuilder questionPapeStringBuilder = new StringBuilder();
        questionPapeStringBuilder.append("----------------------------------------------------------------------------------\n");
        questionPapeStringBuilder.append("Mid-term test paper with answers\n");
        questionPapeStringBuilder.append("----------------------------------------------------------------------------------\n");

         int totalPointsTest = 0;
        for (CQuestion cQuestion : testPaperQuestions) {
            questionPapeStringBuilder.append(cQuestion.QuestionWithAnswer());
            questionPapeStringBuilder.append("\n");
            //System.out.println();
            totalPointsTest += cQuestion.getPoints();
        }
       
        questionPapeStringBuilder.append("Total Points: ");
        questionPapeStringBuilder.append(totalPointsTest);
        questionPapeStringBuilder.append("\n");

        //System.out.println(questionPapeStringBuilder.toString());

        //write to file
        try {
           
            FileWriter testPaperFileWriter = new FileWriter(FileNameToUse);
            testPaperFileWriter.write(questionPapeStringBuilder.toString());
            testPaperFileWriter.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file");
        }
    }

    //read the list of questions from a file named QuetionBank.txt
    public static ArrayList<CQuestion> ReadQuestionsFromQuestionBank()
    {

        ArrayList<CQuestion> testPaperQuestions= new ArrayList<>();
        
        try 
        {
            File questionBankFile = new File("QuetionBank.txt");
            Scanner questionReader = new Scanner(questionBankFile);
            
            while (questionReader.hasNextLine()) {
              String questionText = questionReader.nextLine();
              String[] questionComponents = questionText.split(";");
            
              //create objects
              if(questionComponents[0].equalsIgnoreCase("ObjectiveQuestion"))
              {
                    CQuestion objectiveQuestion = new CObjectiveQuestion(questionComponents[1], questionComponents[5], Integer.parseInt(questionComponents[2]), Integer.parseInt(questionComponents[3]), Integer.parseInt(questionComponents[4]));
                    testPaperQuestions.add(objectiveQuestion);
              }
              else if(questionComponents[0].equalsIgnoreCase("FillInTheBlankQuestion"))
              {
                CQuestion fillInTheBlankQuestion = new CFillInTheBlankQuestion(questionComponents[1], questionComponents[5], Integer.parseInt(questionComponents[2]), Integer.parseInt(questionComponents[3]), Integer.parseInt(questionComponents[4]));
                testPaperQuestions.add(fillInTheBlankQuestion);
              }
              else if(questionComponents[0].equalsIgnoreCase("MultipleChoiceQuestion"))
              {
                  //get list of Optional answers
                    ArrayList<String> multipleChoicesList = new ArrayList<>();
                    String[] multipleAnswers = questionComponents[5].split(",");
                    for(int i=0; i < multipleAnswers.length; i++)
                    {
                        multipleChoicesList.add(multipleAnswers[i]);
                    }

                    CQuestion multipleChoiceQuestion = new CMultipleChoiceQuestion(questionComponents[1], questionComponents[6], Integer.parseInt(questionComponents[2]), Integer.parseInt(questionComponents[3]), Integer.parseInt(questionComponents[4]), multipleChoicesList);
                    testPaperQuestions.add(multipleChoiceQuestion);
              }
           }
        
           questionReader.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
      
        return testPaperQuestions;
    }
}
