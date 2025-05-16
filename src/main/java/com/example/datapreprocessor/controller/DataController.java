package com.example.datapreprocessor.controller;

import com.example.datapreprocessor.dto.ChartRequest;
import com.example.datapreprocessor.service.DataPreprocessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataPreprocessingService preprocessingService;

    @Autowired
    public DataController(DataPreprocessingService preprocessingService) {
        this.preprocessingService = preprocessingService;
    }

    /**
     * Uploads a CSV file for processing.
     *
     * @param file the CSV file to upload
     * @return ResponseEntity with the result of the upload
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        return preprocessingService.handleUpload(file);
    }

    /**
     * Preprocesses the uploaded file based on the provided file ID and options.
     *
     * @param fileId the ID of the file to preprocess
     * @param options additional options for preprocessing
     * @return ResponseEntity with the result of the preprocessing
     */
    @PostMapping("/preprocess")
    public ResponseEntity<String> preprocess(@RequestParam("fileId") String fileId,
                                             @RequestParam Map<String, String> options) {
        return preprocessingService.preprocess(fileId, options);
    }

    /**
     * Generates visualization data based on the provided chart request.
     *
     * @param request the chart request containing visualization parameters
     * @return ResponseEntity with the generated chart data
     */
    @PostMapping("/visualize")
    public ResponseEntity<String> getVisualization(@RequestBody ChartRequest request) {
        return preprocessingService.generateChartData(request);
    }
}
