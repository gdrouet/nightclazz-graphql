## Développons une API GraphQL

### Objectif

L'objectif de cet exercice est de créer une API GraphQL.
Cette API sera implémentée côté serveur à l'aide de l'implémentation de référence `graphql-js`.
Côté client, l'API sera appelée grâce à la stack `Apollo` soit en `Javascript` soit en `Java`.

### Pré-requis

* Avoir une version récente de `NodeJS` installée sur votre poste
* Pour ceux souhaitant implémenter un client `Java`, avoir le `JDK 8`
* Votre IDE favoris

### Le sujet

On souhaite être capable de rechercher une adresse en France et afficher l'antenne mobile la plus proche.
On doit pouvoir filtrer en fonction: 

* de la génération (`2G`, `3G`, `4G`)
* de l'aménageur (`ORANGE`, `BOUYGUES TELECOM`, `SFR`, `FREE`)

#### Sources de données

Deux API publiques issues de l'open data pourront être utilisées :

* https://api-adresse.data.gouv.fr/search/ qui permet de rechercher une adresse avec ses coordonnées GPS
* https://data.anfr.fr/api/records/1.0/search/ qui permet de rechercher une antenne la plus proche d'un point de référence

Examples de recherche d'adresse :

> curl -i https://api-adresse.data.gouv.fr/search/?q=6%20rue%20jean%20roisin

Résultat

```json
{  
   "limit":5,
   "features":[  
      {  
         "geometry":{  
            "type":"Point",
            "coordinates":[  
               3.062103,
               50.636488
            ]
         },
         "properties":{  
            "id":"ADRNIVX_0000000358705348",
            "label":"6 Rue Jean Roisin 59800 Lille",
            "x":704400.9,
            "citycode":"59350",
            "type":"housenumber",
            "street":"Rue Jean Roisin",
            "city":"Lille",
            "postcode":"59800",
            "housenumber":"6",
            "context":"59, Nord, Hauts-de-France (Nord-Pas-de-Calais)",
            "importance":0.3193,
            "score":0.8472090909090909,
            "name":"6 Rue Jean Roisin",
            "y":7059949
         },
         "type":"Feature"
      }
   ],
   "query":"6 rue jean roisin",
   "attribution":"BAN",
   "licence":"ODbL 1.0",
   "type":"FeatureCollection",
   "version":"draft"
}
```

Vous remarquerez qu'en recherchant `6 rue Jean Roisin`, l'API retrouve une adresse avec des coordonnées `WSG84` dans le tableau `coordinates`: `[3.062103,50.636488]`.
Ces coordonnées peuvent être utilisées pour recherche l'antenne la plus proche:

> curl -i https://data.anfr.fr/api/records/1.0/search/?dataset=observatoire_2g_3g_4g&geofilter.distance=50.636488%2C3.062103%2C100

Le paramètre `geofilter.distance` contient les coordonnées suivies d'une distance limite dans laquelle faire la recherche.
Il est possible d'ajouter un paramètre `refine.generation` pour filtrer sur la génération et/ou `refine.adm_lb_nom` pour filtrer sur l'aménageur.

#### Design

```
+++++++++++++++    ++++++++
+ API Adresse +    + ANFR + 
+++++++++++++++    ++++++++
        ^              ^
        |              |
     +++++++++++++++++++++
     +      GraphQL      +
     +++++++++++++++++++++
              ^
              |
     +++++++++++++++++++++
     + Client (JS, Java) +
     +++++++++++++++++++++  
```

Le client enverra une requête HTTP sur le serveur avec une requête `GraphQL` permettant de rechercher une adresse et de la retourner avec son antenne la plus proche.
Plusieurs antennes pourront être retournées selon différentes combinaisons de critères de recherche (aménageur et génération).

Le serveur réalisera les appels nécessaires sur les sources de données (API adresse et ANFR) pour honorer la requête du client.

#### Côté serveur

##### 1. Initialisation

Initialisez un projet Hello World en suivant le guide de démarrage : http://graphql.org/graphql-js/
Mettez ensuite un place un serveur HTTP : http://graphql.org/graphql-js/running-an-express-graphql-server/

Nous avons une base que nous allons développer à l'aide de nos APIs.

##### 2. Rechercher une ville

Enrichissez le schéma avec un type `Query` pour la recherche :

```grahql
type Query {
    search(query : String!) : City 
}
```

Déclarez un type `GPS` qui contiendra la latitude et la longitude.
Déclarez ensuite un type `City` avec des propriétés `coordinates`, `zipCode` et `city`.
Ajoutez les classes qui correspondent à ces types.

Dans votre objet `root`, ajouter une propriété `search` associée à une fonction qui permet de rechercher une `City`.
Pour envoyer une requête HTTP avec la `query` vers l'API adresse, utilisez le projet `request`: https://github.com/request/request

Testez votre API dans `GraphiQL`.

##### 3. Variables

Vous pouvez mettre votre adresse recherchée dans une variable et la prendre en paramètre de votre requête.
Appuyez vous sur la spécification pour externaliser la valeur de recherche : http://graphql.org/learn/queries/#variables
Dans `GraphiQL`, une fenêtre en bas à gauche permet de déclarer les variables utilisées dans votre requête.

##### 4. Rechercher antenne

Ajoutez un type `NearestAntenna` au schéma :

```graphql
  type NearestAntenna {
    coordinates: GPS
    generation: String
    provider: String
    lastUpdate: String
    status: String
    dist: Int
    addressLabel: String
    city: String
    insee: String
  }
```

Enrichissez ensuite le type `City` pour ajouter une propriété `nearestAntenna`.
Cette propriété prendra en paramètre deux variables optionelles `generation` et `provider` permettant de retourner un `NearestAntenna` suivant plusieurs critères.
Ajoutez la classe `NearestAntenna`.
 
Enrichissez la classe `City` pour respecter le nouveau schéma.
Appuyez vous sur le tutoriel suivant afin de comprendre comment passer les arguments: http://graphql.org/graphql-js/passing-arguments/
Dans la fonction `nearestAntenna` de `City`, utilisez `this.coordinates` pour rechercher l'antenne la plus proche.
Tenez compte des arguments qui sont optionnels.

##### 5. Enumération

Quand on recherche l'antenne en fonction de critères, on peut énumérer les `provider` et les `génération` possibles.
Modifiez le type `City` pour que l'argument `provider` soit de type `Provider`.
Déclarez dans votre schéma l'énumération `Provider`: http://graphql.org/learn/schema/#enumeration-types

Il faut pouvoir spécifier des valeurs différentes des clés à utiliser (par exemple `BOUGYES TELECOM` plutôt que `BOUYGUES_TELECOM`).
`graphql-js` va détecter tous les types qui existent dans `ES6`.
Par exemple, il a résolu votre classe `City` de façon transparente.
En revanche, les énumérations n'existent pas dans `ES6`, il faut donc utiliser la notion de `resolvers` introduite par le projet `Apollo`: https://www.apollographql.com/docs/graphql-tools/resolvers.html
Installez `graphql-tools` via `npm`.
Ensuite dans votre variable `resolverMap`, ajoutez une propriété `Provider` qui sera un objet avec une propriété correspondant à chaque énumération associée à la valeur à utiliser.

N'oubliez pas d'ajouter votre `resolver` au schéma avec la fonction `addResolveFunctionsToSchema`.

Testez vos changements avec `GraphiQL`.

##### 6. Héritage et polymorphisme

Testez l'API adresse avec ces 3 requêtes différentes :

* 6 rue jean roisin lille
* rue jean roisin lille
* lille

Vous remarquerez que la structure de la réponse diffère:

* si le `type` est `housenumber`, la réponse contient les champs `city`, `street` et `housenumber`
* si le `type` est `street`, la réponse contient les champs `city` et `name` (ce dernier contient le libellé de la voie)
* si le `type` est `city`, la réponse contient les champs `city` et `name` (les valeurs sont les mêmes)

Nous allons modifier le type de retour de `search` afin de créer un type et des champs différents selon le `type` retourné par l'API adresse.

Déclarez dans votre schéma une interface `BaseAddress` qui correspond exactement à la description de `City` : http://graphql.org/learn/schema/#interfaces
Puis faites en sorte que `City` implémente `BaseAddress`.
Créez deux types `Street` et `HouseNumber` qui implémentent également cette interface et définissent les champs supplémentaires qui leur sont propre.

Côté Javascript, crééz les classes correspondantes.
`BaseAddress` sera une classe étendue par `City`, `Street` et `HouseNumber`.
Evidemment, votre classe `BaseAddress` sera celle qui contiendra la fonction `nearestAntenna`.

Ajustez la fonction `search` pour instantier la bonne classe selon la réponse de l'API adresse.
`GraphQL` n'est pas capable de déterminer tout seul le type retourné dynamiquement par `search`.
Là encore, `graphql-tools` est là pour nous aider.
Ajoutez à votre `resolveMap` une propriété `__resolveType` qui sera invoquée avec un objet de type `City`, `Street` ou `HouseNumber` passé en paramètre.
Retournez un chaîne de caractères `HouseNumber`, `Street` ou `City` selon les propriétés présentes dans l'objet :

* Si la propriété `houseNumber` existe, c'est un type `HouseNumber`
* Sinon si la propriété `street` existe, c'est un type `Street`
* Sinon c'est un type `City`

Dans votre requête, vous pouvez spécifier les champs que vous souhaitez sélectionner sleon le type retourné avec les `inline fragments`: http://graphql.org/learn/queries/#inline-fragments
Ajoutez trois fragments pour le cas où le type retourné est `City`, `Street` ou `HouseNumber`.
Dans chacun des fragments, sélectionnez tous les champs disponibles.

##### 7. DRY avec les fragments

On souhaite avoir pour l'adresse trouvée l'antenne la plus proche de chaque aménageur.
Déclarez autant de `nearestAntenna` qu'il y a d'aménageur dans votre requête.
Pour se faire, vous devrez avoir recours aux alias car chaque propriété doit avoir un nom distinct : http://graphql.org/learn/queries/#aliases

Vous remarquez que vous avez 4 blocs fortement similaires.
Factorisez les avec les fragments : http://graphql.org/learn/queries/#fragments

#### Côté client (Javascript)

Nous allons exécuter maintenant notre requête à l'aide d'un client exécuté via `NodeJs` plutôt qu'en passant par `GraphiQL`. Nous allons nous appuyez sur `apollo-client`:  https://github.com/apollographql/apollo-client

Initialisez un nouveau projet avec le `package.json` suivant : https://github.com/gdrouet/nightclazz-graphql/edit/master/apollo/node/package.json

Vous remarquez qu'en plus des dépendances `Apollo`, nous nous appuyons sur `babel` pour transpiler notre code. Nous pouvons donc utiliser `import` plutôt que `require`. Le projet s'exécutera donc avec la commande `npm start`.

Notez également que nous importons `node-fetch` qui est une dépendance interne de `Apollo` qui n'est pas disponible par défaut dans `NodeJS`. Nous allons voir comment l'utiliser dans la configuration de la librairie.

Créez un fichier `index.js` et suivez les instruction de la page GitHub pour initialiser votre client : https://github.com/apollographql/apollo-client#usage

Dans l'objet de configuration passé en paramètre du constructeur de  `HttpLink`, indiquez les propriétés suivantes :

* `uri` : l'URL du serveur `GraphQL` local
* `fetch`: la fonction `fetch` que vous pouvez importer de son module via `import fetch from 'node-fetch';`

Invoquez maintenant la fonction `query` de votre client en vous basant sur la requête que vous utilisiez dans `GraphiQL`. Les variables peuvent être spécifiées dans une propriété `variables`, à côté de `query`:

> client.query({ query: ..., variables: ...});

Vous pouvez passer votre recherche en paramètre de votre programme `NodeJS` comme ceci :

> npm start 6 rue jean roisin

Pour la récupérer, utilisez la variable globale `process.argv`.

Testez votre programme.

Si votre requête contient des fragments, vous devez indiquer à `graphql-client` comment les résoudre. Pour ce faire, suivez les instructions de cette page pour créer un `IntrospectionFragmentMatcher` : https://www.apollographql.com/docs/react/recipes/fragment-matching.html

#### Côté client (Java)

En `Java`, le projet `apollo-android` propose tout un outillage pour générer des classes à partir d'un schéma et d'un ensemble de requêtes `GraphQL` et pour les exécuter au runtime : https://github.com/apollographql/apollo-client

Les exemples sont adaptés pour un développement `Android` et ne sont pas satisfaisant pour écrire un client `Java` simple. Nous allons donc nous appuyer uniquement sur les composants de ce projet dont nous avons besoin.

Créez un projet `Maven` avec le `pom.xml` suivant : https://github.com/gdrouet/nightclazz-graphql/blob/master/apollo/java/pom.xml

Nous avons dans ce projet deux dépendances :

* `compiler` pour générer les classes `Java` dont nous avons besoin
* `apollo-runtime` pour exécuter les requêtes générées

La génération en `Java` est un peu sophistiquée : il faut en fait d'abord passer par le projet `apollo-codegen` pour générer les fichiers dont le projet `compiler` a besoin : https://github.com/apollographql/apollo-codegen

Nous allons réaliser la génération des classes étape par étape.
Installez `apollo-codegen` comme indiqué dans le README du projet GitHub.
Suivez les instructions et générez le client en spécifiant `--output operation-result-types.json` afin de générer un fichier exploitable par le `compiler` qui va générer nos classes `Java`.

A présent, vous pouvez générer vos classes à l'aide du code suivant qui exécute le module `compiler` en se basant sur les fichiers stockés dans `src/main/graphql` : https://github.com/gdrouet/nightclazz-graphql/blob/master/apollo/java/src/main/java/Generate.java

Vous obtiendez les classes à déplacer dans `src/main/java`. Créez un main qui utilise `apollo-runtime` : https://github.com/apollographql/apollo-android/#consuming-code

Testez votre client.