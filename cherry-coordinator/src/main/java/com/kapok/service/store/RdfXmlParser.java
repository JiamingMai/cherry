package com.kapok.service.store;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class RdfXmlParser {

    public Model parse(String inputFileName) {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();
        // use the FileManager to find the input file
        //InputStream in = FileManager.get().open(this.getClass().getClassLoader().getResource(inputFileName).getFile());
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }
        // read the RDF/XML file
        model.read(in, null);
        // write it to standard out
        model.write(System.out);
        return model;
    }

}
