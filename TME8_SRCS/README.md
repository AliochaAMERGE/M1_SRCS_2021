# PREPARATION DU TME 8 :

## PARTIE 1 : Installation d’un serveur d’application
- récupérer les sources pour le server glassfish :
```
wget  http://download.oracle.com/glassfish/5.0/release/glassfish-5.0.zip
unzip glassfish-5.0.zip
```
puis `rm glassfish-5.0.zip` pour retirer l'archive.

- tout d'abord, il est primordiale d'utiliser le java jdk 8 sinon cela entraine un NullPointeurException.
Pour ce faire, dans le bashrc, j'ai du rajouter les lignes suivantes :

```bash
# GlassFish TME 8 SRCS M1 SAR
# forcer l'utilisation de jdk 8, surement à retirer à la fin du TME
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/"
export PATH="/usr/lib/jvm/java-8-openjdk-amd64/jre/bin/:$PATH"
# ajouter GlassFish au path
GLASSFISH_HOME=/home/aliocha/Workspace/M1S2/SRCS/libraries/glassfish5
PATH=$PATH:$GLASSFISH_HOME/bin
```
Ne pas oublier de commit les changements : `source ~/.bashrc`

Autre solution :
`sudo update-alternatives --config java`

- Question 3 : 

On vérifie que les ports que nous utiliserons sont libres : 

`netstat -na | grep tcp | grep LISTEN | grep 8080`
`netstat -na | grep tcp | grep LISTEN | grep 8181`

qui ne doit rien afficher. Si le port est déjà utilisé, modifiez le fichier
`$GLASSFISH_HOME/glassfish/domains/domain1/config/domain.xml`

- Question 4 :
  
On démarre le serveur : 
`asadmin start-domain`
Si commande not found est indiqué (et qu'il propose d'installer quelque chose), c'est que le path de GlassFish est mal indiqué. Attention, ne pas installer le programme proposé.

Si NullPointeurException est levée (entre autre) c'est que la version du jdk n'est pas bonne : verifier avec `java -version`

- Question 5 :

On vérifie le port d'écoute de GlassFish
`asadmin get "configs.*" | grep -e "port=[0-9]\+$"` 
renvoie plusieurs port, il faut les tester avec `localhost:<num port>` dans un navigateur. Le port que nous cherchons renvoie sur une page de configuration de serveur GlassFish.

- Question 6 :

Le port correspondant était : `http://localhost:8080/`

- Question 7 :

On lance la base de donnée SGBD fournie avec le serveur GlassFish.
`asadmin start-database --dbhome $HOME/MyDB`

- Question 8 :
  
Tout marche jusque la, on peut tout éteindre car le serveur sera lancé via eclipse.

`asadmin stop-database`
`asadmin stop-domain`

## PARTIE 2 : Utilisation de ~~VSCode~~ Eclipse JavaEE

- Téléchargement de Eclipse IDE for Enterprise Java and Web Developers

https://www.eclipse.org/downloads/packages/

Ne pas partager le eclipse-workspace entre différents eclipse
Verifier les proxy si sur réseau de la fac

- Pour une meilleure ergonomie, ouvrir la perspective JavaEE :
Allez dans Window → Perspective → Open Perspective → Other...
Cliquez surJava E

## PARTIE 3 : Configuration de GlassFish sous Eclipse

https://www.youtube.com/watch?v=7a1XR0g7cTY&t=1s

- Créer un serveur :
  
File -> New => Other ...
    Choisir Server -> Next (chez moi je ne voyais pas la rubrique GlassFish)
    
    Dans la partie server type sélectionnez GlassFish Tools dans la rubrique Oracle puis Next > (ceci peut prendre un moment)
    
    Suivez le processus d’installation (qui doit potentiellement aboutir à un redémarrage d’eclipse,qui peut également prendre un moment)

NB : l'installation se fait en "tache de fond" plus ou moins, mais ce n'était pas très visible chez moi, laisser tourner eclipse un moment pour voir si l'installation se fait ou non.

- Si ça ne marche pas, il est possible de l'installer en allant dans :

help -> install new Software -> add : 
**Name :**  GlassFish
**Location :** https://download.eclipse.org/glassfish-tools/1.0.1/repository/

(la deuxieme option à marcher chez moi, contrairement à la première)

De plus j'ai du réinstaller un jdk8 pour qu'il l'accepte lors de la création du server : 
`usr/lib/jvm/java-8-openjdk-amd64`

Ensuite File -> New -> Server -> GlassFish

GlassFish location : le chemin vers /glassfish5/glassfish (télécharger précedemment)

java location : le lien vers le java installer juste avant (ou un qui marche deja ) 
`/usr/lib/jvm/java-8-openjdk-amd64`

Ensuite on créer le server, on vérifie si il marche

## PARTIE 4 : Application JavaEE sous Eclipse

Marche pas :
https://netbeans.apache.org/kb/docs/javaee/entappclient.html

