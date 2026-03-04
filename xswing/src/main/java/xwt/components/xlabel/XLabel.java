package xwt.components.xlabel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.appearance.Appearance;

@Data
@EqualsAndHashCode(callSuper = false)
public final class XLabel extends AbstractXLabel {
	public XLabel(Dimension preferredSize, String text, Appearance appearance) {
		super(preferredSize, text, appearance);
	}

	public XLabel(Dimension preferredSize, Appearance appearance) {
		super(preferredSize, appearance);
	}

	public XLabel(Rectangle bounds, String text, Appearance appearance) {
		super(bounds, text, appearance);
	}

	public XLabel(Rectangle bounds, Appearance appearance) {
		super(bounds, appearance);
	}

	@Override
	public Appearance getComponentAppearance() {
		return this.getAppearance();
	}
	// Implement state change and repaint
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}