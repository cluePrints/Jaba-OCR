package net.sourceforge.javaocr;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;

public enum TrainingCase {
	DIGITS(){
		@Override
		public List<TrainingImageSpec> images() {
			TrainingImageSpec newImage = new TrainingImageSpec();
			newImage.setFileLocation("ocrTests/trainingImages/digits.jpg");
			newImage.setCharRange(new CharacterRange((int) '0', (int) '9'));
			List<TrainingImageSpec> imgs = Arrays.asList(newImage);
			return imgs;
		}
	};
	
	public abstract List<TrainingImageSpec> images();
}
