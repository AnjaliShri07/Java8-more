package com.java8.programs.learning;

import java.io.IOException;
import java.util.stream.*;

public class GettingChildProcesses {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            ProcessBuilder processBuilder
                    = new ProcessBuilder("java.exe", "-version");
            processBuilder.inheritIO().start();
        }
        Stream<ProcessHandle> childProcesses = ProcessHandle.current().children();
        String np = "Not Present";
        childProcesses.filter(ProcessHandle::isAlive).forEach(
                childProcess ->{
                    System.out.printf("Process ID : %s%n", childProcess.pid());
                    System.out.printf("Command name : %s%n", childProcess.info().command().orElse(np));
                    System.out.printf("Command line : %s%n", childProcess.info().commandLine().orElse(np));
                }
        );
    }
}
