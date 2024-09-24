package com.ai.RecipeCreator.services;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {

        return chatModel.call(prompt);

    }

    /* Not using right now, but it is helpful for multiple response generating */
    public String getResponseOptions(String prompt) {
        // Create OpenAiChatOptions with the correct temperature type
        OpenAiChatOptions options = OpenAiChatOptions.builder()
                .withModel("gpt-4o")
                .withTemperature(0.4f) // Use float instead of double
                .build();

        // Create a Prompt object
        Prompt promptObj = new Prompt(prompt, options);

        // Call the chat model and get the response
        /* Due to insufficient quota, for now we can't get response freely */

        ChatResponse chatResponse = chatModel.call(promptObj);

        // Extract the text from ChatResponse

        return chatResponse.getResult().getOutput().getContent();
    }
}
