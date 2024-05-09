import java.util.Scanner;

public class SmartTv {
    public static void main(String[] args) throws Exception {
        System.out.println("Sistema Smart TV");

        Scanner scanner = new Scanner(System.in); 
        boolean menu = true; 
        
        Controle controle = new Controle();

        while (menu) {

        System.out.println("---------  Status ----------");
        System.out.println("Ligada: " + (controle.estaLigada ? "Sim" : "Não"));
        if(controle.estaLigada){
        
        System.out.println("Canal: " + controle.canal);
        System.out.println("Volume: " + controle.volume);
        }
        
        System.out.println("---------  Menu -------------");
        System.out.println("1) Ligar / Desligar");
        if(controle.estaLigada){
        System.out.println("2) Mudar canal");
        System.out.println("3) Aumentar volume");
    }
        System.out.println("4) Sair");

        
            System.out.print("\n Digite uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 
        
            switch (option) {
                case 1:
                    if (!controle.estaLigada) {
                        System.out.println("A TV está desligada. Deseja ligar (sim/não)?");
                        String resposta = scanner.nextLine();
                        if (resposta.equals("sim")) {
                            controle.estaLigada = true;
                        }
                    } else {
                        System.out.println("A TV está ligada. Deseja desligar (sim/não)?");
                        String resposta = scanner.nextLine();
                        if (resposta.equals("sim")) {
                            controle.estaLigada = false;
                        }
                    }
                    break;
        
                case 2:
                System.out.println("O canal está " + controle.canal);
                System.out.print("Mudar para o canal: ");
                int novoCanal = scanner.nextInt();
                controle.mudarCanal(novoCanal);
                break;
        
                case 3:
                    System.out.println("O volume está " + controle.volume);
                    System.out.print("1) Aumentar volume: ");
                    System.out.print("2) Reduzir volume: ");

                    int novoVolume = scanner.nextInt();
                    if(novoVolume==1){
                        controle.aumentarVolume();
                        break;
                    } else if (novoVolume==2){
                        controle.reduzirVolume();
                        break;
                    } else {
                        System.out.println("Opção inválida.");
                    }
                   
                    break;
        
                case 4:
                    System.out.println("Saindo... ");
                    menu = false; // Set menu to false to exit the loop
                    break;
        
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }
}
