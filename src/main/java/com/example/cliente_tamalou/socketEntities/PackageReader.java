package com.example.cliente_tamalou.socketEntities;

import com.google.gson.Gson;

import java.util.Scanner;

public class PackageReader {

    Gson gson = new Gson();

    private final Scanner reader;

    public PackageReader(Scanner reader) {
        this.reader = reader;
    }

    public Package readPackage(){
        return gson.fromJson(reader.nextLine(), Package.class);
    }

}
