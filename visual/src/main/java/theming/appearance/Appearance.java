package theming.appearance;

import lombok.AllArgsConstructor;
import lombok.Data;
import theming.appearance.configs.BackgroundConfiguration;
import theming.appearance.configs.BorderConfiguration;
import theming.appearance.configs.FontConfiguration;
import theming.appearance.configs.ForegroundConfiguration;
import theming.appearance.configs.IconConfiguration;
import theming.appearance.consts.UIState;
import theming.selector.Selector;

@Data
@AllArgsConstructor
public final class Appearance {
	private final BackgroundConfiguration background;
	private final ForegroundConfiguration foreground;
	private final BorderConfiguration border;
	private final FontConfiguration font;
	private final IconConfiguration icon;
	private UIState state;

	public Appearance() {
		this.background = new BackgroundConfiguration();
		this.foreground = new ForegroundConfiguration();
		this.border = new BorderConfiguration();
		this.font = new FontConfiguration();
		this.icon = new IconConfiguration();
		this.state = UIState.NORMAL;
	}

	public Appearance(final Selector selector) {
		this.background = new BackgroundConfiguration(selector.getBackground());
		this.foreground = new ForegroundConfiguration(selector.getForeground());
		this.border = new BorderConfiguration(selector.getBorder());
		this.font = new FontConfiguration(selector.getFont());
		this.icon = new IconConfiguration(selector.getIcon());
		this.state = UIState.NORMAL;
	}
}