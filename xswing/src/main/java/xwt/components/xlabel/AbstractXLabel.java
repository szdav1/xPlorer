package xwt.components.xlabel;


import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.appearance.Appearance;
import xwt.components.XComponent;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractXLabel extends JLabel implements XComponent {
	private final Appearance appearance;

	public AbstractXLabel(final Dimension preferredSize, final String text, final Appearance appearance) {
		this.appearance = appearance;

		this.overrideLookAndFeel(this, preferredSize);
		this.appearance.init(this.getWidth(), this.getWidth(), this.getHeight());
		this.setIcon(this.appearance.getIcon().getNormalIcon());
		this.setFont(this.appearance.getFont().getNormalFont());
		this.setText(text);
		this.addMouseListener(this);
	}

	public AbstractXLabel(final Dimension preferredSize, final Appearance appearance) {
		this(preferredSize, "", appearance);
	}

	public AbstractXLabel(final Rectangle bounds, final String text, final Appearance appearance) {
		this.appearance = appearance;

		this.overrideLookAndFeel(this, bounds);
		this.appearance.init(this.getWidth(), this.getWidth(), this.getHeight());
		this.setIcon(this.appearance.getIcon().getNormalIcon());
		this.setFont(this.appearance.getFont().getNormalFont());
		this.setText(text);
		this.addMouseListener(this);
	}

	public AbstractXLabel(final Rectangle bounds, final Appearance appearance) {
		this(bounds, "", appearance);
	}

	// TODO: Implement paint()
}