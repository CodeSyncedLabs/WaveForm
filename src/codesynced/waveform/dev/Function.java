package codesynced.waveform.dev;

import java.io.IOException;

/**
 * Created by SuperScary - 12/16/2016
 */
public class Function
{

	@FunctionalInterface
	public interface Checked<T, R>
	{
		R apply(T t) throws IOException;
	}

}
