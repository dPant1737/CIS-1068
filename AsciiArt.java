public class AsciiArt { 
    static final double SIZE = 10; 
    static final double TOPSIZE = SIZE/2; 
    static final double MIDDLESIZE = SIZE * .8;
    static final double BOTTOMSIZE = SIZE * 1.1; 
    static final double LOGSIZE = SIZE;    
    static final double COLUMN_LENGTH = 2; 
    static final double ROW_LENGTH = 10; 

    static final char SPACE = ' ';
    static final char PIPE = '|';
    static final char PERIOD = '.';
    static final char BACKSLASH = '\\';
    static final char FORWARDSLASH = '/'; 
    static final char STAR = '*';
    static final char PLUS_SIGN = '+';
    static final char UNDERSCORE = '_'; 
    static final char NEXT_LINE = '\n'; 
    
    public static void main(String[] args) {
        ChristmasTree();
        ParkingLot();
    }

//Christmas Section
    public static void ChristmasTree()
    {
        Top();
        Middle();
        Bottom();
        Log();
        for (int i = 0; i < 5; i++) {
            System.out.print("\n");
        }
        
    }

    public static void Top()
    {
       for (int pipe = 1; pipe < TOPSIZE; pipe++) 
       {
           System.out.print(PIPE);
           for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
           {
                System.out.print(SPACE);

           }
           System.out.print(STAR);
           System.out.print(FORWARDSLASH);
           for (int dot = 1; dot <= (pipe * 4 - 4); dot++) 
           {
               System.out.print(PERIOD);
           }
           System.out.print(BACKSLASH); 
           System.out.print(STAR);
           for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
           {
                System.out.print(SPACE);
           }
           System.out.println(PIPE);
       }
       
    }
    

    public static void Middle()
    {
        for (int pipe = 1; pipe < MIDDLESIZE; pipe++) 
       {
           System.out.print(PIPE);
           for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
           {
               System.out.print(SPACE); 
           }
           System.out.print(STAR);
           System.out.print(FORWARDSLASH);
           for (int dot = 1; dot <= (pipe * 4 - 4); dot++) 
           {
               System.out.print(PERIOD);
           }
           System.out.print(BACKSLASH);
           System.out.print(STAR);
           for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
           {
                System.out.print(SPACE);
           }
           System.out.println(PIPE);
       }
    }

    public static void Bottom(){
        for (int pipe = 1; pipe < BOTTOMSIZE; pipe++) 
        {
            System.out.print(PIPE);
            for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
            {
                System.out.print(SPACE); 
            }
            System.out.print(STAR);
            System.out.print(FORWARDSLASH);
            for (int dot = 1; dot <= (pipe * 4 - 4); dot++) 
            {
                System.out.print(PERIOD);
            }
            System.out.print(BACKSLASH);
            System.out.print(STAR);
            for (int space = 1; space <= (pipe * -2 + (4*SIZE)) ; space++) 
            {
                 System.out.print(SPACE);
            }
            System.out.println(PIPE);
        }

    }

    public static void Log()
    {
        for (int pipe = 1; pipe < TOPSIZE; pipe++) 
        {
            System.out.print(PIPE);
            for (int space = 1; space <=((3.55* SIZE)); space++) 
            {
                System.out.print(SPACE); 
            }
           
            for (int log = 0; log < LOGSIZE; log++) {
                System.out.print(PLUS_SIGN);
            }
           
            for (int space = 1; space <= ((3.5* SIZE)); space++) 
            {
                 System.out.print(SPACE);
            }
            System.out.println(PIPE);
        }
    }

//Extra Credit 
    public static void ParkingLot()
    {
        System.out.print(SPACE); 
        for (int i = 0; i < 21; i++) 
        {
            System.out.print(UNDERSCORE); 
        }
        System.out.print("\n"); 
        for (int pipe = 0; pipe < 15; pipe++) 
        {
            System.out.print(PIPE); 
            for (int i = 0; i < COLUMN_LENGTH; i++) 
            {
                for (int j = 0; j < ROW_LENGTH; j++) 
                {
                    System.out.print(UNDERSCORE); 
                    
                }
                System.out.print(PIPE);
            }
            System.out.print("\n"); 
        }
    }

}