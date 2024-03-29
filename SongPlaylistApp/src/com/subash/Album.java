package com.subash;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    public String name;
    public String artist;
    public ArrayList<Song> songs;

    //Constructor with parameter
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    //Constructor without parameter
    public Album(){

    }

    //this method is used to find the song inside the arraylist
    public Song findSong(String title){

        for(Song checkedSong: songs){
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }

    //method created for add song if it is not exit in arraylist
    //if song is exit it show message
    public boolean addSong(String title,double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
//            System.out.println(title + " Successfully added to the list");
            return true;
        }else{
//            System.out.println("Song with name"+ title+"already exit the list");
            return false;
        }
    }
//method addtoplaylist using tracknumber and linkedlist to addsongs
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if(index > 0 && index <= this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
//        System.out.println("this album does not have song with trackNumber"+trackNumber);
        return false;
    }
    // method add playlist using the title and linkedlist to addsongs
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        for(Song checkedSong: this.songs){
            if(checkedSong.getTitle().equals(title)){
                playList.add(checkedSong);
                return true;
            }
        }
//        System.out.println(title + "there is no such song in album");
        return false;
    }

}
