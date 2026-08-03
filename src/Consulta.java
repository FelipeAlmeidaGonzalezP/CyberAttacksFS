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

    private int contadorSuspeita = 0;

    public void adicionarSuspeita() {
        contadorSuspeita+=1;
    }

    public void checarEmpresa(int numEmpresa) {
        if(numEmpresa < 0 || numEmpresa > emailsOficiais.length - 1) {
            System.out.println("Não existe uma empresa com este número.");
        }
    }

    public void checarEmail(String emailMensagem, int numEmpresa) {
        if(emailMensagem.equalsIgnoreCase(emailsOficiais[numEmpresa])) {
            System.out.println("E-mail corresponde ao e-mail oficial.");
        } else {
            System.out.println("E-mail NÃO corresponde ao e-mail oficial");
            adicionarSuspeita();
        }
    }

    public void checarPerigo() {
        if(contadorSuspeita >= 3) {
            System.out.println(contadorSuspeita + " suspeitas foram contadas. Provavelmente é golpe!");
        } else if(contadorSuspeita > 0 && contadorSuspeita < 3) {
            System.out.println(contadorSuspeita + " suspeitas foram contadas. A mensagem é suspeita, tenha cuidado");
        } else {
            System.out.println("Nenhuma suspeita foi encontrada. Provavelmente é legítimo.");
        }
    }
}
