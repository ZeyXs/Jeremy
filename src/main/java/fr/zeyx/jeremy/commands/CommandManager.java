package fr.zeyx.jeremy.commands;

import net.dv8tion.jda.api.events.guild.GenericGuildEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private final List<AbstractCommand> commands = new ArrayList<>();

    public <T extends AbstractCommand> void addCommand(T command) {
        boolean isCommand = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(command.getName()));

        if (isCommand) {
            throw new IllegalArgumentException("A command with the same name already exists.");
        }

        commands.add(command);
    }

    @Nullable
    public AbstractCommand getCommand(String name) {
        for (AbstractCommand command : this.commands) {
            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return null;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for (AbstractCommand command : commands) {
            if (command.getName().equalsIgnoreCase(event.getName())) {
                command.handle(event);
            }
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
        for (AbstractCommand cmd : commands) {
            commandData.add(Commands.slash(cmd.getName(), cmd.getDescription()));
        }
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
