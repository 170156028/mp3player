package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    @FXML

    private Label songName;
    private File [] files;
    List<File> songs;
    private File directory;
    private int songIndex;
    private Media media;
    private MediaPlayer mediaPlayer;
    private File currentSongFile;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        songs = new ArrayList<>();
        songIndex = 0;
        directory = new File("musically");
        files = directory.listFiles();
        if (files != null) {
            for(File file: files) {
                songs.add(file);
            }
        }



        File currentSongFile = songs.get(songIndex);
        songName.setText(currentSongFile.getName());
        media = new Media(currentSongFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);

    }

    public void play() {
        mediaPlayer.play();
    }

    public void pause() {

        mediaPlayer.pause();
    }

    public void next() {
        mediaPlayer.stop();
        songIndex++;
        if(songIndex > songs.size()-1) {
            songIndex = 0;
        }

        currentSongFile = songs.get(songIndex);
        songName.setText(currentSongFile.getName());
        media = new Media(currentSongFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void previous() {
        mediaPlayer.stop();
        songIndex--;
        if(songIndex < 0) {
            songIndex = songs.size() -1;
        }

        currentSongFile = songs.get(songIndex);
        songName.setText(currentSongFile.getName());
        media = new Media(currentSongFile.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }




}