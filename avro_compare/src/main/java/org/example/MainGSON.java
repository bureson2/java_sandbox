package org.example;

import com.google.gson.Gson;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;

import java.io.File;
import java.io.IOException;

public class MainGSON {
    public static void main(String args[]) throws IOException {
        SpecificRecordBase record1 = deserializeAvroFile(new File("src/main/resources/example.avr"));
        SpecificRecordBase record2 = deserializeAvroFile(new File("src/main/resources/example_different_doc_text.avr"));

        Gson gson = new Gson();
        String json1 = gson.toJson(record1);
        String json2 = gson.toJson(record2);

        boolean areEqual = json1.equals(json2);

        System.out.println("Are AVRO files equal? " + areEqual);
    }

    private static SpecificRecordBase deserializeAvroFile(File avroFile) throws IOException {
        DatumReader<SpecificRecordBase> datumReader = new SpecificDatumReader<>();
        DataFileReader<SpecificRecordBase> dataFileReader = new DataFileReader<>(avroFile, datumReader);
        SpecificRecordBase record = null;

        if (dataFileReader.hasNext()) {
            record = dataFileReader.next(record);
        }

        dataFileReader.close();
        return record;
    }
}
