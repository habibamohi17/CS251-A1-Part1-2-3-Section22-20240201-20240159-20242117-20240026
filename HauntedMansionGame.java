//Ahmed Khaled Ahmed Soliman
//20240026

import java.util.Random;
import java.util.Scanner;

public class HauntedMansionGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static final String[] MONSTERS = { "wicked fairy", "ugly monster", "ghost" };

    public static void main(String[] args) {
        System.out.println("Starting Haunted Mansion Adventure...\n");
        delay(800);
        mainGame();
    }

    private static void mainGame() {
        int score = 0;

        slowPrint("Hi, welcome to your adventure world!");
        delay(1500);

        slowPrint("\nYou wake up in a dimly lit room,");
        slowPrint("disoriented and unsure of how you got there.");
        delay(1200);

        slowPrint("As you look around,");
        slowPrint("you notice the room is filled with old, dusty furniture");
        slowPrint("cobwebs hang from the ceiling.");
        delay(1200);

        slowPrint("You realize that you are inside a haunted mansion!!");
        delay(1800);

        slowPrint("As you gather your courage,");
        slowPrint("you decide to explore the mansion.");
        delay(1200);

        slowPrint("To your left, you see a staircase leading to upper floors,");
        slowPrint("where a bedroom is located.");
        slowPrint("To your right, a narrow corridor disappears into darkness.");
        delay(1500);

        slowPrint("\nEnter (1) go left and go up the staircase");
        slowPrint("     (2) go right and walk through the narrow corridor");

        String choice = getInput();

        if (choice.equals("1")) {
            pathStairs(score);
        } else if (choice.equals("2")) {
            pathCorridor(score);
        } else {
            slowPrint("Please enter 1 or 2");
            mainGame(); // restart choice
        }
    }

    private static void pathStairs(int score) {
        delay(1500);
        slowPrint("You go up the stairs and enter the upper room...");
        delay(1200);
        slowPrint("...where you find a hall and suddenly fall through the floor!");
        delay(1500);

        slowPrint("\nYou lose!");
        slowPrint("Your final score: " + score);
        delay(2000);

        askPlayAgain();
    }

    private static void pathCorridor(int score) {
        delay(1200);
        slowPrint("You walk through the corridor and find two rooms.");
        score += 10;
        slowPrint("Great choice! You earned " + score + " points!");
        delay(1800);

        corridorChoice(score);
    }

    private static void corridorChoice(int score) {
        slowPrint("\nChoose either room (1) or (2): ");
        String room = getInput();

        if (room.equals("1")) {
            slowPrint("You find just a wall in front of you...");
            delay(1200);
            slowPrint("You decide to go back.");
            delay(1500);
            slowPrint("Your score is still " + score + "!");
            slowPrint("Write 'ok' to continue...");

            waitForOk();
            corridorChoice(score); // loop back to room choice
        } else if (room.equals("2")) {
            delay(1200);
            slowPrint("You are about to knock, when the door opens...");
            delay(1000);

            String monster = MONSTERS[random.nextInt(MONSTERS.length)];
            slowPrint("and out steps a " + monster + "!");
            delay(1200);
            slowPrint("It finds you!");
            score += 10;
            slowPrint("Your score is now " + score);
            delay(1500);

            slowPrint("\nChoose:");
            slowPrint("(1) cast a spell");
            slowPrint("(2) run away");

            finalChoice(score);
        } else {
            slowPrint("Please enter 1 or 2");
            corridorChoice(score);
        }
    }

    private static void finalChoice(int score) {
        String action = getInput();

        if (action.equals("1")) {
            delay(1200);
            slowPrint("As it moves to attack,");
            slowPrint("you raise your new Wand of Ogoroth.");
            delay(1500);
            slowPrint("But it takes one look at your shiny new wand...");
            slowPrint("and runs away screaming!");
            delay(1800);

            slowPrint("You have scared it away. You are victorious!");
            score += 10;
            slowPrint("Final score: " + score);
            delay(2000);

            askPlayAgain();
        } else if (action.equals("2")) {
            delay(1200);
            slowPrint("You run... but it chases you...");
            delay(1500);
            slowPrint("and catches you!");
            delay(1200);

            slowPrint("You lose!");
            slowPrint("Your score was: " + score);
            delay(1800);

            askPlayAgain();
        } else {
            slowPrint("Please enter 1 or 2");
            finalChoice(score);
        }
    }

    private static void askPlayAgain() {
        slowPrint("\nPlay again? (y/n)");
        String answer = getInput().toLowerCase();

        if (answer.equals("y") || answer.equals("yes")) {
            System.out.println("\n-----------------------------------\n");
            mainGame();
        } else if (answer.equals("n") || answer.equals("no")) {
            slowPrint("Thanks for playing! Goodbye.");
            System.exit(0);
        } else {
            slowPrint("Please enter y or n");
            askPlayAgain();
        }
    }

    private static void waitForOk() {
        String input = getInput();
        if (!input.equalsIgnoreCase("ok")) {
            slowPrint("Please write 'ok'");
            waitForOk();
        }
    }

    private static String getInput() {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    private static void slowPrint(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            delay(35); // adjust speed (higher = slower)
        }
        System.out.println();
    }

    private static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}