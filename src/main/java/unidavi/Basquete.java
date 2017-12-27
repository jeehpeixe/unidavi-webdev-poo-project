package unidavi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Basquete {
    
    static public final String OPCAO_INVALIDA = "Opção inválida! \n\n";
    
    public void processaDados() {
        
        boolean bSair = false;
        
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                printTextoMenuPrincipal();
                String opcao = scanner.nextLine();
                
                Logger.getGlobal().info("\n");
                
                switch (opcao) {
                    case "1": processaInclusaoTime(scanner);         break;
                    case "2": processaInclusaoAgendamento(scanner);  break;
                    case "3": processaAlteracaoAgendamento(scanner); break;
                    case "4": processaJogo(scanner);                 break;
                    case "5": bSair = true;                          break;  
                    
                    default: Logger.getGlobal().info(OPCAO_INVALIDA);
                }
                
            } while (bSair == false);
        }
    }
    
    private void printTextoMenuPrincipal(){
        Logger.getGlobal().info("------------------------------------------------------------------------------------------\n");
        Logger.getGlobal().info("|1 - Incluir Time | 2 - Agendar Jogo  | 3 - Reagendar Jogo | 4 - Iniciar Jogo | 5 - Sair |\n");
        Logger.getGlobal().info("------------------------------------------------------------------------------------------\n\n");
    }
    
    private void processaInclusaoTime(Scanner scanner){
        Logger.getGlobal().info("Informe o nome do Time: ");
        
        if (ControleJogos.getInstance().criaEquipe(scanner.nextLine()) != null) {
            Logger.getGlobal().info("\n Time criado com sucesso!\n\n");
        }
        else {
            Logger.getGlobal().info("\n Time informado já existe!\n\n");
        }
    }
    
    private void processaInclusaoAgendamento(Scanner scanner){
        if (ControleJogos.getInstance().buscaEquipes().size() >= 2) {
            Time oTimeA    = processaSelecaoTime(scanner, "1", null);
            Time oTimeB    = processaSelecaoTime(scanner, "2", oTimeA.getCodigo());
            Date dDataHora = processaSelecaoData(scanner);
            
            ControleJogos.getInstance().adicionaJogo(new Jogo(oTimeA, oTimeB, dDataHora));
        
            Logger.getGlobal().info("\n Novo Jogo Agendado! \n\n");
        }
        else {
            Logger.getGlobal().info("\n Deve haver pelo menos dois times cadastrados! \n\n");
        }
    }
    
    private Time processaSelecaoTime(Scanner scanner, String sNumero, Integer iTime1){
        
        Time oTime = null;
        
        do {
            Logger.getGlobal().log(Level.INFO, "Selecione o Time {0}: \n\n", sNumero);

            ArrayList<Time> aTimes = ControleJogos.getInstance().buscaEquipes();
            
            aTimes.forEach(oEquipeAtual -> {
                if (iTime1 == null || (oEquipeAtual.getCodigo() != iTime1)) {
                    Logger.getGlobal().log(Level.INFO, "{0}\n", oEquipeAtual.getDescricaoComChave());
                }
            });

            String sValorInformado = scanner.nextLine();

            for (Time oEquipeAtual : aTimes) {
                boolean bTimeExiste = String.valueOf(oEquipeAtual.getCodigo()).equals(sValorInformado);
                if (bTimeExiste && (iTime1 == null || oEquipeAtual.getCodigo() != iTime1)) {
                    oTime = oEquipeAtual;
                }
            }
            
            if (oTime == null) {
                Logger.getGlobal().info("Time inválido!\n\n");
            }

        } while (oTime == null);
        
        return oTime;
    }
    
    private Date processaSelecaoData(Scanner scanner){
        
        DateFormat dDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Date dData = null;
        
        do {
            Logger.getGlobal().info("Informe a Data e Hora do Jogo no formato DD/MM/AAAA HH:MM:SS: \n\n");

            try {
                dData = dDataHora.parse("10/10/2012 12:00:00");
                dDataHora.parse(scanner.nextLine());
            } 
            catch (ParseException ex) {
                Logger.getGlobal().info("Formato de Data/Hora Inválido! \n");
                dData = null;
            }

        } while (dData == null);
        
        return dData;
    }
    
    private void processaAlteracaoAgendamento(Scanner scanner){
        Jogo oJogo = selecionaJogosAguardando(scanner);
        
        if (oJogo == null) {
            Logger.getGlobal().info("Nenhum jogo disponível! \n\n");
        }
        else {
            DateFormat dDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
            boolean bDataOK = false;

            do {
                Logger.getGlobal().info("Informe a nova Data/Hora do Jogo no formato DD/MM/AAAA HH:MM:SS: \n\n");

                String sValorInformado = scanner.nextLine();

                try {
                    
                    Jogo oJogoReagendar = ControleJogos.getInstance().buscarJogoPorChave(oJogo.getChaveJogo());
                    oJogoReagendar.reagendarJogo(dDataHora.parse(sValorInformado));
        
                    Logger.getGlobal().info("Jogo reagendado com sucesso! \n");
                    bDataOK = true;
                } 
                catch (ParseException ex) {
                    Logger.getGlobal().info("Formato de Data/Hora Inválido! \n");
                }

            } while (!bDataOK);
        }
    }
    
    private Jogo selecionaJogosAguardando(Scanner scanner){
        Jogo oJogo = null;
        
        if (ControleJogos.getInstance().existemJogosAguardando()) {
            printTextoMenuJogosDisponiveis();
            do {
                String sValor = scanner.nextLine();

                try {
                    oJogo = selecionaOpcaoJogoValida(sValor);
                } 
                catch (NumberFormatException ex) {
                    Logger.getGlobal().info("Selecione uma opção de jogo válida! \n");
                }
            } while (oJogo == null);
        }
        
        return oJogo;
    }
    
    private Jogo selecionaOpcaoJogoValida(String sValor){
        
        ArrayList<Jogo> aJogos = ControleJogos.getInstance().getAllAgendamentos();
        
        Jogo oJogo;
        
        try {
            oJogo = aJogos.get(Integer.parseInt(sValor) - 1);
        }
        catch(IndexOutOfBoundsException ex){
            oJogo = null;
            Logger.getGlobal().info("Selecione uma opção de jogo válida! \n");
        }
        
        return oJogo;
    }
    
    private void printTextoMenuJogosDisponiveis(){
        Logger.getGlobal().info("Selecione o jogo desejado: \n");
            
        ArrayList<Jogo> aJogos = ControleJogos.getInstance().getAllAgendamentos();

        aJogos.stream().filter((oJogoAtual) -> (oJogoAtual.isAguardando())).forEachOrdered((Jogo oJogoAtual) -> {

            Logger.getGlobal().info(
                "Jogo: "        + (aJogos.indexOf(oJogoAtual) + 1) +
                " - Time A: "   + oJogoAtual.getEquipeA().getDescricao()+
                ", Time B: "    + oJogoAtual.getEquipeB().getDescricao() +
                ", Data/Hora: " + oJogoAtual.getDataHoraString() +
                " \n"
            );
        });

    }
    
    private void processaJogo(Scanner scanner){
        
        Jogo oJogo = selecionaJogosAguardando(scanner);
        
        if (oJogo == null) {
            Logger.getGlobal().info("Nenhum jogo disponível! \n\n");
        }
        else {
            oJogo.iniciaJogo();

            boolean bEncerrado = false;

            do {
                printTextoMenuPontos();
                        
                switch(scanner.nextLine()){
                    case "1":
                        oJogo.adicionarPontuacaoEquipeA(selecionaPontuacao(scanner));
                    break;
                    case "2":
                        oJogo.adicionarPontuacaoEquipeB(selecionaPontuacao(scanner));
                    break;
                    case "3":
                        oJogo.encerrarJogo();
                        Logger.getGlobal().info(
                            "Jogo Encerrado! \n" +
                            "Equipe A: " + oJogo.getPontosEquipeA() + " pontos \n" +
                            "Equipe B: " + oJogo.getPontosEquipeB() + " pontos \n\n"
                        );
                        bEncerrado = true;
                    break;
                    default:
                        Logger.getGlobal().info(OPCAO_INVALIDA);
                }
            } while(!bEncerrado); 
        }
    }
    
    private void printTextoMenuPontos(){
        Logger.getGlobal().info("----------------------------------------------------------\n");
        Logger.getGlobal().info("| 1 - Ponto Time A | 2 - Ponto Time B | 3 - Encerrar Jogo|\n");
        Logger.getGlobal().info("----------------------------------------------------------\n\n");
    }
    
    private InterfacePontuacao selecionaPontuacao(Scanner scanner){
        
        InterfacePontuacao oPontuacao = null;
        
        do {
            printTextoSelecaoPontuacao();
            switch(scanner.nextLine()){
                case "1": oPontuacao = new Cesta01(); break;
                case "2": oPontuacao = new Cesta02(); break;
                case "3": oPontuacao = new Cesta03(); break;
                
                default: Logger.getGlobal().info(OPCAO_INVALIDA);
            }
        } while(oPontuacao == null); 
        
        return oPontuacao;
    }
    
    private void printTextoSelecaoPontuacao(){
        Logger.getGlobal().info("-------------------------------\n");
        Logger.getGlobal().info("|1 Ponto | 2 Pontos | 3 Pontos|\n");
        Logger.getGlobal().info("-------------------------------\n");
    }
}
