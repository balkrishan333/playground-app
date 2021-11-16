package com.nagpal.bala.playgroundapp.json.validation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ValidateJSON {

    private static final String JSON_SCHEMA_FILE = "C:\\Users\\bnagpal1\\codebase\\other-impl\\playground-app\\src\\main\\resources\\jsonValidationSchema.json";
    private static final Logger logger = LoggerFactory.getLogger(ValidateJSON.class);

    public static void main(String[] args) {

        logger.info("Starting json validator...");
        try {
            File file = new File(JSON_SCHEMA_FILE);
            logger.debug("Schema location : " + file.getAbsolutePath());

            JsonSchema jsonSchema = JsonSchemaFactory.byDefault().getJsonSchema(file.toURI().toString());
            JsonNode jsonNode;
            InputStream inputStream;

            try {
                inputStream = new FileInputStream(new File("C:\\Users\\bnagpal1\\codebase\\other-impl\\playground-app\\src\\main\\resources\\JsonData.json"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                jsonNode = new ObjectMapper().readTree(inputStream);
            } catch (IOException e) {
                logger.error("Error parsing json data", e);
                throw new RuntimeException(e);
            }
            logger.debug("json content : " + jsonNode);

            ProcessingReport report = jsonSchema.validate(jsonNode);
            logger.info("Report : " + report);
        } catch (ProcessingException e) {
            logger.error("error processing ", e);
        }
    }
}
