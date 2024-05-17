package testFileElement;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.*;

public class TestFile {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }

    private ClassLoader cl = TestFile.class.getClassLoader();

    @Test
    void downloadTest() throws IOException {
        open("https://github.com/Poposant/SWAPI.postman_collection/blob/main/README.md");
        File download = $("a[href*='/Poposant/SWAPI.postman_collection/raw/main/README.md']").download();

        try (InputStream is = new FileInputStream(download)) {
            byte[] bytes = is.readAllBytes();
            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            Assertions.assertTrue(fileAsString.contains("SWAPI.postman_collection"));
        }
    }


    @Test
    void uploadTest() throws Exception {
        open("https://tus.io/demo");
        $("input[type='file']").uploadFromClasspath("img/Head.cj.jpg");
        $("._root_gq6c0_1").shouldHave(Condition.text("The upload is complete!"));
        }



    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='junit-user-guide-5.10.2.pdf']").download();
        PDF pdf = new PDF(download);
        Assertions.assertEquals(
                "Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",
                pdf.author);
    }

    @Test
    void xlsParseTest() throws Exception {
        open("https://itsm365.com/documents_rus/web/Content/import/import_org_file.htm");
        File download = $("a[href*='/Resources/doc/import_empl_xls.XLS']").download();
        XLS xls = new XLS(download);
        Assertions.assertTrue(
                xls.excel.getSheetAt(0).getRow(3).getCell(5).getStringCellValue()
                        .startsWith("Рекрутер"));
    }

    @Test
    void csvParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("football.csv");
             InputStreamReader isr = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(isr);
            List<String[]> content = csvReader.readAll();
            Assertions.assertArrayEquals(new String[]{"Зенит", "Россия"}, content.get(3));

        }
    }

    @Test
    void zipParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("48f0a121-977c-4b50-bf2d-7e25b6e8bc1b.png.zip");
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zs.getNextEntry()) != null) {
                Assertions.assertEquals("48f0a121-977c-4b50-bf2d-7e25b6e8bc1b.png", entry.getName());

            }
        }
    }
}



