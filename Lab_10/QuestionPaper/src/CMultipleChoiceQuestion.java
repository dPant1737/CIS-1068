import java.util.ArrayList;


public class CMultipleChoiceQuestion extends CQuestion{

    private ArrayList<String> ListOfChoices;
    private String CorrectAnswer;
   
    //constructor
    public CMultipleChoiceQuestion(String QuestionText, String RightAnswer, int PointsForQuestion, int LevelOfDifficulty,
            int SpaceRequiredForAnswer, ArrayList<String> QuestionList) {
                

        super(QuestionText, PointsForQuestion, LevelOfDifficulty, 1);
        
        ListOfChoices = QuestionList;
        CorrectAnswer = RightAnswer;
    }

    @Override
    public String GetQuestion()
    {
        StringBuilder questionBuilder  = new StringBuilder(super.GetQuestion());
        //add empty lines
        questionBuilder.append(System.getProperty("line.separator"));
        questionBuilder.append(System.getProperty("line.separator"));

        //Add the list of options
        int optionNum =1;
        for (String answer : ListOfChoices) {
            questionBuilder.append(String.format( " %d. %s", optionNum, answer));
            questionBuilder.append(System.getProperty("line.separator"));
            ++optionNum; 
        }
        
        return questionBuilder.toString();
    }

    @Override
    public String QuestionWithAnswer()
    {
        String answerLine = "***" + CorrectAnswer + "***";
        
        String questionLineWithAnswer = GetQuestion();
        questionLineWithAnswer = questionLineWithAnswer.replace(CorrectAnswer, answerLine);

        return questionLineWithAnswer;
    }
}
