package net.sourceforge.javaocr.ocrPlugins;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import junit.framework.Assert;

import net.sourceforge.javaocr.TestCase;

import org.junit.Test;

public class CharacterExtractorITest {
	private AtomicInteger recognizedCharactersCounter = new AtomicInteger();
	
	@Test
	public void shouldProperlyDetectAllSingleCharacters() {		
		CharacterExtractor unit = initPartiallyMockedExtractor();
		
		TestCase testCase = TestCase.SHUFFLED_DIGITS;
		unit.slice(new File(testCase.imgFilePath()), null, 75, 75);
		
		int expectedSize = testCase.contents().length();
		Assert.assertEquals(expectedSize, recognizedCharactersCounter.intValue());
	}
	
	private CharacterExtractor initPartiallyMockedExtractor() {
		CharacterExtractor unit = new CharacterExtractor(){
			@Override
			protected void handleNormalizedSingleCharacterImage(
					BufferedImage normalizedImage) throws IOException {
				recognizedCharactersCounter.incrementAndGet();
			}
		};
		return unit;
	}
}
