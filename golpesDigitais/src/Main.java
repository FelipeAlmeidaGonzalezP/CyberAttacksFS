import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEmpresa;
        String possuiLink;
        Consulta consulta = new Consulta();
        Verificar verificar = new Verificar(consulta);

        do {
            System.out.print("A mensagem está acompanhada de um link? (S/N)");
            possuiLink = scanner.nextLine();
        } while (!possuiLink.equalsIgnoreCase("S")
                && !possuiLink.equalsIgnoreCase("N"));

        //Checa se a mensagem possui link, se possui, checa sua vericidade
        verificar.checarPossuiLink(possuiLink, scanner);

        //Checa a empresa do remetente
        boolean empresaInvalida;
        do {
            System.out.println("Qual a empresa que diz ter mandado o e-mail?");
            System.out.println("1. ElDorado \n2. Netflix \n3. Amazon \n4. Mercado Livre");
            numEmpresa = scanner.nextInt() - 1;
            scanner.nextLine();

            empresaInvalida = verificar.checarEmpresa(numEmpresa);
        } while (empresaInvalida);

        //Checa se o e-mail do remetente corresponde com o e-mail oficial da empresa selecionada
        System.out.println("Qual o e-mail de quem enviou a mensagem?");
        String emailMensagem = scanner.nextLine();
        consulta.checarEmail(emailMensagem, numEmpresa);

        //Checa o contador de suspeita e imprime um texto falando qual o nível de perigo
        consulta.checarPerigo();

        scanner.close();
    }
}
