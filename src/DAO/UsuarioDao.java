package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import entity.Usuario;

public class UsuarioDao {
    
    Connection conn;
    ArrayList<Usuario> Lista = new ArrayList<>();
    
    public void cadastrarUsuario(Usuario usuario){

        String sql = "INSERT INTO `usuario` (`nome_usuario`, `senha_usuario`) VALUES (?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getSenhaUsuario());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> ListarUsuario() {
        String sql ="SELECT * FROM `usuario`";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Usuario objUsuario = new Usuario();
                objUsuario.setIdUsuario(rs.getInt("id_usuario"));
                objUsuario.setNomeUsuario(rs.getString("nome_usuario"));
                objUsuario.setSenhaUsuario(rs.getString("senha_usuario"));

                Lista.add(objUsuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Lista;
    }
    
}
