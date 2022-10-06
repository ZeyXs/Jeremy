package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class HelpCommand extends AbstractCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Send the help page";
    }

    @Override
    public void handle(SlashCommandInteractionEvent event) {
        event.reply("Coucou **" + event.getUser().getAsTag() + "** !").queue();
    }

}
