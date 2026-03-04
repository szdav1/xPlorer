package theming.appearance.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScaleType {
	ABSOLUTE("absolute"),
	RELATIVE("relative");

	private final String value;
}