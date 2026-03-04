package xwt.components.xpanel;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.appearance.Appearance;
import theming.appearance.consts.UIState;

@Data
@EqualsAndHashCode(callSuper = false)
public final class XPanel extends AbstractXPanel {

	public XPanel(Dimension preferredSize, LayoutManager layout, Appearance appearance) {
		super(preferredSize, layout, appearance);
	}

	public XPanel(Rectangle bounds, LayoutManager layout, Appearance appearance) {
		super(bounds, layout, appearance);
	}

	public XPanel(Dimension preferredSize, Appearance appearance) {
		super(preferredSize, appearance);
	}

	public XPanel(Rectangle bounds, Appearance appearance) {
		super(bounds, appearance);
	}

	@Override
	public Appearance getComponentAppearance() {
		return this.getAppearance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.getAppearance().setState(UIState.CLICKED);
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.getAppearance().setState(UIState.HOVERED);
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.getAppearance().setState(UIState.HOVERED);
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.getAppearance().setState(UIState.NORMAL);
		this.repaint();
	}

}