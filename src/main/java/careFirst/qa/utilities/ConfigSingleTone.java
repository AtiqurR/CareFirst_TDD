package careFirst.qa.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

import careFirst.qa.reporting.Logger;

public class ConfigSingleTone {

	static ConfigSingleTone config;
	private String path = "./configuration/config.properties";
	private Properties properties;
	private String url;
	private int explicitWait;
	private int pageLoadWait;
	private int implicitWait;

	private ConfigSingleTone() {

	}

	public static ConfigSingleTone getInstance() {
		if (config == null) {
			config = new ConfigSingleTone();
		}
		config.loadProperties();
		return config;
	}

	private void loadProperties() {
		FileReader fileReader;
		try {
			fileReader = new FileReader(path);
			properties = new Properties();
			properties.load(fileReader);
			url = properties.getProperty("url");
			try {
				explicitWait = Integer.parseInt(properties.getProperty("explicitWait"));
				pageLoadWait = Integer.parseInt(properties.getProperty("pageLoadWait"));
				implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
			} catch (NumberFormatException e) {
				Logger.log("Check your config file" + new File(path).getAbsolutePath());
				Assert.fail();
			}
		} catch (IOException e) {
			e.printStackTrace();
			Logger.log("File not found");
		}
	}

	public String getUrl() {
		return url;
	}

	public int explicitWait() {
		return explicitWait;
	}

	public int pageLoadWait() {
		return pageLoadWait;
	}

	public int implicitWait() {
		return implicitWait;

	}

}
