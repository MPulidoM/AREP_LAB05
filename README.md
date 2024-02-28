# LABORATORIO 05 - MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER
En este laboratorio, se creo una pequeña aplicación web utilizando el micro-framework de Spark Java y Docker.Se comezo por creando un proyecto en Java usando Maven y agregando las dependencias necesarias para Spark Java. Luego, 
se creo una clase principal que inicie un servidor web en un puerto específico y defina un único punto final que devuelva la cadena "¡Hola Docker!" cuando se acceda a él.

Una vez se tuvo la funcionamiento, creamos un Dockerfile que defina las instrucciones para crear una imagen de Docker para nuestra aplicación. Utilizamos la imagen base openjdk:8 y copiamos las clases compiladas y las dependencias 
dentro de la imagen. A continuación, definiremos el comando para ejecutar nuestra aplicación.

Después de construir la imagen de Docker, se ejecuto el contenedor y se exporto el puerto de la aplicación en la máquina host. Luego, creamos varias instancias del contenedor, cada una con un nombre diferente y mapeada a un puerto 
diferente en la máquina host.

Finalmente, crearemos un archivo Docker Compose que defina un servicio web y un servicio MongoDB. Construimos el servicio web utilizando el Dockerfile y ejecutando ambos servicios en modo detrás del escenario.

Además, modificaremos nuestro proyecto para publicar servicios REST que realicen los siguientes cálculos:

* Seno (sin)
* Coseno (cos)
* Determinar si una cadena es un palíndromo
* Retornar la magnitud de un vector real de dos dimensiones, es decir reciba dos parámetros reales.

# Instalación 
## Herramientas 
- [MAVEN](https://maven.apache.org) : Para el manejo de las dependecias. 
- [GIT](https://git-scm.com) : Para el manejo de las versiones.
- [JAVA](https://www.java.com/es/) : Lenguaje de programación manejado.
- [DOCKER](https://www.docker.com/): Contenedor

# Arquitectura

La clase **SparkWebServer** es el punto de entrada principal de la aplicación. Establece el servidor web Spark Java y define dos puntos finales: uno para renderizar la forma HTML y otro para manejar la presentación de la forma. Cuando se envía la forma, los valores de entrada seleccionados y la operación se envían al punto final /calcular como parámetros de consulta. La clase **SparkWebServer** luego delega el cálculo al método apropiado en la clase MyAppService según la operación seleccionada.

La clase **MyAppService** contiene la implementación de las operaciones matemáticas. Proporciona cuatro métodos: *getCos, getSin, isPalindrome y getMagnitude*. Los métodos getCos y getSin toman una representación de cadena de un número en radianes y devuelven el coseno y el seno de ese número, respectivamente. El método isPalindrome toma una cadena y devuelve si es un palíndromo o no. El método getMagnitude toma dos representaciones de cadena de números y devuelve la magnitud del vector de dos dimensiones con esos componentes.

## Para correr el laboratorio 

+ Se clona el repositorio en una máquina local con el siguiente comando:
  
    ```
    git clone https://github.com/Juc28/AREP_LAB05.git
    ```

+ Entrar al directorio del proyecto con el siguiente comando:
    ```
    cd AREP_LAB05
    ```
   ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/2a0c0599-8df6-49dd-ae1a-8780c20a954c)


+ Compilar el proyecto con el siguiente comando:

  ```
  mvn clean install
  ```
+ Para ejecutar el proyecto con el siguiente comando:

    ```
    java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer
    ```

    ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/45fb4b7a-7ef3-4bf4-b6f1-0ae1194cc5b7)
  
# Pruebas 
+ Abrir en el navegador:
   ```
  http://localhost:4567/formulario
  ```
- Al abrir:
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/bbc6c0df-bc36-4532-8d60-981c151b5eea)

- Para Coseno: 

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/1f44e0b1-2d17-4e69-88ff-4b4dfe0cae10)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/5c8dab86-c6ea-45e9-954f-8090cd0a73b7)

- Para Seno: 
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/057f5206-eaf4-4f9c-a140-3f8c0a40e879)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/d7d2ee74-41eb-4ccd-bf7b-c9e52346c377)


- Para Palíndromo:
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/aec5ee9e-78b9-41c2-aeda-01ca5dbfe85a)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/67409441-29b9-4e7f-b2ad-9ac35549bc66)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/674e7b5d-7b04-4233-b87d-ff47f715f6df)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/51f9a20c-6b7f-43b9-a7a1-a769f107a929)

- Para Magnitud: 
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/6b466606-e37c-4bc2-9cc2-84954f9d49a8)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/5faefc7a-f202-4aed-a190-a473ef3ad1ee)


## Para correr el laboratorio Docker

Se encuntra en un repositorio de Docker Hub que es:

  [juc08/laboratorio05](https://hub.docker.com/repository/docker/juc08/laboratorio05/general)

### Para poder ejecutar el contenedor es de la siguiente forma:

+ Abrir docker en el computador:

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/0a3fbb62-4967-4556-a057-cbad31527f1c)

+ En la consola colocar alguno de los siguientes comandos : 
   ```
   docker run -d -p 34000:4600 --name prueba juc08/laboratorio05:latest
   ```
   ```
   docker run -d -p 34001:4600 --name prueba2 juc08/laboratorio05:latest
   ```
  ```
  docker run -d -p 34002:4600 --name prueba3 juc08/laboratorio05:latest
  ```
    ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/79752161-fcfd-4cbd-9aea-f0514d6d43c1)



+ Después de correrlo en Docker va a aparecer así:

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/7cfd8297-cc79-460b-b9f9-4f21b8e9d4f5)


+ Abre tu navegador web favorito e ingresa la dirección y depende cual comado se uso cambia el pueto:
  ```
  http://localhost:34000/formulario
  ```
  
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/a4d4b8cc-c87e-4f11-bfbc-b886b44ed809)
  
   ```
   http://localhost:34001/formulario
   ```
   
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/6e479d4a-6467-40c7-9633-4097063c961e)


# Pruebas 

- Para Coseno: 

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/ad8a08ab-1fee-4518-959f-cd20dd29e94e)
  
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/738c5f08-9054-426e-a994-eeb01084a49d)


- Para Seno: 
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/283d0877-fcf6-4f41-b0be-5bf1eae8f24b)
  
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/9c9a2a71-b41c-4814-bc34-ba22756efa98)


- Para Palíndromo:
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/8175c8c6-1002-496d-9bad-b4ff6f219dac)
  
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/8443c4d5-abba-405e-a8ef-dec4ab526ece)
  
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/ab7b8eb5-57f0-4338-8b95-a07b4798edfe)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/07dc8731-b7fe-48c5-b24e-deae82fe7639)

- Para Magnitud:
  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/54a6aff1-f2d9-4847-926e-e9f4e62f58db)

  ![imagen](https://github.com/Juc28/AREP_LAB05/assets/118181224/8696f551-03a6-4bd0-abf9-6227c97e66ab)


# Autor 
Erika Juliana Castro Romero [Juc28](https://github.com/Juc28)
