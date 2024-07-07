package com.java8.programs.learning;

import java.io.IOException;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GettingCurrentProcessInfo {
    public static void main(String[] args) throws IOException {
        String np = "Not Present";
        ProcessHandle currentProcess = ProcessHandle.current();
        ProcessHandle.Info info = currentProcess.info();
        System.out.printf("Process ID : %s%n", currentProcess.pid());
        System.out.printf("Command name : %s%n", info.command().orElse(np));
        System.out.printf("Command line : %s%n", info.commandLine().orElse(np));

        System.out.printf("Start time: %s%n",
                info.startInstant().map(i -> i.atZone(ZoneId.systemDefault())
                        .toLocalDateTime().toString()).orElse(np));

        System.out.printf("Arguments : %s%n",
                info.arguments().map(a -> Stream.of(a).collect(
                        Collectors.joining(" "))).orElse(np));

        System.out.printf("User : %s%n", info.user().orElse(np));
    }
}
