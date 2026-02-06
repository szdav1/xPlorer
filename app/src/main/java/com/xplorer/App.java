package com.xplorer;

import lib.theming.repository.ColorThemeRepository;

public class App {
	public static void main(String[] args) {
		ColorThemeRepository.loadFromResource("ColorTheme.json");
		System.out.println(ColorThemeRepository.get("XButton"));
	}
}