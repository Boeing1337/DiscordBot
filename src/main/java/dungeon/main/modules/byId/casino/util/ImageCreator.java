package dungeon.main.modules.byId.casino.util;


import dungeon.main.modules.byId.casino.dll.cards.interfaces.Card;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@Component
public class ImageCreator {
    private final int IMG_X_POS_FIRST;
    private final int IMG_X_POS_SECOND;
    private final int IMG_X_POS_THIRST;
    private final int IMG_X_POS_FOUR;
    private final int BIG_BORDER = 10;
    private final int CENTRAL_BORDER = 50;
    private final int SMALL_BORDER = 5;
    private final String SUF = ".png";
    private final String PREF = "file:";
    private final String PNG = "png";

    private final String MAIN_PATH;

    {
        int imgWeight = 270;
        MAIN_PATH = Objects.requireNonNull(ImageCreator.class.getClassLoader().getResource("images/")).getPath();
        IMG_X_POS_FIRST = BIG_BORDER;
        IMG_X_POS_SECOND = IMG_X_POS_FIRST + imgWeight + CENTRAL_BORDER;
        IMG_X_POS_THIRST = IMG_X_POS_SECOND + imgWeight + CENTRAL_BORDER;
        IMG_X_POS_FOUR = IMG_X_POS_THIRST + imgWeight + CENTRAL_BORDER;
    }

    public File createSpinImage(final List<Card> cardList) {

        try {
            final BufferedImage img1 =
            ImageIO.read(new URL(PREF + MAIN_PATH + cardList.get(0).getName() + SUF));

            final BufferedImage img2 =
            ImageIO.read(new URL(PREF + MAIN_PATH + cardList.get(1).getName() + SUF));

            final BufferedImage img3 =
            ImageIO.read(new URL(PREF + MAIN_PATH + cardList.get(2).getName() + SUF));

            final BufferedImage img4 =
            ImageIO.read(new URL(PREF + MAIN_PATH + cardList.get(3).getName() + SUF));

            BufferedImage pattern =
            ImageIO.read(new URL(PREF + MAIN_PATH + "pattern" + SUF));

            Graphics graphics = pattern.getGraphics();

            graphics.drawImage(img1, IMG_X_POS_FIRST, SMALL_BORDER, null);
            graphics.drawImage(img2, IMG_X_POS_SECOND, SMALL_BORDER, null);
            graphics.drawImage(img3, IMG_X_POS_THIRST, SMALL_BORDER, null);
            graphics.drawImage(img4, IMG_X_POS_FOUR, SMALL_BORDER, null);


            ImageIO.write(pattern, PNG, new File(MAIN_PATH + "temp/temp.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File(MAIN_PATH + "temp/temp.png");
    }
}
