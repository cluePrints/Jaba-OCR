package net.sourceforge.javaocr.gui;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.javaocr.TestCase;
import net.sourceforge.javaocr.TrainingCase;
import net.sourceforge.javaocr.gui.handwritingRecognizer.HandWritingFormProcessor;
import net.sourceforge.javaocr.gui.meanSquareOCR.TrainingImageSpec;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class GuiControllerITest {
	private GUIController unit = new GUIController();
	
	@Test
	public void shouldPerformMeanSqaureOCROnDigits() throws Exception {		
		List<TrainingImageSpec> imgs = Arrays.asList(TrainingCase.DIGITS.image());
		
		TestCase testCase = TestCase.SHUFFLED_DIGITS;
		String result = unit.performMSEOCR(imgs, testCase.imgFilePath());
		Assert.assertEquals(testCase.contents(), normalize(result));
	}
	
	@Test
	public void shouldPerformHWRecognitionOfNumbersViaMSMethod() throws Exception {
		File training = TrainingCase.DIGITS_HANDWRITTEN.imageFile();
		TestCase testCase = TestCase.DIGITS_HW;
		HandWritingFormProcessor form = configMeanSquareForDigitsOnlyOCR();
		
		String result = unit.processHandwriting(training, testCase.imgFile(), form);
		
		Assert.assertEquals(testCase.contents(), normalize(result));
	}

	private String normalize(String result) {
		return result
				.replaceAll("\n\\s*\n", "\n\n") // empty lines don't need spaces
				.replaceAll("\\s+\n$", "")		// spaces in the end of lines are not good too
				;
	}

	private HandWritingFormProcessor configMeanSquareForDigitsOnlyOCR() {
		HandWritingFormProcessor form = new HandWritingFormProcessor(null) {
			public boolean isLearnLowerAtoZ() {
				return false;
			};
			
			public boolean isLearnZeroToNine() {
				return true;
			};
			
			public boolean isLearnUpperAtoZ() {
				return false;
			};
			
			@Override
			public boolean isMSEOCR() {
				return true;
			}
			
			@Override
			public boolean isAspectOCR() {
				return false;
			}
		};
		return form;
	}
}
