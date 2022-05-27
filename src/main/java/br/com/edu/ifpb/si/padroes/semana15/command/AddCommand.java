package br.com.edu.ifpb.si.padroes.semana15.command;

import br.com.edu.ifpb.si.padroes.semana15.Browser;

import java.net.URI;
import java.net.URL;


public class AddCommand extends Command{
    public AddCommand(Browser browser) {
        super(browser);
    }

    @Override
    public boolean execute() {
       if (browser.urls.contains(browser.entradaUsuario.split(" ",2)[1])){
           System.out.println("URL já cadastrada!");
       } else{
           try {
               URI url = new URL(browser.entradaUsuario.split(" ", 2)[1]).toURI();
           } catch(Exception e){
               System.out.println("URL inválida");
               return false;
           }
           browser.urls.add(browser.entradaUsuario.split(" ",2)[1]);
           System.out.println("URL cadastrada com sucesso!");
       }
       return false;
    }
}
