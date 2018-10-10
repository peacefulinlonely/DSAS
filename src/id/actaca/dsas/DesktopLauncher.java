package id.actaca.dsas;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] args){
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width =500;
        config.height = 280;
        LwjglApplication app = new LwjglApplication(new Dsas(),config);
    }
}
