package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.nio.channels.Channel;

public abstract class AbstractCommand {

    public String getName() {
        return null;
    }

    public String getDescription() {
        return "No descriptions.";
    }

    public boolean isDisabled() {
        return false;
    }

    public boolean isListed() {
        return true;
    }

    public abstract void execute(SlashCommandInteraction slashInteraction, Channel channel, );
}
