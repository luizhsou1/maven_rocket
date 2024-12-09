package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository repository = new CadastroRepository();

//        Cadastro cadastro = new Cadastro(null, "Maria Julia", 0);
//        repository.incluir(cadastro);

//        cadastro.setNome("Maju");
//        cadastro.setIdade(3);
//        cadastro.setId(3);
//
//        repository.alterar(cadastro);
//
//        repository.excluir(4);

        List<Cadastro> cadastros = repository.listar();
        for (Cadastro c: cadastros) {
            System.out.println(c.toString());
        }

        int id = 1;
        System.out.println("Buscando pelo id " + id);
        Cadastro cadastro = repository.buscar(id);
        if (cadastro != null) {
            System.out.println(cadastro.toString());
        } else {
            System.out.println("Não foi encontrado cadastro com o id " + id);
        }
    }
}