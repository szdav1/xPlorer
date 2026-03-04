package xwt.components.graphics;

import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import theming.appearance.Appearance;
import xwt.components.XComponent;

@AllArgsConstructor(access = AccessLevel.NONE)
public final class G2DPainter {
	private static <TComponent extends JComponent & XComponent> LinearGradientPaint determineBackgroundPaint(final TComponent tcomponent, final Appearance appearance, final Rectangle clipBounds) {
		if (!tcomponent.isEnabled()) {
			return new LinearGradientPaint(
				switch (tcomponent.getComponentAppearance().getBackground().getDirection()) {
					case RIGHT_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.height);
					case TOP_TO_BOTTOM -> new Point2D.Double(clipBounds.width, clipBounds.y);
					case BOTTOM_TO_TOP -> new Point2D.Double(clipBounds.x, clipBounds.height);

					case DIAGONAL_TOP_TO_RIGHT -> new Point2D.Double(clipBounds.x, clipBounds.y);
					case DIAGONAL_TOP_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.y);
					case DIAGONAL_BOTTOM_TO_RIGHT -> new Point2D.Double(clipBounds.x, clipBounds.height);
					case DIAGONAL_BOTTOM_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.height);

					default -> new Point2D.Double(clipBounds.x, clipBounds.height);
				},

				switch (tcomponent.getComponentAppearance().getBackground().getDirection()) {
					case RIGHT_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.height);
					case TOP_TO_BOTTOM -> new Point2D.Double(clipBounds.width, clipBounds.height);
					case BOTTOM_TO_TOP -> new Point2D.Double(clipBounds.x, clipBounds.y);

					case DIAGONAL_TOP_TO_RIGHT -> new Point2D.Double(clipBounds.width, clipBounds.height);
					case DIAGONAL_TOP_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.height);
					case DIAGONAL_BOTTOM_TO_RIGHT -> new Point2D.Double(clipBounds.width, clipBounds.y);
					case DIAGONAL_BOTTOM_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.y);

					default -> new Point2D.Double(clipBounds.width, clipBounds.height);
				},

				tcomponent.getComponentAppearance()
					.getBackground()
					.getNormalConfig()
					.getFractions(),

				tcomponent.getComponentAppearance()
				.getBackground()
				.getNormalConfig()
				.getColors()
			);
		}

		return new LinearGradientPaint(
			switch (tcomponent.getComponentAppearance().getBackground().getDirection()) {
				case RIGHT_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.height);
				case TOP_TO_BOTTOM -> new Point2D.Double(clipBounds.width, clipBounds.y);
				case BOTTOM_TO_TOP -> new Point2D.Double(clipBounds.x, clipBounds.height);

				case DIAGONAL_TOP_TO_RIGHT -> new Point2D.Double(clipBounds.x, clipBounds.y);
				case DIAGONAL_TOP_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.y);
				case DIAGONAL_BOTTOM_TO_RIGHT -> new Point2D.Double(clipBounds.x, clipBounds.height);
				case DIAGONAL_BOTTOM_TO_LEFT -> new Point2D.Double(clipBounds.width, clipBounds.height);

				default -> new Point2D.Double(clipBounds.x, clipBounds.height);
			},

			switch (tcomponent.getComponentAppearance().getBackground().getDirection()) {
				case RIGHT_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.height);
				case TOP_TO_BOTTOM -> new Point2D.Double(clipBounds.width, clipBounds.height);
				case BOTTOM_TO_TOP -> new Point2D.Double(clipBounds.x, clipBounds.y);

				case DIAGONAL_TOP_TO_RIGHT -> new Point2D.Double(clipBounds.width, clipBounds.height);
				case DIAGONAL_TOP_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.height);
				case DIAGONAL_BOTTOM_TO_RIGHT -> new Point2D.Double(clipBounds.width, clipBounds.y);
				case DIAGONAL_BOTTOM_TO_LEFT -> new Point2D.Double(clipBounds.x, clipBounds.y);

				default -> new Point2D.Double(clipBounds.width, clipBounds.height);
			},

			switch (tcomponent.getComponentAppearance().getState()) {
				case HOVERED -> tcomponent.getComponentAppearance()
					.getBackground()
					.getHoveredConfig()
					.getFractions();

				case CLICKED -> tcomponent.getComponentAppearance()
					.getBackground()
					.getClickedConfig()
					.getFractions(); 

				default -> tcomponent.getComponentAppearance()
					.getBackground()
					.getNormalConfig()
					.getFractions();
			},

			switch (tcomponent.getComponentAppearance().getState()) {
				case HOVERED -> tcomponent.getComponentAppearance()
					.getBackground()
					.getHoveredConfig()
					.getColors();

				case CLICKED -> tcomponent.getComponentAppearance()
					.getBackground()
					.getClickedConfig()
					.getColors();

				default -> tcomponent.getComponentAppearance()
					.getBackground()
					.getNormalConfig()
					.getColors();
			}
		);
	}

	private static <TComponent extends JComponent & XComponent> void paintBackground(final TComponent tcomponent, final Graphics2D g2D, final Rectangle clipBounds) {
		g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2D.setPaint(determineBackgroundPaint(tcomponent, tcomponent.getComponentAppearance(), clipBounds));

		g2D.fillRoundRect(
			clipBounds.x,
			clipBounds.y,
			clipBounds.width,
			clipBounds.height, 

			tcomponent.getComponentAppearance()
				.getBorder()
				.getRadius(),

			tcomponent.getComponentAppearance()
				.getBorder()
				.getRadius()
		);
	}

	public static <TComponent extends JComponent & XComponent> void paintComponent(final TComponent tcomponent, final Graphics2D g2D) {
		Rectangle clipBounds = g2D.getClipBounds();
		paintBackground(tcomponent, g2D, clipBounds);
	}
}