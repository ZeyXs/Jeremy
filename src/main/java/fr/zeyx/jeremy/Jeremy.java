package fr.zeyx.jeremy;

import fr.zeyx.jeremy.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

@SuppressWarnings("ALL")
public class Jeremy {

    public final Dotenv config;
    public final ShardManager shardManager;

    public Jeremy() {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));

        shardManager = builder.build();

        shardManager.addEventListener(new EventListener());
    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        Jeremy jeremy = new Jeremy();
    }

}