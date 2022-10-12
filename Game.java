package GameLogic;
import GameLogic.Frog;
import GameLogic.Car;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.util.ArrayList;

public class Game {
    //instance variables
    private Frog player;
    private ArrayList<Car> cars;

    //creating the instance methods

    /**
     * Creates a new game that instantiates a new player given its name and starting position and the constructor should add 4 cars
     * @param name
     * @param currentPosition
     */

    public Game(String name, Point currentPosition){

        cars = new ArrayList<Car>();
        player = new Frog(name, currentPosition);
        Car c1 = new Car(new Point(100,400), new Color(0,0,0), 10, 120, 75, false);
        Car c2 = new Car(new Point(0,300), new Color(0,0,255), 30, 200, 75, false);
        Car c3 = new Car(new Point(100,150), new Color(0,0,0), 10, 120, 75, true);
        Car c4 = new Car(new Point(0,80), new Color(0,0,0), 20, 120, 75, true);
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c4);
    }

    //getters that will return what the name implies

    public Frog getPlayer(){
        return player;
    }
    public ArrayList<Car> getCars(){
        return cars;
    }

    /**
     * method that responds to keyboard events by moving the player in the X or Y direction
     * @param key
     * @param speed
     */

    public void movePlayer(int key, int speed) {
        if(key == KeyEvent.VK_UP) {
            player.move(0, -speed);
        }
        if(key == KeyEvent.VK_DOWN) {
            player.move(0, speed);
        }
        if(key == KeyEvent.VK_LEFT) {
            player.move(-speed, 0);
        }
        if(key == KeyEvent.VK_RIGHT) {
            player.move(speed, 0);
        }
    }

    /**
     * method that will call each car's move method and move the cars
     * @param edge
     */

    public void moveCars(int edge) {

        //If a car moves left to right goes past the edge value, the car will move back to zero, otherwise, the car should move back to the right edge
        for(Car car: cars) {
            car.move();
            if(car.isMoveLeft()) {
                if(car.getCurrentPosition().x<=0) {
                    car.getCurrentPosition().translate(-car.getCurrentPosition().x+edge, 0);
                }
            }
            else {
                if(car.getCurrentPosition().x>=edge) {
                    car.getCurrentPosition().translate(-car.getCurrentPosition().x, 0);
                }
            }
        }
    }

    /**
     * method that will return true if the player was hit by a car
     */
    public boolean isPlayerHit() {
        for(Car car: cars) {
            if(player.getCollisionBounds().intersects(car.getCollisionBounds())) {
                return true;
            }
        }
        return false;
    }

    /**
     *method that will return true if the player won being the y coordinate of the player is less than 20,included
     */
    public boolean hasPlayerWon() {
        if(player.getCurrentPosition().y<=20) {
            return true;
        }
        return false;
    }
}
