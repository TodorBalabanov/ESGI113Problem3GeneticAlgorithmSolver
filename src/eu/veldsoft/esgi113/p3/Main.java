package eu.veldsoft.esgi113.p3;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;
		int X;
		int Y;
		Vector<Piece> pieces = new Vector<Piece>();

		if (in.hasNextInt() == false) {
			System.err.println("First number should be number of pieces.");
			return;
		}
		n = in.nextInt();

		if (in.hasNextInt() == false) {
			System.err.println("Second number should be width of the sheet.");
			return;
		}
		X = in.nextInt();

		if (in.hasNextInt() == false) {
			System.err.println("Third number should be width of the sheet.");
			return;
		}
		Y = in.nextInt();

		for (int i = 0, w, h; i < n; i++) {
			if (in.hasNextInt() == false) {
				System.err.println("Next number should be width of a piece.");
				return;
			}
			w = in.nextInt();
			if (in.hasNextInt() == false) {
				System.err.println("Next number should be width of a piece.");
				return;
			}
			h = in.nextInt();

			pieces.add(new Piece(Util.PRNG.nextInt(X - w), Util.PRNG.nextInt(Y
					- h), w, h));
		}

		GeneticAlgorithm ga = new GeneticAlgorithm(37, pieces);
		for (long g = 0L; g < 100L; g++) {
			ga.findBestAndWorst();
			ga.select();
			ga.crossover();
			ga.mutate();
			ga.bound(X, Y);
			ga.evaluate();
		}

		ga.findBestAndWorst();
		Util.saveSolution("" + (new Date()).getTime() + ".bmp", ga.getBest(),
				X, Y);

		in.close();
	}
}
