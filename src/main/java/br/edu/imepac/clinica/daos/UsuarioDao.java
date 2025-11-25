/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.clinica.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ypth
 */
public class UsuarioDao extends BaseDao {
  
    public boolean verificarExistenciaUsuario(String usuario, String senha) throws SQLException{
        try (
        Connection conn = this.getConnection();
        /*String sql*/
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?"))
        {
        ps.setString(1, usuario);
        ps.setString(2, senha);
        try(ResultSet rs = ps.executeQuery()) {
            return rs.next();
        }
        }
            
        }
}
    
    
