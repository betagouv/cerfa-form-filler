Cerfa-form-filler
=================

Ce service est une API REST qui permet de préremplir un certain nombre de formulaires Cerfa servant à effectuer des demandes d'aides sociales.
Cette API doit être vue comme un "necessary evil" et n'a pas vocation à durer dans le temps, car elle remplit des formulaires PDF qui ne devraient pas exister dans un État qui se dit numérique.
La stack Java/Play Framework 2 a été choisie car c'est la seule stack avec une librairie PDF qui tient la route.
Licence AGPL, cf. le fichier "LICENSE".