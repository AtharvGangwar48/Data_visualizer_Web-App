
package com.example.datapreprocessor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "processed_data")
public class DataRecord {
    @Id
    private String id;
    private String filename;
    private List<Map<String, Object>> cleanedData;
    private LocalDateTime uploadedAt;

    // Getters and Setters
}
