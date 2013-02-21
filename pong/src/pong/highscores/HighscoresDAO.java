package pong.highscores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The HighscoresDAO class for loading and saving the highscores data from and to
 * the disk
 * @author veepee
 */
public class HighscoresDAO {
    
    /**
     * File containing the highscores data
     */
    private File file;
    
    /**
     * List of the highscores
     */
    private ArrayList<Highscore> scores;
    
    /**
     * Creates a new HighscoresDAO object with the given highscores file
     * @param path Relative path to the file containing the highscores data or the highscores data file to be created
     */
    public HighscoresDAO(String path) {
        file = new File(path);
        
        try {
            file.createNewFile();
            try {
                scores = loadHighscores(new Scanner(new FileInputStream(file)));
            } catch(FileNotFoundException fnfe) {
                Logger.getLogger(HighscoresDAO.class.getName()).log(Level.SEVERE, null, fnfe);
            }
        } catch(IOException ioe) {
            Logger.getLogger(HighscoresDAO.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    
    /**
     * Loads the highscores data from the file
     * @param fileReader The scanner object used for reading the file contents
     * @return List of the highscores
     */
    private ArrayList<Highscore> loadHighscores(Scanner fileReader) {
        ArrayList<Highscore> hs = new ArrayList<Highscore>();
        while(fileReader.hasNext()) {
            String line = fileReader.nextLine();
            Highscore score = new Highscore(parseName(line), parsePoints(line));
            if(!score.getName().isEmpty() && score.getPoints() > 0) {
                hs.add(score);
            }
        }
        return hs;
    }
    
    /**
     * Parses the player name
     * @param line String to be parsed
     * @return Player name
     */
    private String parseName(String line) {
        String[] parts = line.split(";");
        if(parts.length == 2) {
            return parts[0];
        } else {
            return "";
        }
    }
    
    /**
     * Parses the amount of points scored
     * @param line String to be parsed
     * @return Amount of points scored
     */
    private int parsePoints(String line) {
        String[] parts = line.split(";");
        if(parts.length == 2) {
            return Integer.parseInt(parts[1]);
        } else {
            return -1;
        }
    }

    /**
     * Returns the highscore entry with the highest amount of points scored
     * @return Highscore entry with the highest amount of points scored
     */
    public int getHighestScore() {
        Collections.sort(scores);
        if(scores.size() > 0) {
            return scores.get(0).getPoints();
        }
        return 0;
    }
    
    /**
     * Returns an array containing the top-10 highscore entries, in a descending order
     * @return An array containing the top-10 highscore entries, in a descending order
     */
    public Highscore[] getHighscores() {
        Collections.sort(scores);
        
        Highscore[] top = new Highscore[10];
        for(int i = 0; i < 10; i++) {
            if(i >= scores.size()) {
                break;
            }
            top[i] = scores.get(i);
        }
        
        return top;       
    }
    
    /**
     * Inserts a new highscore entry
     * @param name The name of the player
     * @param points The amount of points scored
     */
    public void insertHighscore(String name, int points) {
        scores.add(new Highscore(name, points));
        Collections.sort(scores);
    }
    
    /**
     * Saves the highscores data to the disk
     */
    public void saveHighscores() {
        Collections.sort(scores);

        try {
            FileWriter writer = new FileWriter(file);
            for(int i = 0; i < 10; i++) {
                if(i >= scores.size()) {
                    break;
                }
                writer.write(scores.get(i).getName() + ";" + scores.get(i).getPoints() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(HighscoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}