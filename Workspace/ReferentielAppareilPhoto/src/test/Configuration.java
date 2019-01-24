package test;

import java.io.IOException;
import java.util.Properties;
public class Configuration {

	private static final String RESOURCE = "Constantes.properties";

	public static String CONTEXTDIRECTORY;
	public static String CONFIGFILE;

	private Configuration() {

		Properties props = new Properties();
		try {
			props.load(this.getClass().getResourceAsStream(RESOURCE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		CONTEXTDIRECTORY = props.getProperty("context.directory");
		CONFIGFILE = props.getProperty("config.file");

	}

	private static Configuration INSTANCE = new Configuration();

	public static Configuration getInstance() {
		return INSTANCE;
	}

}
