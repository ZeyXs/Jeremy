package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.nio.channels.Channel;
import java.util.List;

public abstract class AbstractCommand {

    public abstract void handle(SlashCommandInteractionEvent event);

    public String getName() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public boolean isDisabled() {
        return false;
    }

    public boolean isListed() {
        return true;
    }

}
