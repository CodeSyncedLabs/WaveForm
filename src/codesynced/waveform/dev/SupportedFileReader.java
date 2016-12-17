package codesynced.waveform.dev;

import javafx.stage.FileChooser;

import java.io.*;

/**
 * Created by SuperScary - 12/16/2016
 */
public class SupportedFileReader
{

	private static File file = new File("codesynced.waveform.SupportedFiles.waveform");
	private static FileChooser.ExtensionFilter extensionFilters[];

	public static FileChooser.ExtensionFilter[] readToMemory()
	{

		try {
			int lines = countLines(file.getAbsolutePath());
			System.out.println(lines);
			extensionFilters = new FileChooser.ExtensionFilter[lines];

			BufferedReader reader = new BufferedReader(new FileReader(file));

			for (int i = 0; i < lines; i++)
			{
				String desc = formattedForm(reader.readLine())[0];
				String form = formattedForm(reader.readLine())[1];
				System.out.println(desc + " - " + form);
				extensionFilters[i] = new FileChooser.ExtensionFilter(desc, form);
			}

		} catch (Exception e) {}

		return extensionFilters;
	}

	public static int countLines(String filename) throws IOException
	{
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	private static String[] formattedForm(String par1Str)
	{
		String[] s = new String[2];
		s[0] = par1Str + " files (*." + par1Str.toLowerCase() + ")";
		s[1] = "*." + par1Str.toLowerCase();
		return s;
	}

}
