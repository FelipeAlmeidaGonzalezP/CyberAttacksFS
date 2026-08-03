import java.util.Scanner;

public class Verificar {

    private final Consulta consulta;

    public Verificar(Consulta consulta) {
        this.consulta = consulta;
    }

    public boolean checarEmpresa(int numEmpresa) {
        if(numEmpresa < 0 || numEmpresa >= consulta.getEmailsOficiais().length) {
            System.out.println("Não existe uma empresa com este número.");
            return true;
        } else {
            return false;
        }
    }

    public void checarLink(String link) {
        if(link.startsWith("https")) {
            System.out.println("O link segue o protocolo de segurança.");
        } else {
            System.out.println("O link não segue o protocolo de segurança.");
            consulta.adicionarSuspeita();
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

