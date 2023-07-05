import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            showMenu();
            
            int choice = getOption();
            System.out.println();

            switch(choice){
                case 1:
                    createTask();
                    break;
                case 2: 
                    deleteTask();
                    break;
                case 3:
                    getAllTasks();
                    break;
                case 4:
                    closeProgram();
                    return;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }

    private static int getOption(){
        return scanner.nextInt();
    }

    private static void showMenu(){
        System.out.println("==============================");
        System.out.println();
        System.out.println("Bem-vindo a lista de tarefas!");
        System.out.println();
        System.out.println("==============================");
        
        System.out.println();
        System.out.println("Opcoes");
        System.out.println("1 - Adicionar uma tarefa");
        System.out.println("2 - Remover uma tarefa");
        System.out.println("3 - Visualizar todas as tarefas");
        System.out.println("4 - Sair");
        System.out.println();
    }

    private static void createTask(){
        System.out.println("Digite o titulo da tarefa: ");
        String title = scanner.nextLine();

        tasks.add(title);
        System.out.println("Tarefa adicionada com sucesso");
    }

    private static void deleteTask(){

        if(tasks.isEmpty()){
            System.out.println("A lista esta vazia");
            return;
        }

        getAllTasks();

        System.out.println("Digite o numero da tarefa que deseja excluir:");
        int choisedIndex = getOption();

        if(choisedIndex < 1 || choisedIndex > tasks.size()){
            System.out.println("Numero invalido");
            return;
        }

        String removedTask = tasks.remove(choisedIndex);
        System.out.println("Tarefa removida: " + removedTask);
        
        getOption();
    }

    private static void getAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("A lista esta vazia");
            return;
        }

        System.out.println("Tarefas disponiveis:");
        System.out.println();
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i + 1) + "-" + tasks.get(i));
        }

        scanner.nextLine();
    }

    private static void closeProgram(){
        System.out.println("Obrigado por usar a minha lista de tarefas");
        scanner.close();
    }
}