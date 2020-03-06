import robocode.*;
import java.awt.Color;
import java.util.Random;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Dumle - a robot by Elias
 */
public class Dumle extends Robot
{
    /**
     * run: Dumle's default behavior
     */

    private static String roomba = "sample.MyFirstRobot";
    private final Color[] colors = {Color.BLUE, Color.YELLOW, Color.ORANGE, Color.RED, Color.GREEN};

    public void run() {
        // Initialization of the robot should be put here
//        setAllColors(Color.DARK_GRAY);
//        colors.add(Color.BLUE, Color.YELLOW, Color.ORANGE, Color.RED, Color.GREEN);
        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        // Robot main loop
        while(true) {
            turnGunRight(360);
            ahead(25);
            changeColor();
        }
    }

    public void changeColor(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(colors.length);
        setAllColors(colors[randomIndex]);
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getName().equals(roomba)){
            double bearing = e.getBearing();
            double distance = e.getDistance();
            turnRight(bearing - 10);
            ahead(distance - 10);
            double gunHeading = e.getHeading();
        } else {
            fire(1);
        }
        changeColor();
    }

    public void onHitRobot(HitRobotEvent e){
        turnRight(25);
        changeColor();
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
//        ahead(100);
//        back(50);
        changeColor();
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        turnRight(45);

    }
}
