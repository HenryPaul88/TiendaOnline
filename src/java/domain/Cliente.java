package domain;

public class Cliente {

	private int codigo_cli;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String direccion;
	private String email;
	private String contrasena;
	

	public Cliente(int codigo_cli, String nombre, String apellidos, int telefono, String direccion, String email,
			String contrasena) {
		this.codigo_cli = codigo_cli;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.contrasena = contrasena;
	}
	

	
	public Cliente(int codigo_cli) {
		this.codigo_cli = codigo_cli;
	}



	public int getCodigo_cli() {
		return codigo_cli;
	}


	public void setCodigo_cli(int codigo_cli) {
		this.codigo_cli = codigo_cli;
	}


	public Cliente() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


}
