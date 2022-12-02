Crea un proyecto web dinámico, para JSP & Servlets sobre Servidor Web Tomcat, llamado web_empleados y sobre la base de datos adjunta de empleados en mysql implementa lo siguiente.

El modelo de base de datos empleados contiene 2 tablas: departamento y empleado

1. Crea los servlet's y jsp's adecuados junto con el mapeo de las rutas de peticiones http que consideres, también, adecuadas a estos servlets para tener las siguientes funcionalidades CRUD:

Departamentos:
Listar los departamentos + panel de operaciones CRUD con todas las operaciones preparadas (sólo funcionales las que se pidan). 20%
Operación CRUD de crear departamento. 10%
Empleados:
Operación CRUD de editar empleado (operación aislada no hace falta  el listado + panel de operaciones) 20%
2. Muestra en el listado de departamentos el número de empleados que tiene cada departamento. 20%
3. Implementa en el listado de departamentos un buscador por rango de presupuesto actual disponible (presupuesto - gastos)  por entrada de horquilla de dos valores. Es decir, se tendrá una entrada para envl valor inferior y otra entrada para el valor superior de la horquilla del presupuesto actual disponible mostrándose como resultado los departamentos que estén dentro de la horquilla. (20%)
4. Implementa la ruta POST /convertir-a en la que se envían los parámetros:

user = <nombre-usuario>
rol = <usuario | administrador>
token-convertir-a = T7R7ROD4jyD0os6pmzOwEfNsLt/WTVQeHYRWOJEI2aA=


de modo que si se recibe esta petición crea una sesión con los datos de nombre-usuario y el rol, siempre y cuando el token-convertir-a coincida con T7R7ROD4jyD0os6pmzOwEfNsLt/WTVQeHYRWOJEI2aA=
  
Para testearlo lanza la petición desde el navegador con un formulario html independiente. 

Después de ejecutarse la petición se redirigirá al listado de departamentos.


En el listado de departamento se deben ocultar las operaciones de editar y borrar si no se es perfil de administrador. 10%
