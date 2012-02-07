package net.sourceforge.javaocr;

import java.io.File;

import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;

public enum TrainingCase {
	DIGITS("ocrTests/trainingImages/digits.jpg", '0', '9'),
	DIGITS_HANDWRITTEN("handwritingTests/TrainingImages/zeroToNine.jpg", '0','9');
	
	private final String path;
	private final char rangeStart;
	private final char rangeEnd;
	
	private TrainingCase(String path, char rangeStart, char rangeEnd) {
		this.path = path;
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
	}

	public TrainingImageSpec image() {
		TrainingImageSpec newImage = new TrainingImageSpec();
		newImage.setFileLocation(path);
		newImage.setCharRange(new CharacterRange((int) rangeStart, rangeEnd));
		return newImage;
	}
	
	public File imageFile() {
		return new File(path);
	}
}
