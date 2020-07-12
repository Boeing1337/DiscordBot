package dungeon;

import dungeon.main.BotInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaranApplication {

    private static BotInit botInit;

    VaranApplication(@Autowired BotInit botInit) {
        VaranApplication.botInit = botInit;
    }

    public static void main(String[] args) {

        SpringApplication.run(VaranApplication.class, args);
        botInit.botInit();
    }

}
