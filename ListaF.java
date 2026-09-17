import java.util.ArrayList;
import java.util.List;

public class ListaF <T> { // informamos que criamos um tipo novo <T>
private List<T> listaF; //criamos um array generico passsando o tipo novo


    public ListaF() { // cria um construtor, transformando a variavel em array
        this.listaF = new ArrayList<>();
    }

    public void add( T coisas){// metodo para poder adicionar coisas noa rray
        listaF.add(coisas);
    }

    public void mostrar(){
        for (T coisas : listaF) { // for-each // para cada coisa do tipo T dentro do ARRAY listaF
            System.out.println(coisas);
        }
    }
    //stream api
    public List<T> getListaF() {
    return listaF;
}
    
}