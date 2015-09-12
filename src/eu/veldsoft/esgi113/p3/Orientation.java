package eu.veldsoft.esgi113.p3;

enum Orientation {
	LANDSCAPE, PORTRAIT;

	public Orientation opposite() {
		if(this == LANDSCAPE) {
			return PORTRAIT;
		} else if(this == PORTRAIT) {
			return LANDSCAPE;
		}
		
		return null;
	}
}
