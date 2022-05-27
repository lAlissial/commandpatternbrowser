package br.com.edu.ifpb.si.padroes.semana15;

import br.com.edu.ifpb.si.padroes.semana15.command.AddCommand;
import br.com.edu.ifpb.si.padroes.semana15.command.Command;
import br.com.edu.ifpb.si.padroes.semana15.command.CommandHistory;
import br.com.edu.ifpb.si.padroes.semana15.command.VisitCommand;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Browser {
    public String entradaUsuario;
    public Set<String> urls = new HashSet<String>();;

    public CommandHistory history = new CommandHistory();



    public void init() {
        do {

            Browser browser = this;
            Scanner teclado = new Scanner(System.in);

            System.out.print("> #");
            browser.entradaUsuario = teclado.nextLine().toUpperCase();

            switch (browser.entradaUsuario.split(" ",2)[0]){
                case "ADD":
                    executeCommand(new AddCommand(browser));
                    break;
                case "BACK":
                    back();
                    break;
                case "VISIT":
                    executeCommand(new VisitCommand(browser));
                    break;
                case "QUIT":
                    break;
                default:
                    System.out.println("Digite um comando válido!");;
            }
        }
        while(!entradaUsuario.equalsIgnoreCase("QUIT"));

        System.out.println("              GOODBYE!");
        System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣉⡥⠶⢶⣿⣿⣿⣿⣷⣆⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡿⢡⡞⠁⠀⠀⠤⠈⠿⠿⠿⠿⣿⠀⢻⣦⡈⠻⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡇⠘⡁⠀⢀⣀⣀⣀⣈⣁⣐⡒⠢⢤⡈⠛⢿⡄⠻⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⡇⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠉⠐⠄⡈⢀⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⠇⢠⣿⣿⣿⣿⡿⢿⣿⣿⣿⠁⢈⣿⡄⠀⢀⣀⠸⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⡿⠟⣡⣶⣶⣬⣭⣥⣴⠀⣾⣿⣿⣿⣶⣾⣿⣧⠀⣼⣿⣷⣌⡻⢿⣿\n" +
                "⣿⣿⠟⣋⣴⣾⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿⣿⣿⣿⣿⣿⡿⢸⣿⣿⣿⣿⣷⠄⢻\n" +
                "⡏⠰⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢂⣭⣿⣿⣿⣿⣿⠇⠘⠛⠛⢉⣉⣠⣴⣾\n" +
                "⣿⣷⣦⣬⣍⣉⣉⣛⣛⣉⠉⣤⣶⣾⣿⣿⣿⣿⣿⣿⡿⢰⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡘⣿⣿⣿⣿⣿⣿⣿⣿⡇⣼⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢸⣿⣿⣿⣿⣿⣿⣿⠁⣿⣿⣿⣿⣿⣿⣿⣿⣿");
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void back() {
        if (history.isEmpty()){
            return;
        }

        Command command = history.pop();
        if (command != null) {
            command.back();
        }
    }

}