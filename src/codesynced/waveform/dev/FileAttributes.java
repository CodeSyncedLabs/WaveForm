package codesynced.waveform.dev;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by SuperScary - 12/16/2016
 */
public class FileAttributes
{

	private Path path;
	private File file;
	private BasicFileAttributes attributes;

	public FileAttributes(File file)
	{
		this.file = file;
		hash();
	}

	public FileAttributes(String path)
	{
		this(new File(path));
	}

	public void hash()
	{
		try {
			path = file.toPath();
			attributes = Files.readAttributes(path, BasicFileAttributes.class);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getCreationTime()
	{
		return attributes.creationTime().toString();
	}

}
