package com.example.uniquenumberchallenge.controller;

import com.example.uniquenumberchallenge.model.NumberListToJsonModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

@RestController
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @Value("${spring.application.target}")
    Integer target;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/generate-unique-number")
    public ResponseEntity<Object> generateUniqueNumber(@RequestParam @Min(2) @Max(value = 3, message = "value should be integer 2 or 3 where 2 means sum of 2 numbers and 3 sum of 3 numbers") Integer parts) throws IOException {
        Integer result;
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> numbers = getJsonPayload();
        FindSum findSum = new FindSum();
        switch (parts) {
            case 2:
                result = findSum.findSumOfTwo(numbers, target);
                map.put("uniqueNumber", result);
                break;
            case 3:
                result = findSum.findSumOfThree(numbers, target);
                map.put("uniqueNumber", result);
                break;
            default:
                map.put("Please provide 2 or 3 as an input. Not an option", parts);
        }
        return ResponseEntity.ok(map);
    }

    private List<Integer> getJsonPayload() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream resource = new ClassPathResource(
                "mer_unc_input.json").getInputStream();
        try (BufferedReader ignored = new BufferedReader(
                new InputStreamReader(resource))) {
            NumberListToJsonModel numberListToJsonModel = objectMapper.readValue(resource, NumberListToJsonModel.class);
            return numberListToJsonModel.getInputNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}