/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author holo7
 */
public class PlaybackThread extends Thread {

    Long currentFrame;
    Clip clip;
    AudioInputStream audioInputStream;
    private static boolean threadDone;

    // current status of clip 
    String status;

    @Override
    public void run() {
        while (!threadDone) {
            try {
                
                
                
            } catch (Exception e) {
                
                System.out.println("Something wrong happened with the music thread.");
                e.printStackTrace();
            }
        }
    }

}
