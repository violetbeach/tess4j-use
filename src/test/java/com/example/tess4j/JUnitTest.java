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

    @Test
    public void test2() throws TesseractException {
        run("images/hiworks.png");
    }

    @Test
    public void test3() throws TesseractException {
        run("images/ocrtesttext.png");
    }

    @Test
    public void test4() throws TesseractException {
        run("images/wheel.bmp");
    }

    @Test
    public void test5() throws TesseractException {
        run("images/편지쓰기.png");
    }

    @Test
    public void test6() throws TesseractException {
        run("images/confluence.png");
    }

    @Test
    public void test7() throws TesseractException {
        run("images/발송실패.png");
    }

    @Test
    public void test8() throws TesseractException {
        run("images/부정로그인.png");
    }

    @Test
    public void test9() throws TesseractException {
        run("images/kbs.png");
    }

    private void run(String path) throws TesseractException {
        File image = new File(path);
        long beforeTime = System.currentTimeMillis();

        String s = tesseract.doOCR(image);

        long afterTime = System.currentTimeMillis();
        long performanceTime = (afterTime - beforeTime);

        System.out.println("결과 = ");
        System.out.println(s);
        System.out.println("파일 크기 = " + image.length() / 1024 + "kb");
        System.out.println("수행 시간 = " + performanceTime + "ms");
    }

}
