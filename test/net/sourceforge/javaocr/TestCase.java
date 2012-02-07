package net.sourceforge.javaocr;

import java.io.File;

public enum TestCase {
	DIGITS("ocrTests/trainingImages/digits.jpg", "0123456789"),
	SHUFFLED_DIGITS("ocrTests/shuffledDigits.jpg", "5017834269"),
	DIGITS_HW("handwritingTests/zeroToNineTarget.jpg", 
			"04 7  10  32  09   27  23 3    524\n" +
			"1  8  8  1\n"+
			"\n" +
			"106   750   555\n" +
			"9096757\n"+
			"76639779  1\n"+
			"47 63332");
	
	private final String imgFile;
	private final String contents;
	private TestCase(String imgFile, String contents) {
		this.imgFile = imgFile;
		this.contents = contents;
	}
	
	public String imgFilePath() {
		return imgFile;
	}
	
	public File imgFile() {
		return new File(imgFile);
	}
	
	public String contents() {
		return contents;
	}
}
