import java.util.List;
import java.util.Scanner;

public class Verificar {

    private static List<String> palavrasSuspeitas = List.of("urgente",
            "importante",
            "imediatamente",
            "urgentemente",
            "agora",
            "pix",
            "prêmio",
            "selecionado",
            "banco",
            "expirando",
            "imediato",
            "bloqueio",
            "bloqueado",
            "bloqueada",
            "cancelamento",
            "cancelado",
            "sorteio",
            "sorteado",
            "loteria",
            "cancelada",
            "ganhe",
            "confirme",
            "confirmar",
            "receba",
            "resgate",
            "resgatar",
            "instale",
            "informações",
            "limite");

    private final Consulta consulta;

    public Verificar(Consulta consulta) {
        this.consulta = consulta;
    }

    private int contadorSuspeita = 0;

    public int getContadorSuspeita() {
        return contadorSuspeita;
    }

    public void adicionarSuspeita() {
        contadorSuspeita+=1;
    }

    public void checarLink(String link) {
        if(link.startsWith("https")) {
            System.out.println("O link segue o protocolo de segurança HTTPS.");
        } else {
            System.out.println("O link não segue o protocolo de segurança HTTPS.");
            adicionarSuspeita();
        }
        if(link.contains("bit.ly") || link.contains("tinyurl")) {
            System.out.println("O link foi encurtado, escondendo seu destino real.");
            adicionarSuspeita();
        }
    }

    public void checarMensagem(String mensagem) {
        long quantidadePalavrasSuspeitas = palavrasSuspeitas.stream().filter(mensagem::contains).count();
        if(quantidadePalavrasSuspeitas > 1) {
            System.out.println("Múltiplas palavras suspeitas foram detectadas.");
            adicionarSuspeita();
            adicionarSuspeita();
        } else if(quantidadePalavrasSuspeitas == 1) {
            System.out.println("Somente uma palavra suspeita foi detectada.");
            adicionarSuspeita();
        } else {
            System.out.println("Nenhuma palavra suspeita foi detectada.");
        }
    }

    public void checarEmail(String emailMensagem, int numEmpresa) {
        if(emailMensagem.equalsIgnoreCase(consulta.getEmailsOficiais()[numEmpresa])) {
            System.out.println("E-mail corresponde ao e-mail oficial.");
        } else {
            System.out.println("E-mail NÃO corresponde ao e-mail oficial");
            adicionarSuspeita();
        }
    }
}

