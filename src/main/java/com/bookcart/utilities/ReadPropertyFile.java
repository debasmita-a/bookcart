package com.bookcart.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {

	/*
	 * 
	 * This class is responsible for reading properties from the properties file.
	 * Properties class inherits from HashTable, So the propertis in the
	 * config.propertis file are stored in HashTable, which is bit slow. We can use
	 * HashMap to store and read from the file We will use a static block to load
	 * the properties HashMap //eager loading In the HashTable, the properties are
	 * stored as Object types. We need to convert it to String types
	 */
	private static Properties properties = new Properties();
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	private ReadPropertyFile() {

	}

	static {
		FileInputStream inputFile;

		try {
			inputFile = new FileInputStream("./src/test/resources/configfile/config.properties");
			properties.load(inputFile);

			for (Map.Entry<Object, Object> entry : properties.entrySet()) {
				CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(properties.getProperty(key))) {
			throw new Exception("Value not found for the key : " + key);
		}
		return CONFIG_MAP.get(key);
	}

}
