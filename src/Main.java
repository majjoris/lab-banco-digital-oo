
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Cliente returnObject(List<Cliente> cliente, String nome) {
        return cliente.stream()
                .filter(T -> T.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        int op, valor, op1;
        String nome;

        System.out.println("Nome do cliente");
        nome = ler.nextLine();

        clientes.add(new Cliente(nome));

        Conta cc = new ContaCorrente(returnObject(clientes, nome));

        Conta poupanca = new ContaPoupanca(returnObject(clientes, nome));
        do {
            System.out.println("*****************************");
            System.out.println("*1-Depositar\t2-Sacar	    *\n*3-Extrato\t4Transferir *\n*5-Mudar Conta\t0-Sair	    *");
            System.out.println("*****************************");
            op = ler.nextInt();
            switch (op) {
                case 1:
                    System.out.println("\t1-Conta Corrente\t2-Poupança");
                    op1 = ler.nextInt();
                    if (op1 == 1) {
                        System.out.println("Valor do deposito");
                        valor = ler.nextInt();
                        cc.depositar(valor);
                    } else {
                        System.out.println("Valor do deposito");
                        valor = ler.nextInt();
                        poupanca.depositar(valor);
                    }
                    break;
                case 2:
                    System.out.println("\t1-Conta Corrente\t2-Poupança");
                    op1 = ler.nextInt();
                    if (op1 == 1) {
                        System.out.println("Valor do saque");
                        valor = ler.nextInt();
                        cc.sacar(valor);
                    } else {
                        System.out.println("Valor do saque");
                        valor = ler.nextInt();
                        poupanca.sacar(valor);
                    }
                    break;
                case 3:
                    System.out.println("\t1-Conta Corrente\t2-Poupança");
                    op1 = ler.nextInt();
                    if (op1 == 1) {
                        cc.imprimirExtrato();
                    } else {
                        poupanca.imprimirExtrato();
                    }
                    break;
                case 4:
                    System.out.println("\t1-Conta Corrente\t2-Poupança");
                    op1 = ler.nextInt();
                    if (op1 == 1) {
                        System.out.println("Valor da transferência");
                        valor = ler.nextInt();
                        cc.transferir(valor, poupanca);
                    } else {
                        System.out.println("Valor da transferência");
                        valor = ler.nextInt();
                        poupanca.transferir(valor, cc);
                    }
                    break;
                case 5:
                    System.out.println("Nome do cliente");
                    nome = ler.next();
                    clientes.add(new Cliente(nome));

                    cc = new ContaCorrente(returnObject(clientes, nome));
                    poupanca = new ContaPoupanca(returnObject(clientes, nome));
                    break;
            }
        } while (op != 0);
        ler.close();
    }

}
