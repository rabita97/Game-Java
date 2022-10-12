package GameLogic;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Car {

    //creating the Instance Variables

    private Point currentPosition;
    private Color bodyColor;
    private int movementSpeed;
    private int xSize;
    private int ySize;
    private boolean moveLeft;

    //creating the instance methods
    public Car(Point currentPosition, Color bodyColor, int movementSpeed, int xSize, int ySize, boolean moveLeft){
        this.xSize  = xSize;
        this.ySize = ySize;
        this.movementSpeed = movementSpeed;
        this.currentPosition = currentPosition;
        this.bodyColor = bodyColor;
        this.moveLeft = moveLeft;
    }

    /**
     * @return Point return the currentPosition
     */

    public Point getCurrentPosition() {
        return currentPosition;
    }

    /**
     * @return Color return the bodyColor
     */

    public Color getBodyColour() {
        return bodyColor;
    }

    /**
     * @return int return the xSize
     */

    public int getXSize() {
        return xSize;
    }

    /**
     * @return int return the ySize
     */

    public int getYSize() {
        return ySize;
    }

    /**
     * @return int return the movementSpeed
     */
    public int getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * Returns true if the car is moving left
     * @return boolean return moveLeft
     */
    public boolean isMoveLeft() {
        return moveLeft;
    }

    /*this method moves the car in the X direction using movementSpeed as the step/value. It takes into account the moveLeft variable to define if it
    should move from left to right or right to left*/

    public void move() {
        if(isMoveLeft()) {
            currentPosition.x = currentPosition.x - movementSpeed;
        }
        else{
            currentPosition.x = currentPosition.x + movementSpeed;
        }
    }

    /**
     * Returns the bounds of the car object which can be used to detect collision
     * @return A rectangle object defining the bounds of the car
     */
    public Rectangle getCollisionBounds(){
        return new Rectangle(currentPosition.x, currentPosition.y,xSize,ySize);
    }
}