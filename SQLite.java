import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLite 
{
	//Variables para la conexión
	private Connection conexion = null;
	private Statement sentencia = null;
	private String nombreTabla;

	//Método para conectar
	public void conectar()
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:C:\\ruta-de-tu-base-de-datos\\baseDePrueba.db");
			System.out.println("Éxito al conectar.");
		} 
		catch (Exception e) 
		{
			System.out.println("Error al conectar.");
		}
	}	
	
	//Método para crear una tabla
	public void crearTablaNueva(String nombreTabla) throws SQLException
	{
		
		this.nombreTabla = nombreTabla;
		String sentenciaSQL = "CREATE TABLE " + nombreTabla + " ( "
								+ "ID INT PRIMARY KEY NOT NULL,"
								+ "TITULO TEXT NOT NULL,"
								+ "PRECIO INT NOT NULL"
								+ ");";

		
		try 
		{
			sentencia = conexion.createStatement();
			sentencia.execute(sentenciaSQL);
			sentencia.close();
			conexion.close();
			System.out.println("Tabla creada correctamente.");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Método para insertar valores en una tabla
	public void insertarValores(String nombreTabla, int id, String titulo, int precio) throws SQLException
	{
		
		this.nombreTabla = nombreTabla;
		int idLibro = id;
		String tituloLibro = titulo;
		int precioLibro = precio;
		
		String sqlInsert = "INSERT INTO " + nombreTabla
							+ " VALUES (" + idLibro + ",'"
							+ tituloLibro + "',"
							+ precioLibro + ");";
		
		try 
		{
			sentencia = conexion.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			conexion.close();
			System.out.println("Valores insertados con éxito.");
		} 
		catch (Exception e) 
		{
			System.out.println("Error al insertar datos.");
			e.printStackTrace();
		}
							
	}
	
	//Método para leer valores de la tabla
	public void obtenerValores(String nombreTabla) throws SQLException
	{
		
		sentencia = conexion.createStatement();
		String consultaSql = "SELECT * FROM " + nombreTabla + ";";
		try 
		{
			ResultSet resultadoConsulta = sentencia.executeQuery(consultaSql);
            System.out.println("Impresión de nombres de campos y contenido");
			while(resultadoConsulta.next())
			{
                int id = resultadoConsulta.getInt("ID");
                String tituloLibro= resultadoConsulta.getString("TITULO");
                int precioLibro = resultadoConsulta.getInt("PRECIO");
                System.out.println("ID: " + id + " TITULO: " + tituloLibro + " PRECIO: " + precioLibro);
			}
			resultadoConsulta.close();
			sentencia.close();
			conexion.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Método para actualizar los datos de una tabla
	public void actualizarDatos(String nombreTabla, int id, String titulo, int precio)
	{
		this.nombreTabla = nombreTabla;
		int idLibro = id;
		String tituloLibro = titulo;
		int precioLibro = precio; 
		
		try
		{
			sentencia = conexion.createStatement();
			String sqlUpdate = "UPDATE " + nombreTabla + " SET TITULO ='" + tituloLibro + "', PRECIO=" + precioLibro + " WHERE ID=" + idLibro + ";";
			sentencia.executeUpdate(sqlUpdate);
			sentencia.close();
			conexion.close();
			System.out.println("Datos actualizados.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("No se han actualizado los datos.");
			// TODO: handle exception
		}
	}
	
	public void eliminarRegistro(String nombreTabla, int id)
	{
		this.nombreTabla = nombreTabla;
		int idLibro = id;
		
		try
		{
			sentencia = conexion.createStatement();
			String sqlDelete = "DELETE FROM " + nombreTabla + " WHERE ID=" + idLibro + ";";
			sentencia.executeUpdate(sqlDelete);
			sentencia.close();
			//conexion.close();
			System.out.println("Se ha eliminado el registro.");
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
