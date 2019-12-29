package main;

import java.sql.ResultSet;
import java.sql.SQLException;



public void cargarMercadoFichajes {
	
	
	st=BasesDeDatos.getStatement();
	modelo.clear();
	precios.clear();
	mercadoId.clear();
	
	String sentencia="select * from mercadodefichajes";
	
	try {
		ResultSet rs=st.executeQuery(sentencia);
		
		while(rs.next())
		{
			
			modelo.addElement(rs.getString("nombre"));
			precios.add(rs.getInt("precio"));
			mercadoId.add(rs.getString("idJugador"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	repaint();

}

}