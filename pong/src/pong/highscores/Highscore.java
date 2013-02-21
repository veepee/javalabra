package pong.highscores;

/**
 * The Highscore class representing a single highscore entry
 * @author veepee
 */
public class Highscore implements Comparable {
    
    /**
     * The name of the player
     */
    private final String name;
    
    /**
     * The points scored
     */
    private final int points;
    
    /**
     * Creates a new Highscore entry with the given name and amount of points
     * @param name The name of the player
     * @param points The points scored
     */
    public Highscore(String name, int points) {
        this.name = name;
        this.points = points;
    }
    
    /**
     * Returns the name of the player this highscore entry belongs to
     * @return Name of the player this highscore entry belongs to
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the points scored of this highscore entry
     * @return Points scored of this highscore entry
     */
    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(Object t) {
        Highscore h = (Highscore)t;
        return h.getPoints() - this.getPoints();
    }

}