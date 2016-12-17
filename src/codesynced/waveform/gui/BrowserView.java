package codesynced.waveform.gui;

import codesynced.waveform.dev.SupportedFileReader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by SuperScary - 12/16/2016
 */
public class BrowserView
{

	private Stage stage;
	private FileChooser chooser;
	private File selectedFile;

	public BrowserView(Stage stage)
	{
		this.stage = stage;
		this.chooser = new FileChooser();
		hash();
	}

	private void hash()
	{
		chooser.setTitle("Open Resource File");
		chooser.setInitialDirectory(new File(System.getProperty("user.home")));

		FileChooser.ExtensionFilter[] extensionFilter = SupportedFileReader.readToMemory();
		for (FileChooser.ExtensionFilter filters : extensionFilter)
		{
			chooser.getExtensionFilters().add(filters);
		}

		selectedFile = chooser.showOpenDialog(stage);
	}

	public FileChooser getChooser()
	{
		return chooser;
	}

	public File getSelectedFile()
	{
		return selectedFile;
	}

}
