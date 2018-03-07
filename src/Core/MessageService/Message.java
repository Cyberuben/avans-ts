package Core.MessageService;


import java.util.HashMap;

public class Message {
    public String body;
    public HashMap<String, String> data;

    public void init(){

    }

    public void setData(HashMap<String, String> data){
        this.data = data;
    }

    public String getFinal(){

        return "";
    }
}