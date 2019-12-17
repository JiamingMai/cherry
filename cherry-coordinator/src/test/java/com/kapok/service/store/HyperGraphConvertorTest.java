package com.kapok.service.store;

import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Test;

public class HyperGraphConvertorTest {

    @Test
    public void testConvert() {
        String inputFileName = "University0_0.owl";
        RdfXmlParser rdfXmlParser = new RdfXmlParser();
        Model model = rdfXmlParser.parse(inputFileName);
        HyperGraphConvertor hyperGraphConvertor = new HyperGraphConvertor();
        hyperGraphConvertor.convert(model);
    }

}
