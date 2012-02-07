package net.sourceforge.javaocr.gui;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec;
import net.sourceforge.javaocr.ocrPlugins.mseOCR.CharacterRange;

import org.junit.Assert;
import org.junit.Test;

public class GuiControllerITest {
	private static final String TEST_IMG = "/home/user/workspace/jaba-ocr/ocrTests/shuffledDigits.jpg";
	private static final String IMG_0_THROUGH_9 = "/home/user/workspace/jaba-ocr/ocrTests/trainingImages/digits.jpg";

	@Test
	public void shouldPerformMeanSqaureOCR() throws Exception {
		GUIController unit = new GUIController();
		TrainingImageSpec newImage = new TrainingImageSpec();
		newImage.setFileLocation(IMG_0_THROUGH_9);
		newImage.setCharRange(new CharacterRange((int) '0', (int) '9'));

		List<TrainingImageSpec> imgs = Arrays.asList(newImage);
		String result = unit.performMSEOCR(imgs, TEST_IMG);
		Assert.assertEquals("5017834269", result);
	}
}
