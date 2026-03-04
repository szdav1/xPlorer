package theming.selector;

import lombok.AllArgsConstructor;
import lombok.Data;
import theming.declarations.BorderDeclaration;
import theming.declarations.FontDeclaration;
import theming.declarations.IconDeclaration;
import theming.declarations.PaintDeclaration;

@Data
@AllArgsConstructor
public final class Selector {
	private final PaintDeclaration background;
	private final PaintDeclaration foreground;
	private final BorderDeclaration border;
	private final FontDeclaration font;
	private final IconDeclaration icon;
}