import java.util.Scanner;

public class Consulta {
    private static final String[] emailsOficiais = {
            "elDoradoOficial@gmail.com",
            "netflixOficial@gmail.com",
            "amazonOficial@gmail.com",
            "mercadoLivreOficial@gmail.com"
    };

    public String[] getEmailsOficiais() {
        return emailsOficiais;
    }

    public void checarEmpresa(int numEmpresa) {
        if(numEmpresa < 0 || numEmpresa > emailsOficiais.length - 1) {
            System.out.println("Não existe uma empresa com este número.");
        }
    }

    public void checarPossuiLink(String possuiLink, Scanner scanner, Verificar verificar) {
        if(possuiLink.equalsIgnoreCase("S")) {
            System.out.println("Digite o link enviado na mensagem:");
            String link = scanner.nextLine();
            verificar.checarLink(link);
        } else if(possuiLink.equalsIgnoreCase("N")) {
            System.out.println("Seguindo para a próxima verificação.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void checarPerigo(Verificar verificar) {
        if(verificar.getContadorSuspeita() >= 3) {
            System.out.println(verificar.getContadorSuspeita() + " suspeitas foram contadas. Provavelmente é golpe!");
        } else if(verificar.getContadorSuspeita() > 0 && verificar.getContadorSuspeita() < 3) {
            System.out.println(verificar.getContadorSuspeita() + " suspeitas foram contadas. A mensagem é suspeita, tenha cuidado");
        } else {
            System.out.println("Nenhuma suspeita foi encontrada. Provavelmente é legítimo.");
        }
    }
}
