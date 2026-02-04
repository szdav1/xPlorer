package com.xplorer;

import java.net.URL;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ResourceManager {
	public static String load(final String path) {
		URL pathURL = ResourceManager.class.getResource("/" + path);

		if (pathURL == null) 
			return "resources/" + path;

		return pathURL.getFile();
	}
}