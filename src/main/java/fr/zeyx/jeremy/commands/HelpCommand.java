package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.nio.channels.Channel;

public class HelpCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Affiche l'aide et toutes les commandes disponibles.";
    }

    @Override
    public void execute(SlashCommandInteraction slashInteraction, Channel channel) {

    }
}
