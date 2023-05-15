package com.example.cliente_tamalou.socketEntities;

import org.springframework.lang.NonNull;

import java.io.OutputStream;
import java.io.PrintStream;

public class PackageWriter{

    private final PrintStream printStream;

    public PackageWriter(OutputStream stream) {
        this.printStream = new PrintStream(stream);
    }

    public void packAndWrite(int signal, @NonNull Object object){
        write(new Package(signal, object));
    }

    public void packAndWrite(int signal){
        write(new Package(signal));
    }

    public void write(Package pack){
        System.out.println(pack);
        printStream.println(pack);
    }
}
