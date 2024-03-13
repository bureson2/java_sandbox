package org.example;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Field;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainAvro {
    public static void main(String args[]) throws IOException {
        Schema schema1 = new Schema.Parser().parse(new File("src/main/resources/{FILE}"));
        Schema schema2 = new Schema.Parser().parse(new File("src/main/resources/{FILE}"));

        Schema normalizedSchema1 = normalizeSchema(schema1);
        Schema normalizedSchema2 = normalizeSchema(schema2);

        boolean areSchemasEqual = normalizedSchema1.equals(normalizedSchema2);

        System.out.println("Schemas are " + (areSchemasEqual ? "same" : "different"));
        System.out.println(normalizedSchema1.toString());

    }

    private static Schema normalizeSchema(Schema schema) {
        return sortFields(schema);
    }

    private static Schema sortFields(Schema schema) {
        switch (schema.getType()) {
            case RECORD:
                List<Field> sortedFields = new ArrayList<>();
                for (Field field : schema.getFields()) {
                    Schema fieldSchema = sortFields(field.schema());
                    Field newField = new Field(field.name(), fieldSchema, field.doc(), field.defaultVal());
                    for (Map.Entry<String, Object> entry : field.getObjectProps().entrySet()) {
                        newField.addProp(entry.getKey(), entry.getValue());
                    }
                    sortedFields.add(newField);
                }
                Collections.sort(sortedFields, Comparator.comparing(Field::name));
                Schema newRecordSchema = Schema.createRecord(schema.getName(), schema.getDoc(), schema.getNamespace(), schema.isError());
                for (Map.Entry<String, Object> entry : schema.getObjectProps().entrySet()) {
                    newRecordSchema.addProp(entry.getKey(), entry.getValue());
                }
                newRecordSchema.setFields(sortedFields);
                return newRecordSchema;
            default:
                return schema;
        }
    }
}
