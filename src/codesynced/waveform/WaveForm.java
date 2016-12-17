package codesynced.waveform;

import codesynced.waveform.gui.DefaultView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by SuperScary - 12/16/2016
 */
public class WaveForm extends Application
{


	@Override
	public void start(Stage stage)
	{
		DefaultView view = new DefaultView(stage);
		view.initialize();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
