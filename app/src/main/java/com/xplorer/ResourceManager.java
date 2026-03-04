package com.xplorer;

import java.net.URL;
import java.util.HashMap;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import theming.appearance.Appearance;
import theming.appearance.configs.IconConfiguration;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ResourceManager {
	public static String load(final String path) {
		URL pathURL = ResourceManager.class.getResource("/" + path);

		if (pathURL == null) 
			return "resources/" + path;

		return pathURL.getFile();
	}

	public static void createExactPaths(final HashMap <String, Appearance> appearances) {
		appearances.entrySet()
		.forEach(entry -> {
			IconConfiguration iconConfig = entry.getValue()
				.getIcon();

			iconConfig.getNormalConfig()
				.setSrc(load(iconConfig.getNormalConfig().getSrc()));

			iconConfig.getHoveredConfig()
				.setSrc(load(iconConfig.getHoveredConfig().getSrc()));

			iconConfig.getClickedConfig()
				.setSrc(load(iconConfig.getClickedConfig().getSrc()));
		});
	}
}