import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Welcome to the ASCII Version of Hangman!");   
        
        // Create console object to store "secret password", "secret word"
        // Can use Scanner, BufferedReader but Console is best choice here
        
        Console console = System.console();
        
        // Create another char array that stores the "secret word" given by user
        // Variable name called letters, use the console object and use
        // built in function .readPassword. Each index contains one letter
        
        char[] letters = console.readPassword("Please enter a secret word: ");
        
        // For loop to convert all characters in char array to uppercase
        
        for (int i = 0; i < letters.length; i++) {
            letters[i] = Character.toUpperCase(letters[i]);
            // In the letters char array of index i, i is an int, turn 
            // each letter (character) into uppercase
        }
        
        // Create another char array of same length as our letters char array
        
        char[] puzzle = new char[letters.length];
        
        for (int i = 0; i < puzzle.length; i++) {
            puzzle[i] = '_';
            // Adds an underscore to each index of the puzzle char array
        }
        
        // Create Man object and Scanner object
        
        Man man = new Man();
        Scanner scanner = new Scanner(System.in);
        
        // Use while loop, and in parantheses use the method of isAlive() in
        // the Man class
        
        while(man.isAlive()) {
            // Print out the underscore array, aka the puzzle array
            System.out.println("Puzzle to solve: ");
            for (int i = 0; i < puzzle.length; i++) {
                System.out.print(puzzle[i] + " ");
                // Use " " so that the underscores do not print out a line
            }
            System.out.println();
            // Prints an empty line, line of space
            
            System.out.print("Please guess a letter: ");
            char guessLetter = scanner.nextLine().toUpperCase().charAt(0);
            // Create a char variable called guess. Use the scanner class
            // to read the input from user, change input all to uppercase,
            // userchatAt so that first letter will only be checked
            // IF user enters a word
            
            boolean containsGuess = false;
            for(int i = 0; i < letters.length; i++) {
                if (guessLetter == letters[i]) {
                  puzzle[i] = guessLetter;
                  containsGuess = true;
                }                         
                
                if (containsGuess == false && i == letters.length - 1) {
                    man.hang();
                    // Updates the char array and adds 1 to the numIncorrect
                    System.out.println(man);
                    // Prints out the char array
                }             
            }
            
            // Convert puzzle char array and letters char array to Strings
            // to check if they are the same. If they are the same. break
            // out of while loop, else this while loop will terminate once
            // numIncorrect < MAX_INCORRECT is false.
            
            // Convert our char arrays to Strings
            String answer = new String(letters);
            String theGuess = new String(puzzle);
            
            if (answer.equals(theGuess)) {
              System.out.println(theGuess);
              break;
            }         
        }
        
        if (man.isAlive()) {
            System.out.println("The guesser has won!");
        } else {
            System.out.println("The guesser has lost!");
            String answer = new String(letters);
            System.out.println("The word was " + answer);
        }
    }
}