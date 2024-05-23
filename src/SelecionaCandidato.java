import java.util.concurrent.ThreadLocalRandom;

public class SelecionaCandidato {
    public static void main(String[] args) {
        analisaCandidato();
    }


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

    static void imprimirCandidato(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};

        for(String candidato : candidatos){
            System.out.println( candidato + " foi selecionado para entrevista");
        }
    }

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