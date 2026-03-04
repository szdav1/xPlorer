package xwt.components.xpanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JPanel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import theming.appearance.Appearance;
import xwt.components.XComponent;
import xwt.components.graphics.G2DPainter;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractXPanel extends JPanel implements XComponent {
	private final Appearance appearance;

	public AbstractXPanel(final Dimension preferredSize, final LayoutManager layout, final Appearance appearance) {
		this.appearance = appearance;

		this.overrideLookAndFeel(this, preferredSize);
		this.setLayout(layout);
		this.addMouseListener(this);
	}

	public AbstractXPanel(final Rectangle bounds, final LayoutManager layout, final Appearance appearance) {
		this.appearance = appearance;

		this.overrideLookAndFeel(this, bounds);
		this.setLayout(layout);
		this.addMouseListener(this);
	}

	public AbstractXPanel(final Dimension preferredSize, final Appearance appearance) {
		this(preferredSize, null, appearance);
	}

	public AbstractXPanel(final Rectangle bounds, final Appearance appearance) {
		this(bounds, null, appearance);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		super.paint(g);
		G2DPainter.paintComponent(this, g2D);
		g2D.dispose();
	}
}