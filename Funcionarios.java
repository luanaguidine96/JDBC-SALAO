public class Funcionarios {
    private String nome;
    private float preco;
    private String cargo;
    private float horarioI;
    private float horarioF;

    public float getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public float getHorarioI() {
        return horarioI;
    }

    public float getHorarioF() {
        return horarioF;
    }


      public Funcionarios(String nome, float preco, String cargo, float horarioI, float horarioF) {
        this.nome = nome;
        this.preco = preco;
        this.cargo = cargo;
        this.horarioI = horarioI;
        this.horarioF = horarioF;
        }

      @Override
      public String toString() {
        return "Funcionarios [nome=" + nome + ", preco=" + preco + ", cargo=" + cargo + ", horarioI=" + horarioI
                + ", horarioF=" + horarioF + "]";
      }


}
