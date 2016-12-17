package codesynced.waveform.gui;

import codesynced.waveform.audio.AudioPlayer;
import helliker.id3.MP3File;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by SuperScary - 12/16/2016
 */
public class DefaultView
{

	private Stage stage;
	private Group group;
	private Scene scene;
	private AudioPlayer player;
	private MediaView mediaView;

	private File file; /* = new File("C:/Downloads/BetterPlace.mp3");*/
	private MP3File mp3File;

	public DefaultView(Stage stage)
	{
		this.stage = stage;
		hash();
	}

	private void hash()
	{
		try {
			BrowserView browserView = new BrowserView(stage);
			file = new File(browserView.getSelectedFile().getAbsolutePath());
			mp3File = new MP3File(file.getAbsolutePath());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private String buildHeader()
	{
		StringBuilder builder = new StringBuilder();
		try {
			builder.append("Playing track #" + mp3File.getTrack() + " of " + (mp3File.getNumTracks() == -1 ? 1 : mp3File.getNumTracks()) + " - ");
			builder.append(mp3File.getTitle() + " - " + mp3File.getArtist() + " - " + mp3File.getAlbum());
		} catch (Exception e) {}

		return builder.toString();
	}

	public void initialize()
	{

		group = new Group();
		scene = new Scene(group, 800, 600);

		player = new AudioPlayer(file.getAbsolutePath());
		player.play();

		mediaView = new MediaView(player.getMediaPlayer());
		((Group) scene.getRoot()).getChildren().add(mediaView);

		stage.setTitle(buildHeader());
		stage.setScene(scene);
		stage.show();
	}

	public Stage getStage()
	{
		return stage;
	}

	public Group getGroup()
	{
		return group;
	}

	public Scene getScene()
	{
		return scene;
	}

	public AudioPlayer getPlayer()
	{
		return player;
	}

	public MediaView getMediaView()
	{
		return mediaView;
	}
}
