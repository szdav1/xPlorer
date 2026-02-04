package lib.theming.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lib.theming.ColorThemeBackup;
import lib.theming.selector.Selector;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class ColorThemeParser {
	private static final Gson converter = new Gson();

	private static Optional<String> loadJson(final String path) {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			StringBuilder content = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null)
				content.append(line);

			return Optional.ofNullable(content.toString());
		}
		catch (Exception exc) {
			return Optional.empty();
		}
	}

	public static HashMap<String, Selector> parseJson(final String path) {
		final String json = loadJson(path).orElse(ColorThemeBackup.getBackup());
		final JsonObject rootJsonObject = converter.fromJson(json, JsonObject.class);
		final HashMap<String, Selector> selectors = new HashMap<>();

		rootJsonObject.entrySet()
			.stream()
			.filter(jsonEntry -> jsonEntry.getValue().isJsonObject())
			.forEach(entry -> selectors.put(entry.getKey(), converter.fromJson(entry.getValue(), Selector.class)));

		return selectors;
	}
}