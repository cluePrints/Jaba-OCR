package net.sourceforge.javaocr;

public enum TestCase {
	DIGITS("ocrTests/trainingImages/digits.jpg", "0123456789"),
	SHUFFLED_DIGITS("ocrTests/shuffledDigits.jpg", "5017834269");
	
	private final String imgFile;
	private final String contents;
	private TestCase(String imgFile, String contents) {
		this.imgFile = imgFile;
		this.contents = contents;
	}
	
	public String imgFilePath() {
		return imgFile;
	}
	
	public String contents() {
		return contents;
	}
}
