package academia.main;

import java.sql.*;
import java.util.ArrayList;
import com.academia.controller.ConexaoBD;

public class TreinoDAO {

    public boolean inserir(Treino treino) {
        String sql = "INSERT INTO treino (id_aluno, tipo, descricao, duracao, data_inicio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, treino.getIdAluno());
            stmt.setString(2, treino.getTipo());
            stmt.setString(3, treino.getDescricao());
            stmt.setInt(4, treino.getDuracao());
            stmt.setString(5, treino.getDataInicio());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir treino: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Treino> listarPorAluno(int idAluno) {
        ArrayList<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treino WHERE id_aluno = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Treino treino = new Treino(
                        rs.getInt("id"),
                        rs.getInt("id_aluno"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getInt("duracao"),
                        rs.getString("data_inicio")
                    );
                    lista.add(treino);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar treinos: " + e.getMessage());
        }
        return lista;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM treino WHERE id = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir treino: " + e.getMessage());
            return false;
        }
    }
}
