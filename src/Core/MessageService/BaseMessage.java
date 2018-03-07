package Core.MessageService;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseMessage {
    public String body;
    public HashMap<String, String> data;

    public abstract void init();

    public void setData(HashMap<String, String> data){
        this.data = data;
    }

    public String getFinal(){
        String finalBody = body;
        for(Iterator<Map.Entry<String, String>> it = this.data.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();
            finalBody = finalBody.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }
        return finalBody;
    }
}