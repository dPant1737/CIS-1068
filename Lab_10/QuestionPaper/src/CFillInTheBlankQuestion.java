

public class CFillInTheBlankQuestion extends CQuestion
{
    static final String BLANK_DENOTER = "(FILLINTHEBLANK)";
     private String answerOfQuestion;
    
    //constructor
    public CFillInTheBlankQuestion(String Question, String Answer, int Points, int Difficulty, int SpaceNeeded)
    {
        //call the base class constructor first
        super(Question, Points, Difficulty, SpaceNeeded);
        answerOfQuestion = Answer;
    }

    //getter/setter
    public String getAnswerOfQuestion(){
        return answerOfQuestion;
    }
    public void setAnswerOfQuestion(String Ans){
        answerOfQuestion = Ans;
    }

    @Override
    public String GetQuestion()
    {
        String questionWithDashes = ReplaceBlankDenoterWithGivenString(getQuestionText(), "_______________________________");
        String questionToStudent = String.format("Question: %s (Pts: %d, Difficulty: %d) ", questionWithDashes, getPoints(), getdifficulty());
        return questionToStudent;
    }

    @Override
    public String QuestionWithAnswer()
    {
        String answerText = "___" + getAnswerOfQuestion() + "___";

        String questionWithInsertedAnswer = ReplaceBlankDenoterWithGivenString(getQuestionText(), answerText);
        

        return questionWithInsertedAnswer;
    }

    private String ReplaceBlankDenoterWithGivenString(String SentenceWithBlankDenoter, String ReplacementString)
    {
        String replacedString= SentenceWithBlankDenoter;

        String allUpperCase = SentenceWithBlankDenoter.toUpperCase();
        int indexOfBlankDenoter = allUpperCase.indexOf(BLANK_DENOTER);
        if(indexOfBlankDenoter != -1)
        {
            StringBuffer buffer= new StringBuffer(SentenceWithBlankDenoter);
            buffer.replace(indexOfBlankDenoter, indexOfBlankDenoter + BLANK_DENOTER.length(), ReplacementString);
            replacedString =  buffer.toString();
        }

        return replacedString;
    }
    
}
