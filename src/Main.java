import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numEmpresa;
        String possuiLink;
        Consulta consulta = new Consulta();
        Verificar verificar = new Verificar(consulta);

        //Checa se a mensagem possui link, se possui, checa sua vericidade
        do {
            System.out.print("A mensagem está acompanhada de um link? (S/N)");
            possuiLink = scanner.nextLine();
            consulta.checarPossuiLink(possuiLink, scanner, verificar);
        } while (!possuiLink.equalsIgnoreCase("S")
                && !possuiLink.equalsIgnoreCase("N"));

        //Checa o conteúdo da mensagem por palavras suspeitas
        System.out.println("Qual a mensagem do e-mail?");
        String mensagem = scanner.nextLine().toLowerCase();

        verificar.checarMensagem(mensagem);

        //Checa a empresa do remetente
        do {
            System.out.println("Qual a empresa que diz ter mandado o e-mail?");
            System.out.println("0. Nenhuma destas empresas \n1. ElDorado \n2. Netflix \n3. Amazon \n4. Mercado Livre");
            numEmpresa = scanner.nextInt() - 1;
            scanner.nextLine();

            //Se for algumas das empresas, checa se o e-mail corresponde ao e-mail oficial
            consulta.checarEmpresa(numEmpresa, scanner, verificar);
        } while (numEmpresa < -1 || numEmpresa > consulta.getEmailsOficiais().length - 1);

        //Checa o contador de suspeita e imprime um texto falando qual a quantidade de suspeitas e seu nível de perigo
        consulta.checarPerigo(verificar);

        scanner.close();
    }
}
