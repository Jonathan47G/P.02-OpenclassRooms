
package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.service.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.service.counter.SymptomCounter;
import com.hemebiotech.analytics.service.writer.IWriterSymptoms;
import com.hemebiotech.analytics.service.writer.WriteSymptoms;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SymptomAnalytics {

    /**
     * Runs the symptom analysis process.
     */
    public void run() {

        try {
            ReadSymptomDataFromFile reader =
                    new ReadSymptomDataFromFile("symptoms.txt");

            SymptomCounter counter = new SymptomCounter();

            IWriterSymptoms writer =
                    new WriteSymptoms("result.out");

            List<String> symptoms = reader.getSymptoms();

            Map<String, Integer> symptomCounts =
                    counter.countSymptoms(symptoms);

            writer.writeSymptoms(symptomCounts);

        } catch (IOException e) {
            System.err.println(
                    "Error processing symptoms: " + e.getMessage()
            );
        }
    }
}