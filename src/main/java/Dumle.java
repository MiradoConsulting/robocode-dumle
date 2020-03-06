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

    private static String roomba = "Roomba";
    private static String bitch = "Biatch";
//    private static String roomba = "sample.RamFire";
    private final Color[] colors = {Color.BLUE, Color.YELLOW, Color.ORANGE, Color.RED, Color.GREEN};

    public void run() {
        // Robot main loop
        while(true) {
            turnGunRight(360);
            ahead(100);
            changeColor();
        }
    }


    public void changeColor(){
        Random generator = new Random();
        int randomIndex = generator.nextInt(colors.length);
        setAllColors(colors[randomIndex]);
    }

//    public void follow(ScannedRobotEvent e, int safeMargin){
//        double bearing = e.getBearing();
//        double distance = e.getDistance();
//        turnRight(bearing - safeMargin);
//        ahead(distance - safeMargin);
//    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getName().contains(roomba) || e.getName().contains(bitch)) {
            turnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
            turnRight(e.getBearing());

            if (e.getDistance() > 150) {
                ahead(e.getDistance() - 150);
            }
            else if (e.getDistance() < 75){
                back(50);
            }
                // Move to the right
//                turnRight(25);
//                turnGunRight(360);
//                if (!e.getName().contains(roomba)){
//                    turnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
//                    turnRight(e.getBearing());
//                    fire(1);
//                }
//            }
        }
        changeColor();
    }

    public void onHitRobot(HitRobotEvent e){
        if (!e.getName().contains(roomba)){
            turnRight(25);
        }
        changeColor();
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
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
