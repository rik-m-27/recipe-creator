package com.ai.RecipeCreator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.RecipeCreator.services.ChatService;
import com.ai.RecipeCreator.services.RecipeService;

@RestController
public class GenAIController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }

    /* Not using for now, it's a way to generate multiple response */
    @GetMapping("/ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt) {
        return chatService.getResponseOptions(prompt);
    }

    @GetMapping("/recipe-creator")
    public String getRecipe(@RequestParam String ingredients,
            @RequestParam(defaultValue = "any") String cuisine,
            @RequestParam(defaultValue = "none") String dietaryRestriction) {

        System.out.println(ingredients + " " + cuisine + " " + dietaryRestriction);
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
        // return "drink water time to time. that's it !!";
    }

}
