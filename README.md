# Biblioteca
Sistema de una Biblioteca

### Primera parte (descarga):
- Este es un proyecto de: [Sistema bibliotecario](https://github.com/Javi-vm97/Biblioteca.git "Sistema bibliotecario"), al ingresar en el link anterior, se abrira el repositorio del proyecto.
- Una vez en el repositorio, dar clic a la opcion "Code" o "codigo", se mostrara un menu de opciones en el cual, selecciona la opcion "Download ZIP".
- Al descargar el archivo ZIP, se debe descomprimir en alguna ruta(opcional), en donde, al terminar de descomprimir se mostrara la carpeta "Biblioteca", la cual contiene las clases y objetos del proyecto, y tambien se verá el archivo "Biblioteca.sql", el cual contendra todos los datos almacenados por el proyecto.

### Segunda parte (IDE):
- Para poder abrir el proyecto, es necesario tener un IDE, preferentemente sea: [Apache Netbeans IDE](https://netbeans.apache.org/download/index.html "Apache Netbeans IDE").
- Para importar el proyecto, una vez dentro del IDE, dar clic en la opcion "File" o "Archivo" y posteriormente a la opcion "add project" o "agregar projecto".
- Al terminar de importar el projecto, se mostraran las diferentes paqueterias, librerias, clases y objetos del programa.
- Para que el projecto pueda compilar sin problema, es muy necesario agregar la libreria "MySQL JDBC".
- Para agregar dicha libreria, dentro del IDE, en el projecto "biblioteca, ir a la opcion libreria >> add library y selecciona la opcion Mysql_jdbc.
- Dado caso no se tenga la libreria, es necesario descargarla desde: [MySQL connector java JDBC](https://dev.mysql.com/downloads/connector/j/ "MySQL connector java JDBC").
- Al descargar el archivo controlador, se agrega a traves de la opcion libreria >> add JAR/folder>>Selecciona el archivo "MySQL connector java JDBC", y con ello ya se tendra el controlador para la base de datos.

### Tercera parte (Base de datos):
- Para lograr abrir el archivo Biblioteca.sql, es necesario tener un gestor de base de datos, en este proyecto se ocupo de: [XAMMP / PHPMyAdmin](https://www.apachefriends.org/es/index.html "XAMMP / PHPMyAdmin"), de igual manera puede ocuparse tambien: [MySQL para Windows](https://dev.mysql.com/downloads/installer/ "MySQL para Windows")
- Al tener el gestor instalado, solo hay que importar el archivo "Biblioteca.sql", y con ello se podra ver los datos almacenados por el proyecto.

### Cuarta parte (Compilación):
- En caso de que el proyecto no muestre ningun error, se podra compilar para lograr ver el entorno. Para ello, el la paqueteria "Vista" en la clase  "Vista", dar clic derecho sobre la clase y la opcion "run" o "run file". Se desplegara la ventana principal en donde se muestra las opciones que tiene el aplicativo.
- Dado caso el proyecto muestre algun error en la clase, código, favor de comentarlo via correo electronico: javiervidalmiguel@gmail.com.

### Quinta parte (operaciones):
- El aplicativo consta de dos opciones "Categoria" y "Libros", En la opcion CATEGORIA, se aprecia una ventana en donde se solicita agregar un ID  y un Nombre para la dicha categoria.
- El botón Crear, creará la categoria y la mostrara en la tabla de la parte inferior.
- El botón Ver/Editar, para ello, tendras que seleccionar una fila de la tabla y los datos apareceran en los campos de ID y Categoria, en los cuales podras editar dichos campos, y para registrarlo tan solo le das al botón "Crear".
- El botón Listar, Mostrara los datos agregados recientemente en la tabla.
- El botón Actualizar, Verificara que los datos agregados recientemente se muestren en la tabla.
- El botón Borrar, Deberas seleccionar una fila previamente para usar este boton, dicha fila se eliminara una vez se haya seleccionado y apretado el boton, cabe mencionar que el botón borrar, elimina las filas por ID, es decir, si el ID se repite en diferentes filas, se eliminaran todas las filas con el mismo ID.
- El botón Nuevo, creara un nuevo elemento una vez le hayas escrito en los campos de ID y categoria previamente.
- El botón Salir, su funcion es salir de programa.
- Para la opción de LIBROS, los campos a ingresar son ID, Nombre y autor, los botones cumplen la misma función que en la opcion Categoria, a excepcion del boton Buscar.
- El botón Buscar, analizara el dato escrito en el campo anterior y lo filtrara por ID, Titulo, Autor o Categoria.
- Al finalizar solo se da clic al botón Salir.

### Capturas de Pantalla:
> Ventana Categoria.
![](https://github.com/Javi-vm97/Biblioteca/blob/main/Categoria.png)

> Ventana Libros.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/Libros.png)

> Boton Eliminar.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/eliminarcat.png)

> Boton Actualizar.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/CatActualizar.png)


> Boton Editar.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/ver%20editar.png)


> Boton Crear.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/crear.png)


> Boton Listar.

![](https://github.com/Javi-vm97/Biblioteca/blob/main/listar.png)



### Autor:
- [Javier Vidal M.](https://github.com/Javi-vm97 "Javier Vidal M.")



### Licencia
  Free
  
  
