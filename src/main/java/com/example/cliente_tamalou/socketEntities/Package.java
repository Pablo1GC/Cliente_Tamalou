package com.example.cliente_tamalou.socketEntities;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.lang.NonNull;

import java.io.Serializable;

public class Package implements Serializable {

    public static Gson gson = new Gson();

    public int signal;
    public JsonElement data;

    public Package(int signal, @NonNull Object data){
        this.signal = signal;
        this.data = gson.toJsonTree(data);
    }

    public Package(int signal){
        this.signal = signal;
        this.data = null;
    }

    public static String pack(int signal, @NonNull Object object){
        return String.format("{\"signal\": %d, \"data\": %s}", signal, gson.toJson(object));
    }

    public static String pack(int signal){
        return String.format("{\"signal\": %d}", signal);
    }

    @Override
    public String toString() {
        if(data != null){
            return String.format("{\"signal\": %d, \"data\": %s}", signal, gson.toJson(data));
        }

        return String.format("{\"signal\": %d}", signal);
    }
}
