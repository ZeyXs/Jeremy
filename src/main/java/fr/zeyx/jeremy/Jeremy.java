package fr.zeyx.jeremy;

import fr.zeyx.jeremy.listeners.EventListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

@SuppressWarnings("ALL")
public class Jeremy {

    public Jeremy() {
        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("ur mom"));
        builder.addEventListeners(new EventListener());
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES);
        builder.build();
    }

    public static void main(String[] args) {
        Jeremy jeremy = new Jeremy();
    }

}