package net.sourceforge.javaocr.gui;

import java.util.List;

import net.sourceforge.javaocr.TestCase;
import net.sourceforge.javaocr.TrainingCase;
import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec;

import org.junit.Assert;
import org.junit.Test;

public class GuiControllerITest {
	private GUIController unit = new GUIController();
	
	@Test
	public void shouldPerformMeanSqaureOCROnDigits() throws Exception {		
		List<TrainingImageSpec> imgs = TrainingCase.DIGITS.images();
		
		TestCase testCase = TestCase.SHUFFLED_DIGITS;
		String result = unit.performMSEOCR(imgs, testCase.imgFilePath());
		Assert.assertEquals(testCase.contents(), result);
	}
}
