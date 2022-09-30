package fr.zeyx.jeremy.listeners;

import fr.zeyx.jeremy.Handler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    Handler handler = new Handler();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        handler.handleMessage(event);
    }
}
