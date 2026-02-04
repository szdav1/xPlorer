package lib.theming.declarations;

import lib.theming.properties.IconProperty;
import lombok.Data;

@Data
public final class IconDeclaration implements Declaration {
	private IconProperty normal;
	private IconProperty hovered;
	private IconProperty clicked;
}