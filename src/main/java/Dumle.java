import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Dumle - a robot by Elias
 */
public class Dumle extends Robot
{
    /**
     * run: Dumle's default behavior
     */

    private static String roomba = "Interactive";
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar

        // Robot main loop
        while(true) {
            turnGunRight(360);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getName() == roomba){  // Albert
            double bearing = e.getBearing();
            double distance = e.getDistance();
            turnRight(bearing);
            ahead(distance);
        } else {
            fire(1);
        }
    }

    public void onHitRobot(HitRobotEvent e){
        if (e.getName() == roomba){

        }
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        ahead(100);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);

    }
}
