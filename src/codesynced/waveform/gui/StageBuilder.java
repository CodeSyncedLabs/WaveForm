package codesynced.waveform.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by SuperScary - 12/16/2016
 */
public class StageBuilder extends Stage
{

	private Group group;
	private Scene scene;

	private int x_Size = 800;
	private int y_Size = 600;

	public StageBuilder(Stage stage)
	{
		preloadDefaults();
	}

	public StageBuilder()
	{
		this(new Stage());
	}

	private void preloadDefaults()
	{
		group = new Group();
		scene = new Scene(group, x_Size, y_Size);
	}

}
