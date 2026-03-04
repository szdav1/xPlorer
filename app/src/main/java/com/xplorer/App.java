package com.xplorer;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import theming.appearance.Appearance;
import theming.repository.ColorThemeRepository;
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
		Appearance a = ColorThemeRepository.get("XButton");
		TestFrame tf = new TestFrame();
		XPanel panel = new XPanel(new Dimension(500, 300), a);

		tf.add(panel);
		tf.setVisible(true);
	}
}