/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.io.File;

/**
 *
 * @author holo7
 */
public class Track {

    static File trackFile;
    String trackName;
    String trackArtist;
    String trackAlbum;
    Enum trackDuration;
    String path;

    public Track(String path) {
        this.path = path;
        trackFile = new File(path);
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
   
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public void setTrackAlbum(String trackAlbum) {
        this.trackAlbum = trackAlbum;
    }

    public void setTrackDuration(Enum trackDuration) {
        this.trackDuration = trackDuration;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public String getTrackAlbum() {
        return trackAlbum;
    }

    public Enum getTrackDuration() {
        return trackDuration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
