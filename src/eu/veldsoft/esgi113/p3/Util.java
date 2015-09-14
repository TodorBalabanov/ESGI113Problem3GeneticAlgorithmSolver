package eu.veldsoft.esgi113.p3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;

class Util {

	static final Random PRNG = new Random();

	static void saveSolution(String fileName, Vector<Piece> pieces, int width,
			int height) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);

		for (Piece piece : pieces) {
			g.setColor(Color.yellow);
			g.fillRect(piece.getX(), piece.getY(), piece.getWidth(),
					piece.getHeight());

			g.setColor(Color.black);
			g.drawRect(piece.getX(), piece.getY(), piece.getWidth(),
					piece.getHeight());
		}

		try {
			ImageIO.write(image, "BMP", new File(fileName));
		} catch (IOException e) {
		}

		g.dispose();
	}

}
