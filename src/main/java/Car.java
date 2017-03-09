package main.java;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * TODO: Modify calculation of time.
 * Creates a model for the representation of a car.
 */
public class Car extends Rectangle {

    /**
     * Components of a car. Contribute to time
     * TODO: Implement these components.
     * TODO: Create relationships between them and how fast a car travels over distance.
     */
    private int engine, suspension, boost, weight;

    private double speed = 30;

    public void setSpeed(int x, int y) {
        if (x == -1) this.setX(this.getX()-speed);
        if (x == 1) this.setX(this.getX() + speed);
        if (y == -1) this.setY(this.getY() - speed);
        if (y == 1) this.setY(this.getY() + speed);
    }

    /** TODO: Turbo boost?? */
    private boolean isBoosted;


    /** The total time the car has driven for. Proportional to the distance traveled and components. */
    private double time;

    /** Reference to the turn order and identification. TODO: Associate a car to a users name ?? */
    private int id;

    private boolean isFinished;

    public Car(double x, double y, double offset, int id) {
        super(x, y, offset, offset);
        this.id = id;

        String[] names = { "bug", "blue", "black", "yellow","red"};
        URL resource = getClass().getResource("/main/resources/images/" + names[id % names.length] + ".png");
        this.setFill(new ImagePattern(new Image(resource.toString())));

        // Alternative fill, replace above setFill with the one below, and uncomment the above colors array
        // Color[] colors = { Color.CYAN, Color.PURPLE, Color.ORANGE, Color.YELLOW, Color.BLACK};
        // this.setFill(colors[id%colors.length]);
    }

    public double getTime() { return time; }

    public int getIdentifier() {
        return id;
    }

    /*
     * Moves a car from one location to another.
     * Updates the time.
     * TODO: Decide on how to compute time. Currently computed by distance traveled each time * 0.32.
     * TODO: The below calculation is completely arbitrary.
     * @param location The location to move to.
     */
    public void newLocation(double x, double y, double distanceIn) {
        this.setX(x);
        this.setY(y);
        // TODO: Here is where the components like engine could be calculated
        time += (distanceIn) * 0.32;
    }

    /**
     * @return The textual representation of a car.
     */
    @Override
    public String toString() {
        // for(Location l : stops) System.out.println(l.getName()); // Useful for debugging
        return "Car #:" + id + "\tTime traveled: " + time; //+ "\tcurrent location " + currentLocation.getName();
    }


}