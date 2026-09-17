import java.util.Optional;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
       
        String url = "jdbc:mysql://127.0.0.1:3306/clientessalao";
        String usuario = "root";
        String senha = "123";


        Scanner sc = new Scanner(System.in);
        ListaF<Funcionarios> listando = new ListaF<>();
    Funcionarios f1 = new Funcionarios("Luana", 200.00f, "progressiva", 7.00f, 17.30f);
    Funcionarios f2 = new Funcionarios("Lara", 50.00f, "cortes rapidos", 12.30f, 18.00f);
listando.add(f1);
listando.add(f2);
System.out.println("------------------------------------------------");
System.out.println("          Salão de Beleza incriveis");
System.out.println("------------------------------------------------");
System.out.println("                Funcionarios");
System.out.println("------------------------------------------------");
listando.mostrar();
System.out.println("------------------------------------------------");
System.out.println("Qual serviço precisa ?");
String nome = sc.nextLine();
System.out.println("Qual o horario ?");
float hora = sc.nextFloat();
     sc.nextLine();
System.out.println("Qual seu nome ?");
String cliente = sc.nextLine();
System.out.println("Nome: " + cliente );
System.out.println("Serviço: " + nome );
System.out.println("Horario: " + hora);

Optional<Funcionarios> tempo = //condiçoes apara a opçao funcionario ser present ou else
listando.getListaF()
    .stream()
    .filter(fun -> fun.getHorarioI() < hora)
    .filter(fun -> fun.getHorarioF() > hora)
    .findFirst(); //pega o funcionario filtrado e avalia se é true ou false suas condiçoes filtradas

tempo.ifPresentOrElse( //se e senao
    fun -> System.out.println("horario possivel de agendar"), // true
    () -> System.out.println("horario impossivel de agendar") //false
);

Optional<Funcionarios> cargos = //condiçoes apara a opçao funcionario ser present ou else
listando.getListaF()
    .stream()
    .filter(fun -> fun.getCargo().equals(nome))
    .findFirst(); //pega o funcionario filtrado e avalia se é true ou false suas condiçoes filtradas

cargos.ifPresentOrElse( //se e senao
    fun -> System.out.println("profissional possivel de agendar"), // true
    () -> System.out.println("profissional impossivel de agendar") //false
);
//fun = funcionário atual que o Stream está analisando.
//cargos e tempo= resultado encontrado depois da busca.

if (cargos.isPresent() && tempo.isPresent()){

                try {

                    Connection conexao = DriverManager.getConnection(
                        url,
                        usuario,
                        senha
                    );

                    String sql =
                        "INSERT INTO clientes " +
                        "(nome_cliente, horario_procedimento, servico_escolhido) " +
                        "VALUES (?, ?, ?)";

                    PreparedStatement stmt =
                        conexao.prepareStatement(sql);

                    stmt.setString(1, cliente);
                    stmt.setString(2, String.valueOf(hora));
                    stmt.setString(3, nome);

                    stmt.executeUpdate();

                    System.out.println("Cliente cadastrado no banco!");
                    System.out.println("Agendamento realizado com sucesso!");

                    stmt.close();
                    conexao.close();

                } catch (Exception e) {

                    System.out.println("Erro ao cadastrar cliente:");
                    
                }
            
}else {
    System.out.println("nao cadastrado");
}

    }
}
