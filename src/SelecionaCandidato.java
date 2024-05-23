import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelecionaCandidato {
    public static void main(String[] args) {
        imprimirCandidato();
    }

    // Case 2
    //Percorre a String candidatos e seleciona apenas cinco de acordo com o salarioPretendido sorteado com um numero random
    static void analisaCandidato(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            //System.out.println("O candidato " + candidato + " solicitou um salário de %.2f" + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                candidatosSelecionados++;
                //System.out.println("O candidato " + candidato + " foi selecionado");
            }
            candidatoAtual++;
        }
    }

    // Case 3 modificado para fazer parte do Case 4 também
    // tenta contatar o candidato com um valor booleano aleatório com no máximo 3 tentativas
    static void imprimirCandidato(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

        for(String candidato : candidatos){
            tentaContatar(candidato);
        }
    }

    //Case 4
    static void tentaContatar(String candidato){
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuaTentando = !atendeu;
            if(continuaTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("O contato foi realizado com sucesso!");
            }
        }while (continuaTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contatar " + candidato + " com " + tentativasRealizadas + " tentativas.");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }



    //case 1
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void ligarCandidato(double salarioSolicitado){
        double salarioBase = 2000.0;

        if(salarioSolicitado < salarioBase){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioSolicitado == salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}