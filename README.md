# git-class-back

## Comandos útiles


Permite agregar todos los archivos del proyecto para guardarlos en git y github

`Git add . `

Permite confirmar los cambios y agregar un mensaje que indique que procesos se realizaron

`git commit -m ""`

Permite cargar los cambios a github para que queden disponibles online

`git push`

Permite conectarse con la llave a los servidores de Oracle, es importante abrir el gitbash en la carpeta en la que se encuentre la llave
y una vez allí registrar el nombre de la llave en lugar de key.key, si se usó ubuntu no debería cambiar el usuario pero si la ip según la que corresponda a cada uno

`ssh -i key.key ubuntu@212.1.4.1`

Descargar el proyecto en nuestra máquina o en la máquina virtual de Oracle Cloud
(para obtener el link debemos ir a github en el botón verde, importante que el repositorio sea público para que nos deje descargar el proyecto)

`git clone https://github.com/xxxxx/xxxxx.git`

Permite visualizar los contenidos de una carpeta en la máquina virtual de Oracle

`ls`

Permite ingresar a una carpeta, se debe reemplazar xxxxx por el nombre de la carpeta a la cual se desea ingresar.

`cd xxxxx`

Permite copiar todos los archivos de la carpeta actual en donde está el usuario y dejarlos en la carpeta de apache que estará escuchando cada vez que se llame la IP del servidor.

`sudo cp ./* /var/www/html`

Permite abrir el puerto 8080 y el 80 para que sean accesibles desde Internet

```
sudo iptables -I INPUT 6 -m state --state NEW -p tcp --dport 8080 -j ACCEPT
sudo iptables -I INPUT 6 -m state --state NEW -p tcp --dport 80 -j ACCEPT
sudo netfilter-persistent save
```

Permite compilar el proyecto de Java para que se pueda ejecutar en el servidor (normalmente en nuestra máquina local netbeans es el encargado de realizar este proceso)

`mvn clean package -DskipTests`

Permite navegar a la carpeta en donde se compila el proyecto según el paso anterior

`cd target`

Permite ejecutar la aplicación de Java en el servidor, una vez hecho esto la aplicación es accesible desde la ip de nuestro servidor:8080 (importante reemplazar las xxxx con el nombre del archivo jar que se encuentra en la carpeta)
La & al final es para que el proyecto se ejecute en segundo plano 

`sudo java -jar -Dspring.profiles.active=prod xxxx.jar &`

Permite la copia desde mi carpeta local a mi servidor directamente según lo visto en clase:

`scp -i nuestrallave nuestroarchivo ubuntu@nuestraip`

ejemplo para subir un archivo llamado saludo.txt en la carpeta home(la que nos muestra apenas nos logueamos con ssh) por eso se pone un . despúes de los dos puntos:

`scp -i ssh-key-2022-09-20.key saludo.txt ubuntu@193.122.145.65:.`

Si quisieramos copiar el archivo a otro lugar deberíamos poner la dirección del otro lugar por ejemplo /var/www/html

`scp -i ssh-key-2022-09-20.key saludo.txt ubuntu@193.122.145.65:/var/www/html`

Comando para conocer que aplicación está usando el puerto 8080 Java

`sudo lsof -i :8080`
->pid

Comando para detener el proceso del puerto 8080
sudo kill -9 ####

Para borrar la base de datos
`drop database db_moto2;`

Para crear la base de datos
`create database db_moto2;`