package interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Helper implements DAO_Costantes, DAO_metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(RUTA);
			System.out.println("Conexion ok");
		} catch (ClassNotFoundException e) {
			System.out.println(" no hay driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no se pudo conectar");
		}

		return con;
	}

	@Override
	public int desconectar(Connection con) {
		try {
			con.close();
			System.out.println("Conexion cerrada");
			return 0;// si es 0 se desconecto ok
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar");
			return -1;// si muestra -1 es porque no la ha cerrado
		}

	}

	@Override
	public int insertarPersona(int id, String nombre) {

		insertarPersona(new Persona(id, nombre));

		return 0;
	}

	@Override
	public int insertarPersona(Persona persona) {
		
		Connection con = conectar();
		
		int resultado= -1;

		try {
			String sql = //"insert into Personas (nombre) values (null,'Cristina')";
			"insert into " +TABLA_PERSONA + " values(null,'"+persona.getNombre()+"')";
			//System.out.println(sql);
			PreparedStatement pstm = con.prepareStatement (sql);
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		desconectar(con);
		return resultado;
	}

	@Override
	public int borrarPersona(int id) {
		borrarPersona(new Persona(id, ""));
		
		return 0;
	}

	@Override
	public int borrarPersona(Persona persona) {
		
		Connection con = conectar();
		
		int resultado = -1;
		
		try {
			String sql = "delete from " + TABLA_PERSONA+ " where " +PERSONA_ID + "=" + persona.getId()+ ""; 
			System.out.println(sql);
			PreparedStatement pstm = con.prepareStatement(sql);
			
			resultado = pstm.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		desconectar(con);
		return resultado;
	}

	@Override
	public Persona obtenerPersona(int id) {
		
		return null;
	}

	@Override
	public List<Persona> obtenerTodasPersonas() {
		
		Connection con = conectar();
		List<Persona> lista = new ArrayList<Persona>()
;		
		//ejecuta la query y devuelve un resultset
		try {
			String sql = "select * from " + TABLA_PERSONA+"";
			
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			
			//meter en la lista lo que hay en el resultset
			while(rs.next()) {
				Persona persona = new Persona();
				//crea persona vacia
				persona.setId(rs.getInt(PERSONA_ID));
				persona.setNombre(rs.getString(PERSONA_NOMBRE));
				
				lista.add(persona);
				
			}
		} catch (SQLException e) {
			
			System.out.println("No se pudo obtener");
			e.printStackTrace();
			lista = new ArrayList<Persona>();
		}
		
		desconectar(con);
		return lista;
	}

	@Override
	public int modificarPErsona(int id, String nombre) {

		Connection con= conectar();
		int resultado=-1;
		
		try {
			String sql="update "+TABLA_PERSONA
					+" set "+PERSONA_NOMBRE+"='"+nombre
					+"' where "+PERSONA_ID+"="+id+"";	
			System.out.println(sql);
			
			PreparedStatement pStmt = con.prepareStatement(sql);
			resultado=pStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		desconectar(con);

		return resultado;
	}

	@Override
	public int modificarPErsona(Persona persona) {
		Connection con= conectar();
		int resultado=-1;
		
		try {
			String sql="update "+TABLA_PERSONA
					+" set "+PERSONA_NOMBRE+"='"+persona.getNombre()
					+"' where "+PERSONA_ID+"="+persona.getId()+"";	
			System.out.println(sql);
			
			PreparedStatement pStmt = con.prepareStatement(sql);
			resultado=pStmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		desconectar(con);

		return resultado;
	}

}
