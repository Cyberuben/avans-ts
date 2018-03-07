package Core;

import java.util.HashMap;

public abstract class NotfiyObserver {
    public abstract void onNotify(String to, String template, HashMap<String, String> data);
}
