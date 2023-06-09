import java.util.Scanner;

//The purpose of this program is to create a grade calculator

public class Grades
{
    public static void main(String[] args) 
    {
        System.out.println("This program accepts your homework and two exam scores as input and computes your grade in the course.");
        
    //Getting the weight
        Scanner weight = new Scanner(System.in);
        System.out.print("Homework weight? ");
        String homeworkWeight = weight.nextLine();
        System.out.print("Exam 1 Weight? ");
        String exam_One_Weight = weight.nextLine();
        System.out.print("Exam 2 Weight? ");
        String exam_Two_Weight = weight.nextLine();

        System.out.print("Using weights of " + homeworkWeight + " " + exam_One_Weight + " " + exam_Two_Weight + "\n");

        //Making Strings into doubles
        int HW_Weight = Integer.parseInt(homeworkWeight);
        int examOneWeight = Integer.parseInt(exam_One_Weight);
        int examTwoWeight = Integer.parseInt(exam_Two_Weight); 

    //Getting Homework information
        //getting data from user as strings
        Scanner homework = new Scanner(System.in); 
        System.out.println("Homework: ");
        System.out.print("Number of assignments? ");
        String assignments = homework.nextLine();
        System.out.print("Average Homework grade? ");
        String average_HW_Grade = homework.nextLine();
        System.out.print("Number of late days used? ");
        String lateDays = homework.nextLine(); 
        System.out.print("Labs Attended? ");
        String labsAttended = homework.nextLine(); 

        //Making strings into ints and doubles
        int numOfAssignments = Integer.parseInt(assignments);
        double avgHomeworkGrade = Double.parseDouble(average_HW_Grade);
        int numOfLateDays = Integer.parseInt(lateDays); 
        int labs = Integer.parseInt(labsAttended); 
        double homework_Weight = HW_Weight;
        

        //Accounting for negative numbers or zeros and numbers over possible amount
        if (numOfAssignments <= 0) 
        {
            
            homework_Weight = Homework(HW_Weight, numOfAssignments, avgHomeworkGrade, numOfLateDays, labs);
            System.out.printf("Weighted score: %.2f \n", homework_Weight);
        }
        else
        { 
            if(avgHomeworkGrade < 0)
            {
                avgHomeworkGrade = 0; 
            }
            else if(avgHomeworkGrade > 10)
            { 
                avgHomeworkGrade = 10; 
            }

            //Making sure that labs don't go under or over possible amounts
            if (labs < 0) 
            {
                labs = 0;    
            }
            else if(labs > numOfAssignments)
            {
                labs = numOfAssignments; 
            }
        
            //Calculating Homework score
            homework_Weight = Homework(HW_Weight, numOfAssignments, avgHomeworkGrade, numOfLateDays, labs);
            System.out.printf("Weighted score: %.2f \n", homework_Weight);
        }
       
    
    //Getting Exam 1 Information
        //getting data from the users as strings
        Scanner ExamOne = new Scanner(System.in); 
        System.out.println("Exam 1: ");
        System.out.print("Score? ");
        String scoreOne = ExamOne.nextLine();
        System.out.print("Curve? ");
        String curveOne = ExamOne.nextLine();
       
        //Making strings into doubles
        double ExamOneScore = Double.parseDouble(scoreOne);
        int ExamOneCurve = Integer.parseInt(curveOne);
      
        //calculate the exam score
        double exam_1_weighted_score = Exam(examOneWeight, ExamOneScore, ExamOneCurve);
        System.out.printf("Weighted score: %.2f \n" , exam_1_weighted_score);

    //Getting Exam 2 Information
        //getting data from the users as strings
        Scanner ExamTwo = new Scanner(System.in);
        System.out.println("Exam 2: ");
        System.out.print("Score? ");
        String scoreTwo = ExamTwo.nextLine();
        System.out.print("Curve? ");
        String curveTwo = ExamTwo.nextLine();

        //Making strings into doubles and ints
        double ExamTwoScore = Double.parseDouble(scoreTwo);
        int ExamTwoCurve = Integer.parseInt(curveTwo);

        //calculate the exam score
        double exam_2_weighted_score = Exam(examTwoWeight, ExamTwoScore, ExamTwoCurve);
        System.out.printf("Weighted score: %.2f \n" , exam_2_weighted_score);
    
    //Final Grade
        System.out.printf("Course grade: %.2f \n", homework_Weight + exam_1_weighted_score + exam_2_weighted_score); 
    }
    
    public static double Homework(double weight, int assingments, double averageHWGrade, int lateDays, int labsAttended)
    { 
        //Different Point Types
        double maxHomeworkPoints = 10 * assingments;
        double homeworkPoints = averageHWGrade * assingments;
        double labPoints = labsAttended * 4;

        
        //Accounting for point changes with late days
        if(lateDays > assingments/2) 
        {
            homeworkPoints *= .90; 
        }
        else if(lateDays == 0)
        {
            homeworkPoints += 5; 
        }
       
        //Finding Total Points
        double totalPointsEarned = homeworkPoints + labPoints;
        int totalPointsPossible = assingments * 14; 

        if(assingments <= 0)
        {
            totalPointsEarned = totalPointsPossible; 
        }

        //Finding Weighted Score
        double HomeworkWeightedScore = totalPointsEarned * weight / totalPointsPossible ;

        //Printing to User
        System.out.printf("Total points = %.2f / %d \n", totalPointsEarned, totalPointsPossible);

        return HomeworkWeightedScore; 
    }

    public static double Exam(double weight, double examScore, int examCurve)
    {
        //Applying the curve
        if(examCurve > 0)
        {
            examScore += examCurve;
        }

        //Accounting for negative values and values greater than total possible points
        if (examScore < 0) {
            examScore = 0; 
        }
        else if(examScore > 100)
        {
            examScore = 100; 
        }

        //Calculating weighted exam score
        double weightedExamScore = weight * (examScore/100); 

        //Printing to User 
        System.out.printf("Total points = %.2f / 100 \n", examScore);

        return weightedExamScore; 
    }
}