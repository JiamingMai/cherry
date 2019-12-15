package com.kapok.service.store;

import org.junit.jupiter.api.Test;

public class XmlParserTest {

    @Test
    public void testParse() {
        String inputFileName = "University0_0.owl";
        XmlParser xmlParser = new XmlParser();
        xmlParser.parse(inputFileName);
    }

}
