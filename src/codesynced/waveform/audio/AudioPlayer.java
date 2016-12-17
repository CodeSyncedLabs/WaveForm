package codesynced.waveform.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * Created by SuperScary - 12/16/2016
 */
public class AudioPlayer
{

	private String path;
	private Media media;
	private MediaPlayer mediaPlayer;

	public AudioPlayer(String path)
	{
		this.path = path;
		hash();
	}

	private void hash()
	{
		try
		{
			File file = new File(path);
			this.media = new Media(file.toURI().toURL().toString());
			mediaPlayer = new MediaPlayer(media);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void play()
	{
		mediaPlayer.play();
	}

	public MediaPlayer getMediaPlayer()
	{
		return mediaPlayer;
	}

	public Media getMedia()
	{
		return media;
	}

}
