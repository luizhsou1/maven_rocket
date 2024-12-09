package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository() {
        conexao = FabricaConexao.getConexao();
    }

    public void incluir(Cadastro cadastro) {
        try {
            String sql = "INSERT INTO public.tab_cadastro (nome, idade) VALUES (?, ?)";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());

            pst.execute();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro) {
        try {
            String sql = "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());

            pst.execute();
            System.out.println("Cadastro alterado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Integer id) {
        try {
            String sql = "DELETE FROM public.tab_cadastro WHERE id=?";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.execute();
            System.out.println("Cadastro excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cadastro> listar() {
        List<Cadastro> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM public.tab_cadastro;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro(id, nome, idade);
                lista.add(cadastro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cadastro buscar(Integer id) {
        Cadastro cadastro = null;
        try {
            String sql = "SELECT * FROM public.tab_cadastro WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();

            if (result.next()) {
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                cadastro = new Cadastro(id, nome, idade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cadastro;
    }
}
