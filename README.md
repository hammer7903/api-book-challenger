# Challenger
# Para instalar y correr en docker-container
docker build -t api-book-challenge .
docker run --name api-book-challenge -p 8080:8080 api-book-challenge:latest

# En vm Option agregar el profile como local
-Dspring.profiles.active=local

# Se realizo con java 11

# Se realizo con Maven
# Para el el interes simple se aplico la formula
I = Prt

# Deben tener instalado lombok

# La url del API Swagger es la siguiente
http://localhost:8080/swagger-ui/

#Se agrega un postman que se encuentra en la carpeta Postman end-point y environment para poder generar el token 
#el cual esta con spring security y oauth2
#el clientId es appclient y el secret es test123 Esto esta configurado en el postman adjunto
#Asi como tambien la variable para obtener el token y pasarlos a los demas
#Servicios con {{token}} 
#los servicios del postman son los siguientes:

1. Create-user => Para la creeacion de un nuevo usuario
2. Login => Para el logindel usuario aqui van el client_id, secret, asi como el usuario y el password del usuario del usuario logeado
3. Search-books => para realizar la busquedad de libros con el api de google del usuario logeado
4. Create-wish-list => Para crear una nueva lista de deseos del usuario logeado
5. Delete-wish-list => Para eliminar una lista de beseos del usuario logeado
6. Get-all-wish-list => Para obtener todas listas de deseos del usuario logeado
7. Create-wish-item-list => Para agregar un book por id a a lista de deseos
8. delete-wish-item => Para eliminar un book por id de la lista de deseos
9. Get-wish-item => Para eliminar un book de la lista de deseos.