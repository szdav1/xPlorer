package lib.theming.appearance.configs;

import lib.theming.declarations.PaintDeclaration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class ForegroundConfiguration extends PaintConfiguration {
	public ForegroundConfiguration() {
		super();
	}

	public ForegroundConfiguration(final PaintDeclaration declaration) {
		super(declaration);
	}
}