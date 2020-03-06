import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Dumle - a robot by Elias
 */
public class Dumle extends Robot
{
    /**
     * run: Dumle's default behavior
     */

    private static String roomba = "sample.Fire";
    public void run() {
        // Initialization of the robot should be put here
        setAllColors(Color.DARK_GRAY);
        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        // Robot main loop
        while(true) {
            turnGunRight(360);
            ahead(25);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getName().equals(roomba)){
            double bearing = e.getBearing();
            double distance = e.getDistance();
            turnRight(bearing);
            ahead(distance - 10);
        } else {
            fire(1);
        }
    }

    public void onHitRobot(HitRobotEvent e){
        turnRight(25);
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        ahead(100);
        back(50);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        turnRight(45);

    }
}
