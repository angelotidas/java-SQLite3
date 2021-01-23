# Creación de bases de datos con SQLite en Java
Colección de métodos para realizar una conexión a una base de datos SQLite3 previamente creada, creación de tablas, inserción, actualización y borrado de registros.

# Requisitos previos
1- Tener instalado SQLite -> <a href="https://www.sqlite.org/download.html">SQLite</a>

2- Tener el driver para la conexión con Java (desde eclipse en este caso) -> <a href="https://jar-download.com/artifacts/org.xerial/sqlite-jdbc/3.20.1/source-code">JDBC SQLite</a>

3- Tener una base de datos creada con alguna tabla y un par de filas por tabla. Algunos ejemplos para la creación de una base de datos, tablas e inserts desde consola:

  - Crear la base de datos -> "sqlite3 baseDePrueba.db"

  - Crear una tabla -> "create table departamentos (
               id_dpto TINYINT (2) NOT NULL PRIMARY KEY,
               nombre_dpto VARCHAR (15),
               loc_dpto VARCHAR (15)
               );"

  - Crear una tabla -> "create table empleados (
              emp_id INT (2) NOT NULL PRIMARY KEY,
              apellido VARCHAR (10),
              oficio VARCHAR (10),
              fecha_alta DATE,
              salario FLOAT,
              comision FLOAT,
              dpto TINYINT (2) NOT NULL REFERENCES departamentos(id_dpto)
              );"

- Inserción de datos -> "INSERT INTO departamentos VALUES (10, 'ADMINISTRACION', 'MADRID');"

- Inserción de datos -> "INSERT INTO empleados VALUES (7010, 'DURO', 'TRANSPORTISTA', '10/02/98',
              1200.50, 5.5, 10);"
