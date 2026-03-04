package com.xplorer;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import theming.appearance.Appearance;
import theming.repository.ColorThemeRepository;
import xwt.components.xlabel.XLabel;
import xwt.components.xpanel.XPanel;

public class App {
	public static class TestFrame extends JFrame {
		public TestFrame() {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(new Dimension(800, 800));
			this.setLayout(new FlowLayout());
			this.setLocationRelativeTo(null);
		}
	}

	public static void main(String[] args) {
		ColorThemeRepository.loadFromResource(ResourceManager.load("ColorTheme.json"));
		ResourceManager.createExactPaths(ColorThemeRepository.getAppearances());
		Appearance a = ColorThemeRepository.get("XButton");

		System.out.println(a.getIcon().getNormalConfig().getSrc());

		TestFrame tf = new TestFrame();
		// XPanel panel = new XPanel(new Dimension(500, 300), a);
		XLabel label = new XLabel(new Dimension(500, 500), "Hello!", a);

		tf.add(label);
		tf.setVisible(true);
	}
}