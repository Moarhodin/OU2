
/**
 * The main program that moves all three robots.
 * @name Main
 * @author ens21mrn
 * @version 2 2025-05-27
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * Main method
     * @param args command line arguments. args[0] should be the path to the maze file
     */
    public static void main(String[] args) {
        try {

            // Maze setup
            Maze maze = new Maze(new Scanner(new File(args[0])));

            // Robot setup
            int stepCount = 0;
            int stepCount2 = 0;
            int stepCount3 = 0;
            RandomRobot randomRobot = new RandomRobot(maze);
            LeftHandRuleRobot leftHandRuleRobot= new LeftHandRuleRobot(maze);
            HomingRobot homingRobot= new HomingRobot(maze);

            //Loop while robot has not found the goal symbol
            while (!randomRobot.hasReachedGoal()) {
                randomRobot.move();
                System.out.println(randomRobot.getPosition());
                stepCount++;
            }

            while (!leftHandRuleRobot.hasReachedGoal()) {
                leftHandRuleRobot.move();
                System.out.println(leftHandRuleRobot.getPosition());
                stepCount2++;
            }
            while (!homingRobot.hasReachedGoal()) {
                homingRobot.move();
                System.out.println(homingRobot.getPosition());
                stepCount3++;
            }

            System.out.println("Robot moved " + stepCount + " steps to reach Goal.");
            System.out.println("Robot moved " + stepCount2 + " steps to reach Goal.");
            System.out.println("Robot moved " + stepCount3 + " steps to reach Goal.");

        } catch (IOException e) {
            System.out.println("File could not be found/read");
        } catch (NoGoalException e) {
            System.out.println("Maze contained no goal");
        } catch (NoStartException e) {
            System.out.println("Maze contained no start");
        }

    }

}
