package lib.theming.selector;

import lib.theming.declarations.BorderDeclaration;
import lib.theming.declarations.FontDeclaration;
import lib.theming.declarations.IconDeclaration;
import lib.theming.declarations.PaintDeclaration;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Selector {
	private final PaintDeclaration background;
	private final PaintDeclaration foreground;
	private final BorderDeclaration border;
	private final FontDeclaration font;
	private final IconDeclaration icon;
}