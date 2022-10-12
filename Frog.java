package GameLogic;

import java.awt.*;

public class Frog {
    //instance variables

    private String name;
    private Point currentPosition;

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return A rectangle object defining the bounds of the frog
     */

    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x,currentPosition.y,30,30);
    }
    //creating the instance methods

    /**
     * a new frog object given a name and starting position
     * @param name
     * @param currentPosition
     */
    public Frog(String name, Point currentPosition){
        this.name = name;
        this.currentPosition = currentPosition;
    }

    /**
     * creates a method that takes a name and at position (0,0)
     * @param name
     */

    public Frog(String name){
        this.name = name;
        this.currentPosition = new Point();
    }
    /**
     * Returns the currentPosition of the Frog object
     * @return currentPosition
     */

    public Point getCurrentPosition(){
        return currentPosition;
    }


    /**
     * translates the Frog given an x and y translations
     * @param x
     * @param y
     * @return currentPosition
     */

    public Point move(int x, int y){
        currentPosition.translate(x, y);
        return currentPosition;
    }
    /**
     * computes the distance between the frog object and the point
     * @param p1
     * @return distance
     */

    public double distanceFromPoint(Point p1){
        double distance = p1.distance(currentPosition);
        return distance;
    }
    /**
     * Returns a string representation of the frog according to the given example
     */

    public String toString(){
        String text = "The frog named " + this.name + "is at " + "(" + currentPosition.x + "," + currentPosition.y + ")";
        return text;
    }

    /**
     * getName method
     * @return name
     */
    public String getName(){
        return name;
    }
}