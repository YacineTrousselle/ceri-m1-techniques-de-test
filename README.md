# Pokedex de BG 😎

Yacine Trousselle M1-ILSEN-ALT

## Les badges 🆒

[![codecov](https://codecov.io/gh/YacineTrousselle/ceri-m1-techniques-de-test/graph/badge.svg?token=IQYS58XCAH)](https://codecov.io/gh/YacineTrousselle/ceri-m1-techniques-de-test)
[![CircleCI](https://dl.circleci.com/status-badge/img/gh/YacineTrousselle/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/YacineTrousselle/ceri-m1-techniques-de-test/tree/master)
![Checkstyle](./badges/checkstyle-result.svg)

## Tools 🛠️

- Projet Maven
- Junit & Mockito
- CircleCI
- Codecov
- Checkstyle
- GitHub Pages

## Pourquoi l'implémentation de la Team Rocket est complétement nulle ? 😡

* Ils n'ont pas Bulbizarre à l'index 0
* Ils génèrent des valeurs aléatoires pour les niveaux d'attaque, de défense et de stamina si l'index est positif
* Les niveaux d'attaque, de défense et de stamina sont égales à 1000 si l'index est négatif
* On peut insérer un index pour lequel il n'y a pas de pokémon
* La fonction generateRandomStat est horrible, c'est un massacre algorithmique
* Pourquoi y'a du random ? On est censé se baser sur les stats de base de l'espèce et le niveau de l'individu
* L'iv est parfois égale à 0, parfois égale à 1

Conclusion: la récupération des infos de base de l'espèce est à revoir totalement et les conditions fumeuses sur le
signe de l'index à retirer

---

# Sujet

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques
de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante :

- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous
n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la
main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
