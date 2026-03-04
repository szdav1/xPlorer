package theming.repository;

import java.util.HashMap;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import theming.appearance.Appearance;
import theming.parser.ColorThemeParser;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ColorThemeRepository {
	@Getter
	private static final HashMap <String, Appearance> appearances = new HashMap<>();

	public static final void loadFromResource(final String path) {
		ColorThemeParser.parseJson(path)
			.entrySet()
			.forEach(selectorEntry -> appearances.put(selectorEntry.getKey(), new Appearance(selectorEntry.getValue())));
	}

	public static Appearance get(final String name) {
		return Optional.ofNullable(appearances.get(name)).orElse(new Appearance());
	}
}