package com.prajwalmh.PharmaLens.controller;




import com.prajwalmh.PharmaLens.entity.Prescription;
import com.prajwalmh.PharmaLens.service.PrescriptionService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final PrescriptionService service;
    private final RestTemplate restTemplate;

    public PrescriptionController(PrescriptionService service) {
        this.service = service;
        this.restTemplate = new RestTemplate();
    }

    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        String text = prescription.getOriginalText();

        // 🔥 Call Python microservice
        String aiServiceUrl = "http://localhost:5000/analyze";
        Map<String, String> payload = new HashMap<>();
        payload.put("text", text);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    aiServiceUrl, HttpMethod.POST, requestEntity, Map.class);

            Map<String, Object> body = response.getBody();
            prescription.setAiSummary((String) body.get("summary"));

            List<String> warningsList = (List<String>) body.get("warnings");
            prescription.setWarnings(String.join(", ", warningsList));

        } catch (Exception e) {
            prescription.setAiSummary("Could not analyze text.");
            prescription.setWarnings("AI service unavailable.");
            e.printStackTrace();
        }

        return service.savePrescription(prescription);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return service.getAllPrescriptions();
    }
}
