
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {

	public static void main(String[] args) {

		Map<String, Integer> symptomCounts = new TreeMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {

			String line = reader.readLine();

			while (line != null) {
				symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1
				);

				line = reader.readLine();
			}

		} catch (IOException e) {
			System.err.println("Error reading  results: " + e.getMessage());
			return;
		}


        try(FileWriter writer = new FileWriter("result.out")) {

		for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
			writer.write(
					entry.getKey() + ": " + entry.getValue() + "\n"
			);
		}
	} catch (IOException e) {
			System.err.println("Error writing results: " + e.getMessage());
	}


	}
}