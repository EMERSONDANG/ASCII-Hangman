public class Man {
    // INSTANCE VARIABLES
    static final int MAX_INCORRECT = 6;
    // The amount of guesses the user can make, static so you can share info
    // between main class and Man class, final so this variable can't be changed
    int numIncorrect;
    // Declare variable to store times user gets letter incorrect
    char[] body;
    // Create an array that holds characters
    
    // CONSTRUCTOR TO CONSTRUCT MAN OBJECT
    public Man() {
        body = new char[] {' ', ' ', ' ', '\n', 
                           ' ', ' ', ' ', '\n', 
                           ' ', ' ', ' ', '\n'};
        numIncorrect = 0;
        // Set the char[] body and numIncorrect in this class to those values
    }
    
    // METHODS
    
    // Used to check if game can continue to run
    public boolean isAlive() {
        return numIncorrect < MAX_INCORRECT;
        // Boolean returns true or false depending on this statement
    }
    
    // Used to convert char[] array to a String so we can print out the values. 
    // We cannot print chars unless we make a loop. Java has a built in method
    // called toString which converts any data type to a String
    // Makes an implicit call when you use System.out.println(man);
    
    @Override
    // Override means, ignore the bulit in toString() in Java and use this one
    public String toString() {
        return new String(body);
    }
    
    // void just means don't return anything. You can use if statements
    // or switch statements
    public void hang() {
        numIncorrect++;
        // Increment the numIncorrect variable in this class by 1
        // switch statement uses numIncorrect which is an integer
        switch(numIncorrect) {
            // case 1, basically means if numIncorrect = 1
            case 1:
                body[1] = 'O';
                // body which contains our char array of index 1, = 'O'
                break;
                // break so that the other cases do not get executed
            case 2:
                body[5] = '|';
                break;
            case 3:
                body[4] = '\\';
                break;
            case 4:
                body[6] = '/';
                break;
            case 5:
                body[8] = '/';
                break;
            case 6:
                body[10] = '\\';
                break;
        }
        // We use \\ and not \ because \ is a special character in Java
        // \\ is the same thing as \ and prints an actual backslash
    }
}