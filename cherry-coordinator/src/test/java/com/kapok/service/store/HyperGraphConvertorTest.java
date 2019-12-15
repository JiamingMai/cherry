package com.kapok.service.store;

import org.apache.jena.rdf.model.Model;
import org.junit.jupiter.api.Test;

public class HyperGraphConvertorTest {

    @Test
    public void testConvert() {
        String inputFileName = "University0_0.owl";
        XmlParser xmlParser = new XmlParser();
        Model model = xmlParser.parse(inputFileName);
        HyperGraphConvertor hyperGraphConvertor = new HyperGraphConvertor();
        hyperGraphConvertor.convert(model);
    }

}
