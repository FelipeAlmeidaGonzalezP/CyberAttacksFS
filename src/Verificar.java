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

    public void checarLink(String link) {
        if(link.startsWith("https")) {
            System.out.println("O link segue o protocolo de segurança HTTPS.");
        } else {
            System.out.println("O link não segue o protocolo de segurança HTTPS.");
            consulta.adicionarSuspeita();
        }
        if(link.contains("bit.ly") || link.contains("tinyurl")) {
            System.out.println("O link foi encurtado, escondendo seu destino real.");
            consulta.adicionarSuspeita();
        }
    }

    public void checarMensagem(String mensagem) {
        long quantidadePalavrasSuspeitas = palavrasSuspeitas.stream().filter(mensagem::contains).count();
        if(quantidadePalavrasSuspeitas > 1) {
            System.out.println("Múltiplas palavras suspeitas foram detectadas.");
            consulta.adicionarSuspeita();
            consulta.adicionarSuspeita();
        } else if(quantidadePalavrasSuspeitas == 1) {
            System.out.println("Somente uma palavra suspeita foi detectada.");
            consulta.adicionarSuspeita();
        } else {
            System.out.println("Nenhuma palavra suspeita foi detectada.");
        }
    }

    public void checarPossuiLink(String possuiLink, Scanner scanner) {
        if(possuiLink.equalsIgnoreCase("S")) {
            System.out.println("Digite o link enviado na mensagem:");
            String link = scanner.nextLine();
            checarLink(link);
        } else if(possuiLink.equalsIgnoreCase("N")) {
            System.out.println("Seguindo para a próxima verificação.");
        } else {
            System.out.println("Opção inválida.");
        }
    }
}

