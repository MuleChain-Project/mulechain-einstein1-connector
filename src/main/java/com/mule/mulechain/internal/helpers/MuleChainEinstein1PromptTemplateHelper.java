package com.mule.mulechain.internal.helpers;
import java.util.HashMap;
import java.util.Map;

public class MuleChainEinstein1PromptTemplateHelper {

    public static String definePromptTemplate(String template, String instruction, String dataSet){
        // Create the final template by concatenating strings with line separators
        String finalTemplate = template + System.lineSeparator() + 
                               "Instructions: " + "{{instructions}}" + System.lineSeparator() + 
                               "Dataset: " + "{{dataset}}";

        // Create a map for the variables
        Map<String, String> variables = new HashMap<>();
        variables.put("instructions", instruction);
        variables.put("dataset", dataSet);

        // Replace the placeholders with actual values
        String processedTemplate = processTemplate(finalTemplate, variables);
        return processedTemplate;

    }

    private static String processTemplate(String template, Map<String, String> variables) {
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return template;
    }

}
