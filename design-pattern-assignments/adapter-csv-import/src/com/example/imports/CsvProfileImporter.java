package com.example.imports;

import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
        public int importFrom(Path csvFile) {
            int count = 0;
            for (String[] tokens : csvReader.read(csvFile)) {
                if (tokens.length != 3) {
                    System.out.println("Skipping row: wrong number of columns");
                continue;
            }

            String id = tokens[0].trim();
            String email = tokens[1].trim();
            String displayName = tokens[2].trim();

            // validating
            if (id.isEmpty()) {
                System.out.println("Skipping row: missing id");
                continue;
            }
            if (email.isEmpty()) {
                System.out.println("Skipping row: missing email");
                continue;
            }
            if (!email.contains("@")) {
                System.out.println("Skipping row: invalid email -> " + email);
                continue;
            }

            try {
                profileService.createProfile(id, email, displayName);
                count++;
            } catch (Exception e) {
                System.out.println("Skipping row: error creating profile -> " + e.getMessage());
            }
        }
        return count;
    }

}
