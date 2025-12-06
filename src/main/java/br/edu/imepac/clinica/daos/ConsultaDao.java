package br.edu.imepac.clinica.daos;

import br.edu.imepac.clinica.entidades.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ConsultaDao extends BaseDao {

    public boolean agendar(Consulta consulta) throws SQLException {
        Connection conn = null;
        PreparedStatement stmtCheck = null;
        PreparedStatement stmtInsert = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Check for conflict
            String sqlCheck = "SELECT COUNT(*) FROM consultas WHERE id_medico = ? AND data_hora = ?";
            stmtCheck = conn.prepareStatement(sqlCheck);
            stmtCheck.setLong(1, consulta.getMedico().getId());
            stmtCheck.setTimestamp(2, Timestamp.valueOf(consulta.getDataHora()));
            rs = stmtCheck.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return false; // Conflict found
            }

            // Insert new consultation
            String sqlInsert = "INSERT INTO consultas (id_medico, id_paciente, data_hora, motivo) VALUES (?, ?, ?, ?)";
            stmtInsert = conn.prepareStatement(sqlInsert);
            stmtInsert.setLong(1, consulta.getMedico().getId());
            stmtInsert.setLong(2, consulta.getPaciente().getId());
            stmtInsert.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            stmtInsert.setString(4, consulta.getMotivo());

            stmtInsert.executeUpdate();

            conn.commit(); // Commit transaction
            return true;

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback on error
                } catch (SQLException ex) {
                    System.err.println("Erro ao realizar rollback: " + ex.getMessage());
                }
            }
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                } catch (SQLException ex) {
                    System.err.println("Erro ao restaurar auto-commit: " + ex.getMessage());
                }
            }
            // Close resources manually since we have multiple statements
            if (rs != null)
                rs.close();
            if (stmtCheck != null)
                stmtCheck.close();
            if (stmtInsert != null)
                stmtInsert.close();
            if (conn != null)
                conn.close();
        }
    }
}
