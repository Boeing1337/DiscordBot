package dungeon.main;

import dungeon.main.Listeners.core.MessageListener;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:settings.properties")
public class BotInit {

    private MessageListener messageListener;

    @Value("${token}")
    private String token;

    public BotInit(@Autowired MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @SneakyThrows
    public void botInit() {
        JDABuilder jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.addEventListeners(messageListener);
        jdaBuilder.build();

    }

}
