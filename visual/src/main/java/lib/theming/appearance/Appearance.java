package lib.theming.appearance;

import lib.theming.appearance.configs.BackgroundConfiguration;
import lib.theming.appearance.configs.BorderConfiguration;
import lib.theming.appearance.configs.FontConfiguration;
import lib.theming.appearance.configs.ForegroundConfiguration;
import lib.theming.appearance.configs.IconConfiguration;
import lib.theming.selector.Selector;
import lombok.Data;

@Data
public final class Appearance {
	private final BackgroundConfiguration background;
	private final ForegroundConfiguration foreground;
	private final BorderConfiguration border;
	private final FontConfiguration font;
	private final IconConfiguration icon;

	public Appearance() {
		this.background = new BackgroundConfiguration();
		this.foreground = new ForegroundConfiguration();
		this.border = new BorderConfiguration();
		this.font = new FontConfiguration();
		this.icon = new IconConfiguration();
	}

	public Appearance(final Selector selector) {
		this.background = new BackgroundConfiguration(selector.getBackground());
		this.foreground = new ForegroundConfiguration(selector.getForeground());
		this.border = new BorderConfiguration(selector.getBorder());
		this.font = new FontConfiguration(selector.getFont());
		this.icon = new IconConfiguration(selector.getIcon());
	}
}