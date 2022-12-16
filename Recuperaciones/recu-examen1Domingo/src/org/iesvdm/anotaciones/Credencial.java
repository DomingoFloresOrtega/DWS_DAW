package org.iesvdm.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Logins.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Credencial {

	String usuario();
	String[] passwds();

}