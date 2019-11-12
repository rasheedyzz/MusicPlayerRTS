/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theboringplayer;

import java.util.ArrayList;

/**
 *
 * @author holo7
 */
public class Playlist {

    static ArrayList<Track> tracksInPlaylist = new ArrayList<Track>();

    public static ArrayList<Track> getTracksInPlaylist() {
        return tracksInPlaylist;
    }

    public void addTrackToPlaylist(Track track) {
        tracksInPlaylist.add(track);
    }

    public void removeFromPlaylist(int index) {
        tracksInPlaylist.remove(index);
    }

}
