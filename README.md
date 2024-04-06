# Consignes

L'exercice consiste à **écrire les classes demandées** à partir :

- de **diagrammes UML**, disponibles dans le répertoire `uml`,
- de la **documentation _Javadoc_**, disponible dans le répertoire `docs`,
- de **précisions éventuelles** données ci-dessous.

La suite décrit étape par étape ce qui est attendu.

## Etape 0 : Mise en place du projet

Le répertoire `src` contient initialement :

- la classe `TimeUtilities`, qui est fournie complète (ainsi que sa documentation Javadoc) afin d'aider l'écriture des autres classes.
- la classe `Main`, qui est fournie complète, et dont la sortie console est :
```
23:59:59
```

:warning: **Ces 2 classes ne doivent plus être modifiées par la suite**.

### Travail à réaliser

- :arrow_down: **Dupliquer** (_fork_) ce dépôt et le **cloner**.
- :wrench: **Configurer le projet** (_sdk >= 8_, sources dans `src`) de sorte que l'application `Main` puisse être compilée et exécutée.
- :white_check_mark: **Exécuter l'application et vérifier que la sortie console est conforme à ce qui est attendu** (cf. ci-dessus).
- :label: **Effectuer un commit** des fichiers de configuration modifiés, en indiquant `0-Configuration` comme message.
- :rocket: **Pousser immédiatement** le commit sur Gitlab.
- :eyes: **Vérifier** que le commit est bien disponible sur Gitlab.

:warning: **Se manifester en cas de problème à cette étape**.

## Etape 1 :  classes `TimeSlot` et `TimeSlotMain`

:warning: Le diagramme de classes correspondant à cette étape est `TimeSlotClassDiagram.png`.

### Complément de spécifications

#### Classe `TimeUtilities`

:warning: Cette classe est fournie complète, elle n'est ni à écrire, ni à modifier.

Cette classe contient des **constantes** et des **méthodes** utiles pour représenter et manipuler des heures.

Les heures sont par la suite exprimées en _nombre de secondes écoulées depuis minuit_.

Par exemple :
- `0` représente `00:00:00` (minuit)
- `7265` représente `02:01:05`
- `86399` représente `23:59:59`

La méthode `timeToString` permet de représenter une heure (exprimée en nombre de secondes écoulées depuis minuit)
sous la forme d'une chaine de caractères (au format `hh:mm:ss`).

La méthode `stringToTime` permet de convertir une chaine de caractères (représentant une heure au format `hh:mm:ss`)
en une heure (exprimée en nombre de secondes écoulées depuis minuit).

#### Classe `TimeSlot`

`TimeSlot` représente un **intervalle de temps** (heure de debut et durée).

Les heures sont représentées en nombre de secondes écoulées depuis minuit.

La méthode `overlaps` indique si un intervalle de temps (`A` dans la suite) chevauche un autre intervalle de temps (`B` dans la suite).
Il y a chevauchement si l'une des 4 conditions suivantes est vraie:

- l'heure de début de `B` est inférieure ou égale à l'heure de début de `A` **ET** l'heure de fin de `B` est strictement supérieure à l'heure de début de `A`
- l'heure de début de `B` est strictement inférieure à l'heure de fin de `A` **ET** l'heure de fin de `B` est supérieure ou égale à l'heure de fin de `A`
- l'heure de début de `B` est supérieure ou égale à l'heure de début de `A` **ET** l'heure de fin de `B` est inférieure ou égale à l'heure de fin de `A`
- l'heure de début de `B` est inférieure ou égale à l'heure de début de `A` **ET** l'heure de fin de `B` est supérieure ou égale à l'heure de fin de `A`

La méthode `toString` retourne une description texte de l'intervalle de temps sous la forme `"'[' debut ' -> ' fin']'"`,
où `debut` et `fin` sont les représentations des heures de début et fin au format `hh:mm:ss`.

#### Classe `TimeSlotMain`

Cette **application** permet de valider rapidement le fonctionnement de la classe `TimeSlot`.

Le scénario de validation est le suivant:

- création du time slot `[08:00:00 -> 11:00:00]` et stockage de sa référence dans une variable `timeSlot1`.
- affichage dans la console du message `"Time slot 1: "`.
- affichage dans la console de l'heure de début (au format `hh:mm:ss`, voir `TimeUtilities`) précédée du message `"Start time: "`.
- affichage dans la console de l'heure de fin (au format `hh:mm:ss`) précédée du message `"End time: "`.
- affichage dans la console de la durée précédée du message `"Duration: "`.
- affichage dans la console de la représentation texte du time slot.
- affichage dans la console si chevauchement avec `timeSlot1` précédé du message `"TimeSlot1 overlaps: "`.
- affichage dans la console d'une ligne vide.
- création du time slot `[06:00:00 -> 07:00:00]` et stockage de sa référence dans une variable `timeSlot2`.
- affichage dans la console du message `"Time slot 2: "`.
- affichage dans la console de l'heure de début (au format `hh:mm:ss`) précédée du message `"Start time: "`.
- affichage dans la console de l'heure de fin (au format `hh:mm:ss`) précédée du message `"End time: "`.
- affichage dans la console de la durée précédée du message `"Duration: "`.
- affichage dans la console de la représentation texte.
- affichage dans la console si chevauchement avec `timeSlot1` précédé du message `"TimeSlot1 overlaps: "`.

La sortie console attendue lors de l'exécution de cette application est :

```
Time slot 1:
Start time: 08:00:00
End time: 11:00:00
Duration: 10800
[08:00:00 -> 11:00:00] 
TimeSlot1 overlaps: true

Time slot 2:
[06:00:00 -> 07:00:00] 
TimeSlot1 starts before: false
TimeSlot1 ends after: true
TimeSlot1 overlaps: false
```

### Travail à réaliser

- :pencil: **Ecrire la classe `TimeSlot`**.
- :pencil: **Ecrire l'application `TimeSlotMain`**.
- :white_check_mark: **Exécuter l'application et vérifier que la sortie console est conforme à ce qui est attendu** (cf. ci-dessus).
- :label: **Effectuer un commit** des classes `TimeSlot` et `TimeSlottMain`, en indiquant `1-TimeSlot` comme message.
  En cas de besoin, détailler le message de commit.
- :rocket: **Pousser immédiatement** le commit sur Gitlab.
- :eyes: **Vérifier** que le commit est bien disponible sur Gitlab.

## Etape 2 : classes `Appointment` et `AppointmentMain`

:warning: Le diagramme de classes correspondant à cette étape est `AppointmentClassDiagram.png`.

### Complément de spécifications

#### Classe `Appointment`

`Appointment` représente un **rendez-vous**, défini par un label et un intervalle de temps.

La méthode `overlaps` indique si un rendez-vous (`A` dans la suite) chevauche un autre rendez-vous (`B` dans la suite).
Il y a chevauchement si les intervalles de temps de `A` et `B` se chevauchent.

La méthode `toString` retourne une description texte du rendez-vous sous la forme `"intervalle ' ' label"`,
où `intervalle` est la représentation texte de l'intervalle de temps.

#### Classe `AppointmentMain`

Cette **application** permet de valider rapidement le fonctionnement de la classe `Appointment`.

Le scénario de validation est le suivant:

- création du time slot `[08:00:00 -> 11:00:00]` et stockage de sa référence dans une variable `timeSlot1`.
- création du time slot `[11:00:00 -> 12:00:00]` et stockage de sa référence dans une variable `timeSlot2`.
- création du time slot `[09:00:00 -> 10:00:00]` et stockage de sa référence dans une variable `timeSlot3`.
- création d'un tableau regroupant les références des objets précédents, dans l'ordre,
  et stockage  de sa référence dans une variable `timeSlots`.
- itération sur les time slots du tableau, et à chaque tour :
    - affichage dans la console d'une ligne vide.
    - affichage dans la console du numéro du time slot (à partir de `1`), précédé du message `"Appointment "` et suivi de `":"`.
    - création d'un rendez-vous avec le time slot courant et pour label `"appointment` suivi du numéro du tour (à partir de `1`),
      et stockage  de sa référence dans une variable `appointment`.
    - affichage dans la console de la représentation texte du time slot (obtenu par appel de méthode sur le rendez-vous), précédé du message `"Time slot: "`.
    - affichage dans la console du label du rendez-vous (obtenu par appel de méthode sur le rendez-vous).
    - affichage dans la console de la représentation texte du rendez-vous.

La sortie console attendue lors de l'exécution de cette application est :

```

Appointment 1:
Time slot: [08:00:00 -> 11:00:00] 
appointment1
[08:00:00 -> 11:00:00]  appointment1

Appointment 2:
Time slot: [11:00:00 -> 12:00:00] 
appointment2
[11:00:00 -> 12:00:00]  appointment2

Appointment 3:
Time slot: [09:00:00 -> 10:00:00] 
appointment3
[09:00:00 -> 10:00:00]  appointment3

```
### Travail à réaliser

- :pencil: **Ecrire la classe `Appointment`**.
- :pencil: **Ecrire l'application `AppointmentMain`**.
- :white_check_mark: **Exécuter l'application et vérifier que la sortie console est conforme à ce qui est attendu** (cf. ci-dessus).
- :label: **Effectuer un commit** des classes `Appointment` et `AppointmentMain`, en indiquant `2-Appointment` comme message.
  En cas de besoin, détailler le message de commit.
- :rocket: **Pousser immédiatement** le commit sur Gitlab.
- :eyes: **Vérifier** que le commit est bien disponible sur Gitlab.

## Etape 3 : classes `SessionSchedule` et `SessionScheduleMain`

:warning: Le diagramme de classes correspondant à cette étape est `SessionScheduleClassDiagram.png`.

### Complément de spécifications

#### Classe `SessionSchedule`

`SessionSchedule` représente une **session de rendez-vous**, définie par un intervalle de temps et un ensemble de rendez-vous sur cet intervalle.

Le nombre maximal de rendez-vous par session est fixé à `4`.

La méthode `addAppointment` permet d'ajouter un rendez-vous et retourne un booléen indiquant si l'ajout a été effectué.
L'ajout d'un rendez-vous échoue si au moins une des conditions suivantes est vraie :

- le nombre maximum de rendez-vous de la session est atteint
- l'heure de début du rendez-vous est strictement inférieure à celle de la session
- l'heure de fin du rendez-vous est strictement supérieure à celle de la session
- la durée du rendez-vous est nulle
- le rendez-vous chevauche un rendez-vous existant

La méthode `getSortedAppointments()` retourne une **copie** du tableau des rendez-vous de la session. 

Le tableau résultat :
- a pour **taille exacte** le nombre de rendez-vous,
- est trié par **ordre croissant des heures de début** des rendez-vous.

l'algorithme pour le tri à utiliser est celui du _tri par sélection_, rappelé ci-dessous :

```
procédure tri_selection(tableau t)
  n ← longueur(t)
  pour i de 0 à n - 2 inclus
    min ← i       
    pour j de i + 1 à n - 1 inclus
      si t[j] < t[min], alors min ← j
    fin pour
    si min ≠ i, alors échanger t[i] et t[min]
  fin pour
fin procédure
```

La méthode `toString` retourne une description texte de la session sous la forme :
```
[08:00:00 -> 12:00:00]: 2 appointment(s)
- [08:00:00 -> 09:00:00] an appointment
- [10:00:00 -> 11:00:00] another appointment
```
- la première ligne contient la représentation texte de la session, suivi de `: ` et du nombre de rendez-vous.
- les lignes suivantes représentent un rendez-vous par ligne précédé de `-`. Les rendez-vous sont triés par heure de début.

Dans le cas particulier où la session est libre, la méthode `toString` retourne `(free session)`.

#### Classe `SessionScheduleMain`

Cette **application** permet de valider rapidement le fonctionnement de la classe `SessionSchedule`.

Le scénario de validation est le suivant:

- création du time slot `[08:00:00 -> 12:00:00]` et stockage de sa référence dans une variable `timeSlot`.
- création d'une nouvelle session à partir du time slot précédent, et stockage de sa référence dans une variable `session`.
- affichage dans la console de la représentation texte de la session.
- création du time slot `[08:00:00 -> 10:00:00]` et stockage de sa référence dans une variable `timeSlot1`.
- création du time slot `[07:00:00 -> 08:00:00]` et stockage de sa référence dans une variable `timeSlot2`.
- création du time slot `[11:00:00 -> 12:00:00]` et stockage de sa référence dans une variable `timeSlot3`.
- création du time slot `[10:00:00 -> 11:00:00]` et stockage de sa référence dans une variable `timeSlot4`.
- création d'un tableau regroupant les références des 4 time slots précédents, dans l'ordre,
  et stockage  de sa référence dans une variable `appointmentTimeSlots`.
- itération sur les time slots du tableau, et à chaque tour :
    - affichage dans la console d'une ligne vide.
    - affichage dans la console du numéro du time slot (à partir de `1`), précédé du message `"appointment "` et suivi de `":"`
    - création d'un rendez-vous avec le time slot courant et pour label `"appointment` suivi du numéro du tour (à partir de `1`),
      et stockage  de sa référence dans une variable `appointment`.
    - affichage dans la console de la représentation texte du rendez-vous.
    - affichage dans la console du résultat de l'ajout du rendez-vous, précédé du message `"added: "`.
- affichage dans la console d'une ligne vide.
- affichage dans la console de la représentation texte de la session.

La sortie console attendue lors de l'exécution de cette application est :

```
(free session)

appointment 1:
[08:00:00 -> 10:00:00]  appointment1
added: true

appointment 2:
[07:00:00 -> 08:00:00]  appointment2
added: false

appointment 3:
[11:00:00 -> 12:00:00]  appointment3
added: true

appointment 4:
[10:00:00 -> 11:00:00]  appointment4
added: true

[08:00:00 -> 12:00:00] : 3 appointment(s)
- [08:00:00 -> 10:00:00]  appointment1
- [10:00:00 -> 11:00:00]  appointment4
- [11:00:00 -> 12:00:00]  appointment3

```
### Travail à réaliser

- :pencil: **Ecrire la classe `SessionSchedule`**.
- :pencil: **Ecrire l'application `SessionScheduleMain`**.
- :white_check_mark: **Exécuter l'application et vérifier que la sortie console est conforme à ce qui est attendu** (cf. ci-dessus).
- :label: **Effectuer un commit** des classes `SessionSchedule` et `SessionScheduleMain`, en indiquant `3-SessionSchedule` comme message.
  En cas de besoin, détailler le message de commit.
- :rocket: **Pousser immédiatement** le commit sur Gitlab. 
- :eyes: **Vérifier** que le commit est bien disponible sur Gitlab.