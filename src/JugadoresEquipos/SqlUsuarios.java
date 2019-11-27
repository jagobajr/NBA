package JugadoresEquipos;

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
		
		String sql ="INSERT INTO usuarios (idUsuario, usuario, password, correo, dinero) VALUES (?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getUsuario());
			ps.setString(3, usr.getContra());
			ps.setString(4, usr.getCorreo());
			ps.setInt(5, usr.getDinero());
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

			String sql ="SELECT idUsuario, usuario, password, id_tipo FROM usuarios WHERE usuario = ? LIMIT 1";

	        try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, usr.getUsuario());
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                if (usr.getContra().equals(rs.getString(3))) {
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

        String sql = "SELECT count(idUsuario) FROM usuarios WHERE usuario = ?";

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

        // Patr�n para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }
    
    public int dameUltimoRegistro() {
    	Connection con = getConexion();
    	 PreparedStatement ps = null;
         ResultSet rs = null;
    	 String sql = "SELECT max(idUsuario) FROM usuarios";

         try {
             ps = con.prepareStatement(sql);
             rs = ps.executeQuery();

             if (rs.first()) {
                 return rs.getInt(+1);
             }

            

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
		return 0;

         }
    
    

     	
    

}

