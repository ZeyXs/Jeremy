package fr.zeyx.jeremy;

import fr.zeyx.jeremy.commands.CommandManager;
import fr.zeyx.jeremy.commands.HelpCommand;
import fr.zeyx.jeremy.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import java.util.logging.Logger;

@SuppressWarnings("ALL")
public class Jeremy {

    public final Dotenv config;
    public final ShardManager shardManager;
    public final CommandManager commandManager = new CommandManager();

    public Jeremy() {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));

        shardManager = builder.build();

        shardManager.addEventListener(new EventListener());
        shardManager.addEventListener(commandManager);

        commandManager.addCommand(new HelpCommand());
    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public static void main(String[] args) {
        Jeremy jeremy = new Jeremy();
    }

}