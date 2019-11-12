/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author holo7
 */
public class Playback extends Thread {

    Queue queueToBePlayed = new Queue();
    int nowPlayingSongIndex;
    Long currentFrame;
    Clip clip;
    AudioInputStream audioInputStream;
    String status;

    Playback(ArrayList<Track> tracksSource) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        initializeQueue(tracksSource);
        audioInputStream =  
                AudioSystem.getAudioInputStream(Track.trackFile.getAbsoluteFile()); 
          
        // create clip reference 
        clip = AudioSystem.getClip();
    }
    
     @Override
    public void run() {
            try {
                
                this.startPlaying(nowPlayingSongIndex);
                
            } catch (Exception e) {
                
                System.out.println("Something wrong happened with the music thread.");
                e.printStackTrace();
            }
    }

    void initializeQueue(ArrayList<Track> listOfTracks) {

        queueToBePlayed.tracksInQueue.addAll(listOfTracks);

        if (queueToBePlayed.tracksInQueue.isEmpty()) {
            System.out.println("Something wrong happened. Queue is still empty.");
        } else {
            System.out.println("Queue initalized. Contains " + queueToBePlayed.tracksInQueue.size() + " songs.");
        }

    }

    void playNext() {
        startPlaying(nowPlayingSongIndex + 1);

    }

    void playPrevious() {
        startPlaying(nowPlayingSongIndex - 1);
    }

    void startPlaying(int songIndexInQueue) {

        Track songToBePlayed = queueToBePlayed.tracksInQueue.get(songIndexInQueue);
        System.out.println("Now Playing: " + songToBePlayed.getPath());
        nowPlayingSongIndex = songIndexInQueue;
        clip.start();
        status = "play";

    }

    void shuffleQueue() {
        
        queueToBePlayed.shuffleQueue();
    }

    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame
                = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void stopPlaying() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        if (c > 0 && c < clip.getMicrosecondLength()) {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.startPlaying(nowPlayingSongIndex);
        }
    }

    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                Track.trackFile.getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
