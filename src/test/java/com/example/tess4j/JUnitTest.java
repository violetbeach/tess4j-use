package com.example.tess4j;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class JUnitTest {

    static Tesseract tesseract = new Tesseract();

    @BeforeAll
    static void setup() {
        tesseract.setDatapath("/opt/homebrew/Cellar/tesseract/5.1.0/share/tessdata");
        tesseract.setLanguage("eng+kor");
    }

    @Test
    public void test1() throws TesseractException {
        run("images/hi.png");
    }

    private void run(String path) throws TesseractException {
        File image = new File(path);
        long beforeTime = System.currentTimeMillis();

        String s = tesseract.doOCR(image);

        long afterTime = System.currentTimeMillis();
        long performanceTime = (afterTime - beforeTime);

        System.out.println("결과 = " + s);
        System.out.println("수행 시간 = " + performanceTime + "ms");
    }

}
