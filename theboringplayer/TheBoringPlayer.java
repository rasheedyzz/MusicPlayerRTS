/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author holo7
 */
public class TheBoringPlayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        
        System.out.println("Welcome to the boring player!");
        System.out.println("Library initializing...");
        Library lib = new Library("Z:\\Studies\\Real Time Systems\\Music");
        lib.start();
        Playback playback = new Playback(lib.getListOfTracks());
        playback.start();
        playback.playNext();
        playback.playPrevious();
       
    }
    
}
