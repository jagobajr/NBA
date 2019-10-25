package NBA.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class SqlUsuarios extends ConexionRegistro{
	
	public boolean registrar (Usuarios usr) {
		
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql ="INSERT INTO usuarios (usuario, password, correo) VALUES (?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usr.getUsuario());
			ps.setString(2, usr.getContraseña());
			ps.setString(3, usr.getCorreo());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	  public boolean login(Usuarios usr) {
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConexion();

			String sql ="SELECT id, usuario, password, id_tipo FROM usuarios WHERE usuario = ? LIMIT 1";

	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, usr.getUsuario());
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                if (usr.getContraseña().equals(rs.getString(3))) {
	                    usr.setId(rs.getInt(1));
	                    usr.setIdTipo(rs.getInt(4));
	                    return true;
	                } else {
	                    return false;
	                }
	            }

	            return false;
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, e.toString());
	            return false;
	        } finally {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                JOptionPane.showMessageDialog(null, e.toString());
	            }
	        }
	    }

	
	public int existeUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    public boolean esEmail(String correo) {

        // Patrï¿½n para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }



}
