package org.iesvdm.anotaciones;

@Credencial(usuario = "usuario1", passwds ={"1234", "admin1234",}) 
@Credencial(usuario = "usuario2", passwds={"admin", "root"}) 
public class LoginTest {

	/* No me da tiempo
	public static Login cargadorContexto() {
		
		Login l = new Login();
		
		Credencial[] credenciales = Login.class.getAnnotationsByType(Credencial.class);
		
		for (Credencial c : credenciales) {
			l.setUsuario(c.usuario());
			l.setPasswd(c.passwds());
			l.aniadirEmpleado(tecnico);
			}
		}
		
		return em;
	}
	
	public static void main(String[] args) {
		Login login = LoginTest.cargadorContexto();
		
		System.out.println(login.toString());
	}
	*/

}
