package com.xplorer;

import theming.repository.ColorThemeRepository;

public class App {
	public static void main(String[] args) {
		ColorThemeRepository.loadFromResource("ColorTheme.json");
		System.out.println(ColorThemeRepository.get("XButton"));
	}
}