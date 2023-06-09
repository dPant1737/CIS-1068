

public class CQuestion {

    //constants
    static final int MIN_DIFFICULTY = 1;
    static final int  MAX_DIFFICULTY = 10;
    
    //member variables
    private int points;
    private int difficulty;
    private int answerSpace;
    private String questionText;


    public CQuestion(String QuestionText, int PointsForQuestion, int LevelOfDifficulty, int SpaceRequiredForAnswer)
    {
        points = PointsForQuestion;
        
        answerSpace = SpaceRequiredForAnswer;
        questionText = QuestionText;
        
        if(LevelOfDifficulty >= MIN_DIFFICULTY && LevelOfDifficulty <= MAX_DIFFICULTY){
        difficulty = LevelOfDifficulty;
        }
        else{
            difficulty = 5;
        }
    }

    //points
    public int getPoints(){
        return points;
    }
    public void setPoints(int NumPoints){
        points = NumPoints;
    }

    //difficulty
    public int getdifficulty(){
        return difficulty;
    }
    public void setdifficulty(int LevelDifficulty){
        if(LevelDifficulty >= MIN_DIFFICULTY && LevelDifficulty <= MAX_DIFFICULTY){
            difficulty = LevelDifficulty;
        }
        else{
            difficulty =5;
        }
    }

    //answerSpace
    public int getAnswerSpace(){
        return answerSpace;
    }
    public void setAnswerSpace(int SpaceForAnswer){
        answerSpace = SpaceForAnswer;
    }

    //QuestionText
    public String getQuestionText(){
        return questionText;
    }
    public void setQuestionText(String TextOfQuestion){
        questionText = TextOfQuestion;
    }



    public String GetQuestion()
    {
        String questionToStudent = String.format("Question: %s (Pts: %d, Difficulty: %d) ", questionText, points, difficulty);
        return questionToStudent;
    }
    
    public String QuestionWithAnswer()
    {
        return "";
    }
}
