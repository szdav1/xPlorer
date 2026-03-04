package theming.appearance.consts;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FontLigature {
	BOLD("bold"),
	ITALIC("italic"),
	BOLD_AND_ITALIC("bold_and_italic"),
	NORMAL("normal");

	private final String value;
}