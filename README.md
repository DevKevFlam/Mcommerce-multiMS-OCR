# Mcommerce-multiMS-OCR

Activité du tuto "Optimisez votre architecture Microservices" de OpenClassRoom  

### Ordre de lancement des services:  
1.config-server  
2.eureka-server  
3.zuul-server  
4.microservice-produits  
5.microservice-commandes  
6.microservice-paiement  
7.microservice-expedition  
8.clientui  
  
### Affichage des Exceptions  
Il y a un template "error.html" pour mettre en forme les retours "Whitelabel Error Page" et ainsi avoir un affichage plus jolie.  
Si vous voulez récupérer l'affichage des exceptions standard de feign il vous suffit de supprimer le template du projet.  

### Config applications.properties:  
les applications.properties sont extarnalisés grâce a spring cloud sur le git: 
  - https://github.com/DevKevFlam/mcommerce-config-repo  
  
### Projet  
le projet final est disponible sur :  
  - https://github.com/DevKevFlam/McommerceActivites  


