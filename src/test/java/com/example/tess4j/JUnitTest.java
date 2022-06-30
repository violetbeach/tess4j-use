package com.example.tess4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JUnitTest {

    @Test
    public void test1() throws TesseractException {
        Tesseract tesseract = new Tesseract();
        File image = new File("images/hi.png");
        tesseract.setDatapath("/opt/homebrew/Cellar/tesseract/5.1.0/share/tessdata");
        tesseract.setLanguage("eng+kor");
        String s = tesseract.doOCR(image);
        System.out.println(s);
    }
}
