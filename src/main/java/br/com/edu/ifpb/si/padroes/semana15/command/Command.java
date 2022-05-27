package br.com.edu.ifpb.si.padroes.semana15.command;

import br.com.edu.ifpb.si.padroes.semana15.Browser;

public abstract class Command {
    public Browser browser;
    private String backup;

    Command(Browser browser) {
        this.browser = browser;
    }

    void backup() {
        backup = browser.entradaUsuario.split(" ",2)[1];
    }

    public void back() {
        if (backup!=null){
            System.out.println("Histórico de Visitas:");
            System.out.println("Home: ["+ backup +"]");
        } else{
            System.out.println("");
        }

    }

    public abstract boolean execute();
}