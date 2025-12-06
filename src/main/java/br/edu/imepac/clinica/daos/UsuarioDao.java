package br.edu.imepac.clinica.daos;

import br.edu.imepac.clinica.entidades.EnumFuncionalidades;
import br.edu.imepac.clinica.entidades.EnumStatusUsuario;
import br.edu.imepac.clinica.entidades.Perfil;
import br.edu.imepac.clinica.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDao extends BaseDao {

    public Usuario autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setStatus(EnumStatusUsuario.valueOf(rs.getString("status")));

                String nomePerfil = rs.getString("perfil");
                Perfil perfil = new Perfil();
                perfil.setNome(nomePerfil);

                Set<EnumFuncionalidades> funcs = new HashSet<>();
                // Simple mapping logic for demonstration
                if ("MEDICO".equalsIgnoreCase(nomePerfil)) {
                    funcs.add(EnumFuncionalidades.REALIZAR_CONSULTA);
                    funcs.add(EnumFuncionalidades.GERAR_RELATORIOS);
                } else if ("RECEPCIONISTA".equalsIgnoreCase(nomePerfil)) {
                    funcs.add(EnumFuncionalidades.AGENDAR_CONSULTA);
                    funcs.add(EnumFuncionalidades.CADASTRAR_PACIENTE);
                    funcs.add(EnumFuncionalidades.CADASTRAR_MEDICO);
                } else if ("ADMIN".equalsIgnoreCase(nomePerfil)) {
                    for (EnumFuncionalidades f : EnumFuncionalidades.values()) {
                        funcs.add(f);
                    }
                }
                perfil.setFuncionalidades(funcs);
                usuario.setPerfil(perfil);

                return usuario;
            }
        } finally {
            fecharRecursos(conn, stmt, rs);
        }
        return null;
    }
}
