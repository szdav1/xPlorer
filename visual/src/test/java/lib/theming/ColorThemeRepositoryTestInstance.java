package lib.theming;

import java.util.HashMap;
import java.util.Optional;

import lib.theming.appearance.Appearance;
import lib.theming.parser.ColorThemeParser;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ColorThemeRepositoryTestInstance {
	private static final HashMap<String, Appearance> appearances = new HashMap<>();

	public static final void loadFromResource(final String path) {
		ColorThemeParser.parseJson(path)
			.entrySet()
			.forEach(selectorEntry -> appearances.put(selectorEntry.getKey(), new Appearance(selectorEntry.getValue())));
	}

	public static Appearance get(final String name) {
		return Optional.ofNullable(appearances.get(name)).orElse(new Appearance());
	}
}