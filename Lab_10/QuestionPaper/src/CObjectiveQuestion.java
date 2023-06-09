

public class CObjectiveQuestion extends CQuestion
{
    private String correctAnswer;

    public CObjectiveQuestion(String Question, String Answer, int Points, int Difficulty, int SpaceNeeded) {

        //base class constructor
        super(Question, Points, Difficulty, SpaceNeeded);

        correctAnswer = Answer;
    } 

    public String getAnswer(){
        return correctAnswer;
    }
    public void setAnswer(String AnswerToQuestion){
        correctAnswer = AnswerToQuestion;
    }

    @Override
    public String QuestionWithAnswer()
    {
        return GetQuestion() + '\n' + "Answer:" + getAnswer();
    }
}