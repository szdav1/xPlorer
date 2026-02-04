package com.xplorer;

import lib.theming.parser.ColorThemeParser;

public class App {
	public static void main(String[] args) {
		ColorThemeParser.parseJson(ResourceManager.load("TestTheme.json"));
	}
}