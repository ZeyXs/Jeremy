package fr.zeyx.jeremy;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Handler {

    public void handleMessage(MessageReceivedEvent event) {
        User author = event.getAuthor();
        TextChannel channel = (TextChannel) event.getChannel();
        Message message = event.getMessage();

        if (author.isBot() || message.getContentRaw().isBlank()) return;

        switch (channel.getId()) {
            case "" -> {
                handleSuggestions();
            }
            case "t" -> {
                System.out.println("case others");
            }
            default -> { }
        }
    }

    private void handleSuggestions() {

    }
}
