import org.junit.Test;
import pl.escience.zdpp.lab03gr1.database.entity.WishTemplate;
import pl.escience.zdpp.lab03gr1.xml_parser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class XmlWishTemplateParserTest {
    @Test
    public void readTextOfWishTemplateFromFile() throws JAXBException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader
                .getResource("sample_wish_template_file.xml")).getFile());

        String xmlPath = file.toString();
        WishTemplate wishTemplate = new Parser().readFromXMLFile(xmlPath);

        assertEquals("Zdrowia, szczęścia i słodyczy.", wishTemplate.getText());
    }

    @Test(expected = JAXBException.class)
    public void readWishTemplateFromBrokenFile() throws JAXBException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader
                .getResource("sample_wish_template_broken_file.xml")).getFile());

        String xmlPath = file.toString();
        WishTemplate wishTemplate = new Parser().readFromXMLFile(xmlPath);
    }
}
