import java.util.Scanner;

public class Consulta {
    private static final String[] emailsOficiais = {
            "elDoradoOficial@gmail.com",
            "netflixOficial@gmail.com",
            "amazonOficial@gmail.com",
            "mercadoLivreOficial@gmail.com"
    };

    private static final int limitadorGolpe = 3;
    private static final int limitadorSuspeita = 0;

    public String[] getEmailsOficiais() {
        return emailsOficiais;
    }

    public void checarEmpresa(int numEmpresa, Scanner scanner, Verificar verificar) {
        if(numEmpresa < -1 || numEmpresa > emailsOficiais.length - 1) {
            System.out.println("Não existe uma empresa com este número.");
        } else if(numEmpresa == -1) {
            System.out.println("Continuando verificação.");
        } else {
            System.out.println("Qual o e-mail do remetente?");
            String emailMensagem = scanner.nextLine();
            verificar.checarEmail(emailMensagem, numEmpresa);
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
        if(verificar.getContadorSuspeita() >= limitadorGolpe) {
            System.out.println(verificar.getContadorSuspeita() + " suspeitas foram contadas. Provavelmente é golpe!");
        } else if(verificar.getContadorSuspeita() > limitadorSuspeita && verificar.getContadorSuspeita() < limitadorGolpe) {
            System.out.println(verificar.getContadorSuspeita() + " suspeitas foram contadas. A mensagem é suspeita, tenha cuidado");
        } else {
            System.out.println("Nenhuma suspeita foi encontrada. Provavelmente é legítimo.");
        }
    }
}
