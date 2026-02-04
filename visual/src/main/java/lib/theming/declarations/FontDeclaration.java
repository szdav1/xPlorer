package lib.theming.declarations;

import lib.theming.properties.FontProperty;
import lombok.Data;

@Data
public final class FontDeclaration implements Declaration {
	private FontProperty normal;
	private FontProperty hovered;
	private FontProperty clicked;
}