package lib.theming.repository;

import java.util.HashMap;

import lib.theming.parser.ColorThemeParser;
import lib.theming.selector.Selector;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ColorThemeRepository {
	public static final void loadFromResource(final String path) {
		final HashMap<String, Selector> selectors = ColorThemeParser.parseJson(path);
		selectors.entrySet()
			.forEach(entry -> {
				System.out.println(entry);
			});
	}
}