package p02.pres;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class AssetsLoader {
    private static final Map<String, ImageIcon> assets = new HashMap<>();

    static {
        loadAsset("player", "assets/player.png");
        loadAsset("turtle", "assets/turtle.png");
        loadAsset("fish", "assets/fish.png");
        loadAsset("background", "assets/background.png");
    }

    private static void loadAsset(String key, String path) {
        assets.put(key, new ImageIcon(path));
    }

    public static Image getAsset(String key) {
        return assets.getOrDefault(key, new ImageIcon()).getImage();
    }
}
