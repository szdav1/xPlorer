package xwt.components;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import theming.appearance.Appearance;

public interface XComponent extends MouseListener {
	Appearance getComponentAppearance();

	default void overrideLookAndFeel(final JComponent component, final Dimension preferredSize) {
		component.setPreferredSize(preferredSize);
		component.setBounds(new Rectangle(0, 0, preferredSize.width, preferredSize.height));
		component.setOpaque(true);
		component.setFocusable(false);
		component.setBackground(null);
		component.setBorder(null);
	}

	default void overrideLookAndFeel(final JComponent component, final Rectangle bounds) {
		component.setBounds(bounds);
		component.setPreferredSize(new Dimension(bounds.width, bounds.height));
		component.setOpaque(true);
		component.setFocusable(false);
		component.setBackground(null);
		component.setBorder(null);
	}
}