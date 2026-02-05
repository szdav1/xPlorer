package lib.theming.appearance.configs;

import lib.theming.declarations.PaintDeclaration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class BackgroundConfiguration extends PaintConfiguration {
	public BackgroundConfiguration(final PaintDeclaration declaration) {
		super(declaration);
	}
}