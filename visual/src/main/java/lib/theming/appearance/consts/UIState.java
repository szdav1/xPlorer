package lib.theming.appearance.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UIState {
	NORMAL("normal"),
	HOVERED("hovered"),
	CLICKED("clicked");

	private final String value;
}