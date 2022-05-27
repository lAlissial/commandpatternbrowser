package br.com.edu.ifpb.si.padroes.semana15.command;

import br.com.edu.ifpb.si.padroes.semana15.Browser;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VisitCommand extends Command{
    public VisitCommand(Browser browser) {
        super(browser);
    }

    @Override
    public boolean execute() {
        if (!browser.urls.isEmpty()) {
            if (browser.urls.contains((browser.entradaUsuario.split(" ", 2)[1]))) {
                try {
                    URL url = new URL(browser.entradaUsuario.split(" ", 2)[1]);
                    HttpURLConnection huc = (HttpURLConnection) url.openConnection();
                    int responseCode = huc.getResponseCode();
                    System.out.println(responseCode);
                    backup();

                    // Lendo conteudo da página
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {

                        String line;

                        StringBuilder sb = new StringBuilder();

                        while ((line = br.readLine()) != null) {

                            sb.append(line);
                            sb.append(System.lineSeparator());
                        }

                        System.out.println(sb);
                    }


                } catch (Exception e){
                    System.out.println("Não foi possível acessá-lo no momento");
                }
            } else{
                System.out.println("URL não cadastrada");
            }
            return true;
        } else{
            return false;
        }

    }

}
