package academia.main;

import java.sql.*;
import java.util.ArrayList;
import com.academia.controller.ConexaoBD;

public class AlunoDAO {

    public boolean inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, email, cpf, data_nascimento, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getDataNascimento());
            stmt.setString(5, aluno.getTelefone());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Aluno> listarTodos() {
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("cpf"),
                    rs.getString("data_nascimento"),
                    rs.getString("telefone")
                );
                lista.add(aluno);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return lista;
    }

    public boolean atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, email = ?, cpf = ?, data_nascimento = ?, telefone = ? WHERE id = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getDataNascimento());
            stmt.setString(5, aluno.getTelefone());
            stmt.setInt(6, aluno.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
            return false;
        }
    }
}