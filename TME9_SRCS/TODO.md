Pour tout les /admin/xxx
    - Si acces par le port utilisateur, renvoie erreur 404


- /admin/airports

  - POST ou PUT -> ajoute un aeroport
  - GET -> recupere la liste des aeroport desservis par la compagnie

- /airports

  - POST -> 405

  - GET -> recupere la liste des aeroport desservis par la compagnie

- /admin/aircrafts

  - POST ou PUT -> ajoute un avion
  - GET -> recupere la liste des avions détenu par la compagnie

- /aircrafts

  - POST -> 405

  - GET -> recupere la liste des avions détenu par la compagnie

- /admin/flights

  - POST ou PUT -> ajouter un nouveau vol à la base de données. 
**Attention un seul vol est attendu dans la requête (et non une collection).**

    Le serveur renvoie une réponse **HTTP 412** *Precondition Failed* (et par conséquent, ne modifie pas la base) si une des conditions suivantes est remplie :

    - il existe déjà un vol du même identifiant dans la base
    - l’aéroport de départ n’existe pas ou n’est pas desservi par la compagnie
    - l’aéroport d’arrivée n’existe pas ou n’est pas desservi par la compagnie
    - l’avion est déjà utilisé dans un autre vol dont les horaires entrent en conflit (on peut savoirsi deux vols entrent en conflit grâce à la méthodeisInConflictde la classeFlight).

  - GET -> récupérer la liste des vols existant dans la base.

- /flights

  - POST -> 405

  - GET -> récupérer la liste des vols existant dans la base.

- /admin/flight/<id_vol>/passenger

  - POST -> ajoute un passager à un vol donné. Le numéro de place du passager se renseignera grâceà la partie query de l’URI avec le paramètreplace.

- /admin/flight/<id_vol>/passengers

  - GET -> obtenir la liste de tous les passagers d’un vol donné

- /admin/flight/<id_vol>/place

  - GET -> obtenir la place la place d’un passager dont le nom et le prénom sont passés dans lapartie query de l’URI (paramètre firstname pour le prénom, paramètre lastname pour le nom).


! les classes du packages ressources sont censée etre statiques