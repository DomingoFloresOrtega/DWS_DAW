package es.iesvegademijas.anotaciones;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

	private String usuario;
	private String passwd;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void login() {
		Scanner teclado = new Scanner(System.in);
		String usuario, contraseña, mensaje;

		System.out.println("Introduzca su usuario:");
		usuario = teclado.nextLine();

		System.out.println("Introduzca su contraseña:");
		contraseña = teclado.nextLine();

		// Comprobar credenciales
		mensaje = comprobarCredencial(usuario, contraseña);
	}

	public static String comprobarCredencial(String usuario, String contraseña) {
		List<String> credenciales = new ArrayList<>();
	}

	public static Login cargadorContexto() {

		Login log = new Login();

		LoginAnotacion[] loginAno = Login.class.getAnnotationsByType(LoginAnotacion.class);

		return log;
	}
	
	

	/**
	 * Método que obtiene el hash de una password, por ejemplo, dado password =
	 * admin, devuelve:
	 * 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
	 * 
	 * @param password
	 * @return hash de encriptación de la password
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest digest;

		digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

		return bytesToHex(encodedhash);

	}

	private static String bytesToHex(byte[] byteHash) {

		StringBuilder hexString = new StringBuilder(2 * byteHash.length);
		for (int i = 0; i < byteHash.length; i++) {
			String hex = Integer.toHexString(0xff & byteHash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}

		return hexString.toString();

	}
}
