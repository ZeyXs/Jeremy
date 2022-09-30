package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equalsIgnoreCase("coucou")) {
            String userTag = event.getUser().getAsTag();
            event.reply("Coucou, **" + userTag + "** !").queue();
             new HelpCommand().execute(event.getInteraction(), event.getChannel(), );
        }
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        updateCommandData(event);
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        updateCommandData(event);
    }

    private <T extends GenericGuildEvent> void updateCommandData(T event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("coucou", "J'aime bien dire coucou :)"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}
