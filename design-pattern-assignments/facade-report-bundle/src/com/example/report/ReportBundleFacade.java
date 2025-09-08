package com.example.report;
import java.util.Objects;
import java.nio.file.*;
import java.util.*;
import java.io.*;


public class ReportBundleFacade {
    private JsonWriter writer = new JsonWriter(); 
    private Zipper zipper = new Zipper(); 
    private AuditLog log = new AuditLog();

    public Path export(Map<String,Object> data, Path outDir, String baseName){
        Objects.requireNonNull(data);
        Objects.requireNonNull(outDir);
        Objects.requireNonNull(baseName);

        // Step 1: Write JSON
        Path json = writer.write(data, outDir, baseName);

        // Step 2: Zip JSON into baseName.zip
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));

        // Step 3: Log
        log.log("exported " + zip);

        return zip;

    }


    
}
