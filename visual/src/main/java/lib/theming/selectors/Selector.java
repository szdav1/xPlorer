package lib.theming.selectors;

import lib.theming.declarations.BorderDeclaration;
import lib.theming.declarations.FontDeclaration;
import lib.theming.declarations.IconDeclaration;
import lib.theming.declarations.PaintDeclaration;
import lombok.Data;

@Data
public final class Selector {
	private PaintDeclaration background;
	private PaintDeclaration foreground;
	private BorderDeclaration border;
	private FontDeclaration font;
	private IconDeclaration icon;
}