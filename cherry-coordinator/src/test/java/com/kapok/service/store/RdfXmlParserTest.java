package com.kapok.service.store;

import org.junit.jupiter.api.Test;

public class RdfXmlParserTest {

    @Test
    public void testParse() {
        String inputFileName = "University0_0.owl";
        RdfXmlParser rdfXmlParser = new RdfXmlParser();
        rdfXmlParser.parse(inputFileName);
    }

}
